package org.haiykut.libraryy.services.concretes;
import lombok.RequiredArgsConstructor;
import org.haiykut.libraryy.core.utils.exceptions.types.BusinessException;
import org.haiykut.libraryy.entities.Book;
import org.haiykut.libraryy.repositories.BookRepository;
import org.haiykut.libraryy.services.abstracts.BookService;
import org.haiykut.libraryy.services.dtos.requests.book.AddBookRequest;
import org.haiykut.libraryy.services.dtos.requests.book.UpdateBookRequest;
import org.haiykut.libraryy.services.dtos.responses.Book.AddBookResponse;
import org.haiykut.libraryy.services.dtos.responses.Book.GetBookResponse;
import org.haiykut.libraryy.services.dtos.responses.Book.UpdateBookResponse;
import org.haiykut.libraryy.services.mappers.BookMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    @Override
    public AddBookResponse add(AddBookRequest request) {
        bookWithSameNameShouldNotExist(request.getName());
        Book savedBook = BookMapper.INSTANCE.bookFromRequest(request);
        bookRepository.save(savedBook);
        return BookMapper.INSTANCE.addResponseFromBook(savedBook);
    }
    @Override
    public void deleteById(int id) {
        bookWithSameIdShouldNotExist(id);
        bookRepository.deleteById(id);
    }

    @Override
    public UpdateBookResponse updateById(int id, UpdateBookRequest request) {
        bookWithSameNameShouldNotExist(request.getName());
        bookWithSameIdShouldNotExist(id);
        Book book = BookMapper.INSTANCE.bookFromRequest(request);
        book.setId(id);
        bookRepository.save(book);
        return BookMapper.INSTANCE.updateResponseFromBook(book);
    }

    @Override
    public List<GetBookResponse> getAllBooks() {
        return bookRepository.findAll().stream().map(book -> BookMapper.INSTANCE.getResponseFromBook(book)).collect(Collectors.toList());
    }

    @Override
    public GetBookResponse getBookById(int id) {
        bookWithSameIdShouldNotExist(id);
        return BookMapper.INSTANCE.getResponseFromBook(bookRepository.findById(id).orElseThrow(()->new RuntimeException("Cant find a book of the related id!")));
    }
    private void bookWithSameNameShouldNotExist(String name){
        if(bookRepository.findByNameIgnoreCase(name).isPresent()){
            throw new BusinessException("A book with this name already exists!");
        }
    }
    private void bookWithSameIdShouldNotExist(int id){
        if(bookRepository.findById(id).isEmpty()){
            throw new BusinessException("Book not found!");
        }
    }

}
