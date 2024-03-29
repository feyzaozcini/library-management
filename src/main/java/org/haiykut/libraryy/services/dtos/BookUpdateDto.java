package org.haiykut.libraryy.services.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookUpdateDto {
    private String name;
    private String author;
    private int categoryId;
    private int page;
    private int bookCount;
}
