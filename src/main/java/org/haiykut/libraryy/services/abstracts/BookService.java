package org.haiykut.libraryy.services.abstracts;

import org.haiykut.libraryy.entities.Book;
import org.haiykut.libraryy.services.dtos.requests.book.BookAddRequestDto;
import org.haiykut.libraryy.services.dtos.requests.book.BookUpdateDto;
import org.haiykut.libraryy.services.dtos.responses.Book.BookAddResponseDto;
import org.haiykut.libraryy.services.dtos.responses.Book.BookGetResponseDto;

import java.util.List;

public interface BookService {
    BookAddResponseDto add(BookAddRequestDto dto);

    String deleteById(int id);
    BookUpdateDto updateById(int id, BookUpdateDto dto);

    List<Book> getAllBooks();
    BookGetResponseDto getBookById(int id);

}
