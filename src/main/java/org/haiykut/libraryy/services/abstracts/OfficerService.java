package org.haiykut.libraryy.services.abstracts;

import org.haiykut.libraryy.entities.Book;
import org.haiykut.libraryy.entities.Officer;
import org.haiykut.libraryy.services.dtos.OfficerForAddDto;
import org.haiykut.libraryy.services.dtos.RentRequestDto;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public interface OfficerService {
    void add(OfficerForAddDto dto);
    void update(int id,OfficerForAddDto officer);
    void delete(int id);
    List<Officer> getAll();
    Officer getById(int id);
    boolean theBookDamaged(Book book);
    void checkPunishment(LocalDateTime rentDate, LocalDateTime deliveryDate);
    String rentBook(RentRequestDto dto) throws IOException;
    String deliverBook(int officerId, RentRequestDto dto);

}
