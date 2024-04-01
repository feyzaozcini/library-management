package org.haiykut.libraryy.services.abstracts;

import org.haiykut.libraryy.entities.Book;
import org.haiykut.libraryy.services.dtos.requests.book.AddBookRequest;
import org.haiykut.libraryy.services.dtos.requests.book.UpdateBookRequest;
import org.haiykut.libraryy.services.dtos.responses.Book.AddBookResponse;
import org.haiykut.libraryy.services.dtos.responses.Book.GetBookResponse;
import org.haiykut.libraryy.services.dtos.responses.Book.UpdateBookResponse;

import java.util.List;

public interface BookService {
    AddBookResponse add(AddBookRequest dto);

    void deleteById(int id);
    UpdateBookResponse updateById(int id, UpdateBookRequest dto);

    List<GetBookResponse> getAllBooks();
    GetBookResponse getBookById(int id);

}
