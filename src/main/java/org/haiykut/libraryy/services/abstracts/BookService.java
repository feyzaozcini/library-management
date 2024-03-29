package org.haiykut.libraryy.services.abstracts;

import org.haiykut.libraryy.entities.Book;
import org.haiykut.libraryy.services.dtos.BookAddDto;
import org.haiykut.libraryy.services.dtos.BookUpdateDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BookService {
    public ResponseEntity<BookAddDto> add(BookAddDto dto);

    public ResponseEntity<String> deleteById(int id);
    public ResponseEntity<BookUpdateDto> updateById(int id, BookUpdateDto dto);

    public ResponseEntity<List<Book>> getAllBooks();
    public ResponseEntity<Book> getBookById(int id);

}
