package org.haiykut.libraryy.services.abstracts;

import org.haiykut.libraryy.services.dtos.requests.category.CategoryAddRequestDto;
import org.haiykut.libraryy.services.dtos.requests.category.CategoryUpdateRequestDto;
import org.haiykut.libraryy.services.dtos.responses.Category.CategoryAddResponseDto;
import org.haiykut.libraryy.services.dtos.responses.Category.CategoryGetDto;
import org.haiykut.libraryy.services.dtos.responses.Category.CategoryUpdateResponseDto;
import java.util.List;

public interface CategoryService {
    CategoryAddResponseDto add(CategoryAddRequestDto dto);
    void deleteById(int id);
    CategoryUpdateResponseDto updateById(int id, CategoryUpdateRequestDto dto);
    List<CategoryGetDto> getAllCategories();
    CategoryGetDto getCategoryById(int id);
}
