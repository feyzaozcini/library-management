package org.haiykut.libraryy.controllers;
import lombok.RequiredArgsConstructor;
import org.haiykut.libraryy.entities.Book;
import org.haiykut.libraryy.services.abstracts.BookService;
import org.haiykut.libraryy.services.dtos.requests.book.AddBookRequest;
import org.haiykut.libraryy.services.dtos.requests.book.UpdateBookRequest;
import org.haiykut.libraryy.services.dtos.responses.Book.AddBookResponse;
import org.haiykut.libraryy.services.dtos.responses.Book.GetBookResponse;
import org.haiykut.libraryy.services.dtos.responses.Book.UpdateBookResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
    @PostMapping("/add")
    public ResponseEntity<AddBookResponse> add(@RequestBody AddBookRequest request){
        AddBookResponse response=bookService.add(request);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.getId())
                .toUri();
        return ResponseEntity.created(location).body(response);
    }
    @GetMapping("/all")
    //@ResponseStatus(HttpStatus.OK)
    public List<GetBookResponse> getAllBooks(){
        return bookService.getAllBooks();
    }
    @GetMapping("/{id}")
    public GetBookResponse getBookById(@PathVariable int id){

        return bookService.getBookById(id);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable int id){
        return bookService.deleteById(id);
    }
    @PutMapping("/update/{id}")
    public UpdateBookResponse updateById(@PathVariable int id, @RequestBody UpdateBookRequest dto){
        return bookService.updateById(id, dto);
    }
}
