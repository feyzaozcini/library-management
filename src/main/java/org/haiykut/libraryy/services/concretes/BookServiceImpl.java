package org.haiykut.libraryy.services.concretes;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.haiykut.libraryy.entities.Book;
import org.haiykut.libraryy.entities.Category;
import org.haiykut.libraryy.repositories.BookRepository;
import org.haiykut.libraryy.repositories.CategoryRepository;
import org.haiykut.libraryy.services.abstracts.BookService;
import org.haiykut.libraryy.services.dtos.requests.book.AddBookRequest;
import org.haiykut.libraryy.services.dtos.requests.book.GetBookRequest;
import org.haiykut.libraryy.services.dtos.requests.book.UpdateBookRequest;
import org.haiykut.libraryy.services.dtos.responses.Book.AddBookResponse;
import org.haiykut.libraryy.services.dtos.responses.Book.GetBookResponse;
import org.haiykut.libraryy.services.dtos.responses.Book.UpdateBookResponse;
import org.haiykut.libraryy.services.mappers.BookMapper;
import org.haiykut.libraryy.services.mappers.CategoryMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;
    @Override
    public AddBookResponse add(AddBookRequest request) {
       /* Book newBook = new Book();
        newBook.setName(dto.getName());
        newBook.setAuthor(dto.getAuthor());
        newBook.setPage(dto.getPage());
        newBook.setCategory(categoryRepository.findById(dto.getCategoryId()).orElseThrow(()-> new RuntimeException("Cant find a category of the related id!")));
        newBook.setBookCount(dto.getBookCount());
        bookRepository.save(newBook);*/

        Book savedBook=bookRepository.save(BookMapper.INSTANCE.bookFromRequest(request));
        //category id ile ilgili bir hata
        //category id bulunamasaydı?
        //program çalışıyor ama ekleme yapmıyor
        AddBookResponse response= new AddBookResponse(savedBook.getId(),savedBook.getName(),savedBook.getAuthor(),savedBook.getCategory().getId(),savedBook.getBookCount(),savedBook.getBookCount());
        return response;
    }

    @Override
    public String deleteById(int id) {
        bookRepository.deleteById(id);
        return "Silindi!";
    }

    @Override
    public UpdateBookResponse updateById(int id, UpdateBookRequest request) {
        /*Book requestedBook = bookRepository.findById(id).orElseThrow(()-> new RuntimeException("Cant find a book of the related id!"));
        requestedBook.setName(dto.getName());
        requestedBook.setBookCount(dto.getBookCount());
        requestedBook.setPage(dto.getPage());
        requestedBook.setAuthor(dto.getAuthor());
        requestedBook.setCategory(categoryRepository.findById(dto.getCategoryId()).orElseThrow());
        bookRepository.save(requestedBook);*/
        Book book=BookMapper.INSTANCE.bookFromRequest(request);
        Book updatedBook=bookRepository.save(book);
        UpdateBookResponse response=new UpdateBookResponse(updatedBook.getName(),updatedBook.getAuthor(),updatedBook.getCategory().getId(),updatedBook.getPage(),updatedBook.getBookCount());
        return response;

    }

    @Override
    public List<GetBookResponse> getAllBooks() {
        List<Book> books=bookRepository.findAll();
        List<GetBookResponse> bookResponses = new ArrayList<>();
        for (Book book : books) {
            GetBookResponse response = BookMapper.INSTANCE.bookFromResponse(book);
            bookResponses.add(response);
        }
        return bookResponses;
    }

    @Override
    public GetBookResponse getBookById(int id) {
        /*Book book=bookRepository.findById(id).orElseThrow(()-> new RuntimeException("Cant find a book of the related id!"));
        Category category = categoryRepository.findById(book.getCategory().getId())
                .orElseThrow(() -> new RuntimeException("Can't find the category of the book!"));*/
        Book book=bookRepository.findById(id).orElseThrow(()-> new RuntimeException("Cant find a book of the related id!"));
        GetBookResponse response=BookMapper.INSTANCE.bookFromResponse(book);
        return response;    }
}
