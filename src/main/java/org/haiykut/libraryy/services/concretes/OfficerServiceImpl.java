package org.haiykut.libraryy.services.concretes;

import lombok.RequiredArgsConstructor;
import org.haiykut.libraryy.entities.*;
import org.haiykut.libraryy.repositories.*;
import org.haiykut.libraryy.services.abstracts.BookService;
import org.haiykut.libraryy.services.abstracts.OfficerService;
import org.haiykut.libraryy.services.dtos.OfficerForAddDto;
import org.haiykut.libraryy.services.dtos.RentRequestDto;
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
    public void add(OfficerForAddDto dto) {
        Officer officer=new Officer();
        officer.setName(dto.getName());
        officer.setPassword(dto.getPassword());
        officer.setEmail(dto.getEmail());
        officer.setPhoneNumber(dto.getPhoneNumber());

        officerRepository.save(officer);
    }


    @Override
    public void update(int id,OfficerForAddDto officer) {
        Officer existingOfficer = officerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Officer not found with id: " + id));

        existingOfficer.setName(officer.getName());
        existingOfficer.setPassword(officer.getPassword());
        existingOfficer.setPhoneNumber(officer.getPhoneNumber());
        existingOfficer.setEmail(officer.getEmail());

        officerRepository.save(existingOfficer);
    }

    @Override
    public void delete(int id) {
        Officer category = officerRepository.findById(id).orElse(null);
        if(category==null)
            throw new RuntimeException("Silinmek istenen kategori bulunamadı.");

        officerRepository.delete(category);
    }

    @Override
    public List<Officer> getAll() {
        return officerRepository.findAll();
    }

    @Override
    public Officer getById(int id) {
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
