package org.haiykut.libraryy.services.dtos.requests.book;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddBookRequest {
    private String name;
    private String author;
    private int categoryId;
    private int page;
    private int bookCount;
}
