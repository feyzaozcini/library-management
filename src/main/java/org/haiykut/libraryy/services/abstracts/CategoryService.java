package org.haiykut.libraryy.services.abstracts;

import org.haiykut.libraryy.entities.Book;
import org.haiykut.libraryy.entities.Category;
import org.haiykut.libraryy.services.dtos.requests.book.BookAddDto;
import org.haiykut.libraryy.services.dtos.requests.book.BookUpdateDto;
import org.haiykut.libraryy.services.dtos.requests.category.CategoryAddRequestDto;
import org.haiykut.libraryy.services.dtos.requests.category.CategoryUpdateRequestDto;
import org.haiykut.libraryy.services.dtos.responses.CategoryAddResponseDto;
import org.haiykut.libraryy.services.dtos.responses.CategoryListDto;

import java.util.List;

public interface CategoryService {
    CategoryAddResponseDto add(CategoryAddRequestDto dto);

    String deleteById(int id);
    String updateById(int id, CategoryUpdateRequestDto dto);

    List<Category> getAllCategories();
    Category getCategoryById(int id);
}
