package org.haiykut.libraryy.services.abstracts;

import org.haiykut.libraryy.entities.Category;
import org.haiykut.libraryy.services.dtos.requests.category.CategoryAddRequestDto;
import org.haiykut.libraryy.services.dtos.requests.category.CategoryUpdateRequestDto;
import org.haiykut.libraryy.services.dtos.responses.Category.CategoryAddResponseDto;

import java.util.List;

public interface CategoryService {
    CategoryAddResponseDto add(CategoryAddRequestDto dto);

    String deleteById(int id);
    String updateById(int id, CategoryUpdateRequestDto dto);

    List<Category> getAllCategories();
    Category getCategoryById(int id);
}
