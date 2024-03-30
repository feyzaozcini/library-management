package org.haiykut.libraryy.services.dtos.responses.Book;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookGetResponseDto {
    private String name;
    private String author;
    private int categoryId;
    private int page;
    private int bookCount;
}
