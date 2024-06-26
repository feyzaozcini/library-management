package org.haiykut.libraryy.services.abstracts;

import org.haiykut.libraryy.entities.Book;
import org.haiykut.libraryy.services.dtos.RentRequestDto;
import org.haiykut.libraryy.services.dtos.requests.officer.OfficerAddRequestDto;
import org.haiykut.libraryy.services.dtos.requests.officer.OfficerUpdateRequestDto;

import org.haiykut.libraryy.services.dtos.responses.Officer.OfficerAddResponseDto;
import org.haiykut.libraryy.services.dtos.responses.Officer.OfficerGetDto;
import org.haiykut.libraryy.services.dtos.responses.Officer.OfficerUpdateResponseDto;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public interface OfficerService {
    OfficerAddResponseDto add(OfficerAddRequestDto dto);
    //void updateById(int id, OfficerUpdateRequestDto dto);
    OfficerUpdateResponseDto updateById(int id, OfficerUpdateRequestDto dto);
    void deleteById(int id);
    List<OfficerGetDto> getAllOfficers();
    OfficerGetDto getOfficerById(int id);
    boolean theBookDamaged(Book book);
    void checkPunishment(LocalDateTime rentDate, LocalDateTime deliveryDate);
    String rentBook(RentRequestDto dto) throws IOException;
    String deliverBook(int officerId, RentRequestDto dto);

}
