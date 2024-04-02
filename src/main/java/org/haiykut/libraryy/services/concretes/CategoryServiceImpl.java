package org.haiykut.libraryy.services.concretes;

import lombok.RequiredArgsConstructor;
import org.haiykut.libraryy.entities.Category;
import org.haiykut.libraryy.repositories.CategoryRepository;
import org.haiykut.libraryy.services.abstracts.CategoryService;
import org.haiykut.libraryy.services.dtos.requests.category.CategoryAddRequestDto;
import org.haiykut.libraryy.services.dtos.requests.category.CategoryUpdateRequestDto;
import org.haiykut.libraryy.services.dtos.responses.Category.CategoryAddResponseDto;
import org.haiykut.libraryy.services.dtos.responses.Category.CategoryGetDto;
import org.haiykut.libraryy.services.dtos.responses.Category.CategoryUpdateResponseDto;
import org.haiykut.libraryy.services.mappers.CategoryMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public CategoryAddResponseDto add(CategoryAddRequestDto dto) {
        Category newCategory = CategoryMapper.INSTANCE.categoryFromRequest(dto);
        newCategory = categoryRepository.save(newCategory);
        return new CategoryAddResponseDto(newCategory.getName(), newCategory.getDescription());
    }

    @Override
    public void deleteById(int id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public CategoryUpdateResponseDto updateById(int id, CategoryUpdateRequestDto dto) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found!"));
        category.setName(dto.getName());
        category.setDescription(dto.getDescription());
        category = categoryRepository.save(category);
        return new CategoryUpdateResponseDto(category.getId(), category.getName(), category.getDescription());
    }

    @Override
    public List<CategoryGetDto> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(category -> new CategoryGetDto(category.getName(), category.getDescription()))
                .collect(Collectors.toList());
    }

    @Override
    public CategoryGetDto getCategoryById(int id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found!"));
        return new CategoryGetDto(category.getName(), category.getDescription());
    }
}
