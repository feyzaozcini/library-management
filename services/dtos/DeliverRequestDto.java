package org.haiykut.libraryy.services.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeliverRequestDto {
    private int memberId;
    private int bookId;
    private String message;
}
