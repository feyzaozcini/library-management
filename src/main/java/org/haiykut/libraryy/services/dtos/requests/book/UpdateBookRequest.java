package org.haiykut.libraryy.services.dtos.requests.book;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateBookRequest {
    private String name;
    private String author;
    private int categoryId;
    private int page;
    private int bookCount;
}
