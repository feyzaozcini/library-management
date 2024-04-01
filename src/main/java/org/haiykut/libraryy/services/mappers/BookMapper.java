package org.haiykut.libraryy.services.mappers;

import org.haiykut.libraryy.entities.Book;
import org.haiykut.libraryy.services.dtos.requests.book.AddBookRequest;
import org.haiykut.libraryy.services.dtos.requests.book.GetBookRequest;
import org.haiykut.libraryy.services.dtos.requests.book.UpdateBookRequest;
import org.haiykut.libraryy.services.dtos.responses.Book.GetBookResponse;
import org.haiykut.libraryy.services.dtos.responses.Book.UpdateBookResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    @Mapping(source = "categoryId", target = "category.id")
    Book bookFromRequest(AddBookRequest request);

    @Mapping(source = "categoryId", target = "category.id")
    Book bookFromRequest(UpdateBookRequest request);


    @Mapping(source = "category.id", target = "categoryId")
    GetBookResponse responseFromBook(Book book);

    
}
