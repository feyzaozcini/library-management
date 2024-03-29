package org.haiykut.libraryy.services.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookAddDto {
    private String name;
    private String author;
    private int categoryId;
    private int page;
    private int bookCount;
}
