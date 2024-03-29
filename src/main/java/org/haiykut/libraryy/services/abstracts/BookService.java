package org.haiykut.libraryy.services.abstracts;

import org.haiykut.libraryy.entities.Book;
import org.haiykut.libraryy.services.dtos.BookAddDto;
import org.haiykut.libraryy.services.dtos.BookUpdateDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BookService {
    ResponseEntity<BookAddDto> add(BookAddDto dto);

    ResponseEntity<String> deleteById(int id);
    ResponseEntity<BookUpdateDto> updateById(int id, BookUpdateDto dto);

    ResponseEntity<List<Book>> getAllBooks();
    ResponseEntity<Book> getBookById(int id);

}
