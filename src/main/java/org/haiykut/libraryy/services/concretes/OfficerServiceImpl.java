package org.haiykut.libraryy.services.concretes;

import lombok.RequiredArgsConstructor;
import org.haiykut.libraryy.entities.*;
import org.haiykut.libraryy.repositories.*;
import org.haiykut.libraryy.services.abstracts.BookService;
import org.haiykut.libraryy.services.abstracts.OfficerService;
import org.haiykut.libraryy.services.dtos.RentRequestDto;
import org.haiykut.libraryy.services.dtos.requests.officer.OfficerAddRequestDto;
import org.haiykut.libraryy.services.dtos.requests.officer.OfficerUpdateRequestDto;
import org.haiykut.libraryy.services.dtos.responses.Officer.OfficerAddResponseDto;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;


@Service
@RequiredArgsConstructor
public class OfficerServiceImpl implements OfficerService  {

    private final OfficerRepository officerRepository;
    private final MemberRepository memberRepository;
    private final BookService bookService;

    @Override
    public OfficerAddResponseDto add(OfficerAddRequestDto dto) {
        Officer officer=new Officer();
        officer.setName(dto.getName());
        officer.setPassword(dto.getPassword());
        officer.setEmail(dto.getEmail());
        officer.setPhoneNumber(dto.getPhoneNumber());
        officerRepository.save(officer);
        return new OfficerAddResponseDto(officer.getId(),officer.getName(),officer.getPassword(), officer.getEmail(), officer.getPhoneNumber());
    }

    @Override
    public void updateById(int id, OfficerUpdateRequestDto member) {
        Officer existingOfficer = officerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Member not found with id: " + id));

        existingOfficer.setName(member.getName());
        existingOfficer.setPassword(member.getPassword());
        existingOfficer.setPhoneNumber(member.getPhoneNumber());
        existingOfficer.setEmail(member.getEmail());

        officerRepository.save(existingOfficer);
    }
    @Override
    public void deleteById(int id) {
        Officer officer = officerRepository.findById(id).orElse(null);
        if(officer==null)
            throw new RuntimeException("Silinmek istenen officer bulunamadı.");

        officerRepository.delete(officer);
    }

    @Override
    public List<Officer> getAllOfficers() {
        return officerRepository.findAll();
    }

    @Override
    public Officer getOfficerById(int id) {
        return officerRepository.findById(id).orElseThrow();
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
        Book book = bookService.getBookById(dto.getBookId());
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


}
