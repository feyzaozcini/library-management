package org.haiykut.libraryy.controllers;

import lombok.RequiredArgsConstructor;
import org.haiykut.libraryy.entities.Book;
import org.haiykut.libraryy.services.abstracts.BookService;
import org.haiykut.libraryy.services.dtos.BookAddDto;
import org.haiykut.libraryy.services.dtos.BookUpdateDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
    @PostMapping("/add")
    public ResponseEntity<BookAddDto> add(@RequestBody BookAddDto dto){
        return bookService.add(dto);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Book>> getAllBooks(){
        return bookService.getAllBooks();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@RequestParam int id){
        return bookService.getBookById(id);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@RequestParam int id){
        return bookService.deleteById(id);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<BookUpdateDto> updateById(@RequestParam int id, @RequestBody BookUpdateDto dto){
        return bookService.updateById(id, dto);
    }
}
