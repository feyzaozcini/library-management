package org.haiykut.libraryy.services.concretes;

import lombok.RequiredArgsConstructor;
import org.haiykut.libraryy.core.utils.exceptions.types.BusinessException;
import org.haiykut.libraryy.entities.*;
import org.haiykut.libraryy.repositories.*;
import org.haiykut.libraryy.services.abstracts.OfficerService;
import org.haiykut.libraryy.services.dtos.RentRequestDto;
import org.haiykut.libraryy.services.dtos.requests.officer.OfficerAddRequestDto;
import org.haiykut.libraryy.services.dtos.requests.officer.OfficerUpdateRequestDto;
import org.haiykut.libraryy.services.dtos.responses.Officer.OfficerAddResponseDto;
import org.haiykut.libraryy.services.dtos.responses.Officer.OfficerGetDto;
import org.haiykut.libraryy.services.dtos.responses.Officer.OfficerUpdateResponseDto;
import org.haiykut.libraryy.services.mappers.OfficerMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class OfficerServiceImpl implements OfficerService  {

    private final OfficerRepository officerRepository;
    private final MemberRepository memberRepository;
    private final BookRepository bookRepository;


    @Override
    public OfficerAddResponseDto add(OfficerAddRequestDto dto) {
        officerWithSameNameShouldNotExist(dto.getName());

        Officer officer= OfficerMapper.INSTANCE.officerFromDto(dto);
        officerRepository.save(officer);
        return OfficerMapper.INSTANCE.addDtoFromOfficer(officer);
    }

    @Override
    public OfficerUpdateResponseDto updateById(int id,OfficerUpdateRequestDto officer){
        officerWithSameNameShouldNotExist(officer.getName());

        Officer requestedOfficer= officerRepository.findById(id).orElseThrow(() -> new RuntimeException("Officer not found!"));
        requestedOfficer.setId(id);
        officerRepository.save(requestedOfficer);

        return OfficerMapper.INSTANCE.updateDtoFromOfficer(requestedOfficer);
    }
    @Override
    public void deleteById(int id) {
        officerWithSameIdShouldNotExist(id);

        officerRepository.deleteById(id);
    }

    @Override
    public List<OfficerGetDto> getAllOfficers() {
        return  officerRepository.findAll().stream().map(officer -> OfficerMapper.INSTANCE.officerGetDtoFromOfficer(officer)).collect(Collectors.toList());
    }

    @Override
    public OfficerGetDto getOfficerById(int id) {
        officerWithSameIdShouldNotExist(id);
        return OfficerMapper.INSTANCE.officerGetDtoFromOfficer(officerRepository.findById(id).orElseThrow());
    }


    @Override
    public boolean theBookDamaged(Book book){
        return false;
    }
    public void checkPunishment(LocalDateTime rentDate, LocalDateTime deliveryDate){
        long diff = ChronoUnit.DAYS.between(rentDate, deliveryDate);
        if(diff>4){
            System.out.println("CEZA!");
        }
    }
    @Override
    public String rentBook(RentRequestDto dto) throws IOException {
        Member member = memberRepository.findById(dto.getMemberId()).orElseThrow();

        Book book = bookRepository.findById(dto.getBookId()).orElseThrow();
        if (member.getHandledBooks().stream().anyMatch(rb -> rb.getBook().getId() == dto.getBookId() && !rb.getComplated())) {
            throw new IOException("Bu kitap daha önce alınmış!");
        }
        else if (book.getBookCount() < 1){
            throw new IOException("Bu kitaptan stokta yeterli sayida yok!");
        }
        RentableBook rentableBook = new RentableBook();
        rentableBook.setMember(member);
        rentableBook.setBook(book);
        rentableBook.setRentDate(LocalDateTime.now());
        member.getHandledBooks().add(rentableBook);
        memberRepository.save(member);
        return "Kitap odunc verildi!";
    }
    @Override
    public String deliverBook(int officerId, RentRequestDto dto) {
        Member member = memberRepository.findById(dto.getMemberId()).orElseThrow();
        member.getHandledBooks().stream()
                .filter(rb -> rb.getBook().getId() == dto.getBookId() && rb.getComplated() == false)
                .forEach(rb -> {
                    rb.setDeliveryDate(LocalDateTime.now());
                    rb.setComplated(true);
                    checkPunishment(rb.getRentDate(), rb.getDeliveryDate());
                    //officerService.equals(rb.getBook());
                });
        memberRepository.save(member);
        return "Kitap basariyla geri alindi!";
    }

    private void officerWithSameNameShouldNotExist(String name){
        if(officerRepository.findByNameIgnoreCase(name).isPresent()){
            throw new BusinessException("A officer with this name already exists!");
        }
    }

    private void officerWithSameIdShouldNotExist(int id){
        if(officerRepository.findById(id).isEmpty()){
            throw new BusinessException("Officer not found!");
        }
    }

}
