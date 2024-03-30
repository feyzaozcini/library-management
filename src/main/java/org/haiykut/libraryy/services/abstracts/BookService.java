package org.haiykut.libraryy.services.abstracts;

import org.haiykut.libraryy.entities.Book;
import org.haiykut.libraryy.services.dtos.requests.book.BookAddDto;
import org.haiykut.libraryy.services.dtos.requests.book.BookUpdateDto;

import java.util.List;

public interface BookService {
    BookAddDto add(BookAddDto dto);

    String deleteById(int id);
    BookUpdateDto updateById(int id, BookUpdateDto dto);

    List<Book> getAllBooks();
    Book getBookById(int id);

}
