package org.haiykut.libraryy.services.concretes;

import lombok.RequiredArgsConstructor;
import org.haiykut.libraryy.core.utils.exceptions.types.BusinessException;
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
        categoryWithSameNameShouldNotExist(dto.getName());

        Category newCategory = CategoryMapper.INSTANCE.categoryFromRequest(dto);
        newCategory = categoryRepository.save(newCategory);
        return new CategoryAddResponseDto(newCategory.getName(), newCategory.getDescription());
    }

    @Override
    public void deleteById(int id) {
        categoryWithSameIdShouldNotExist(id);

        categoryRepository.deleteById(id);
    }

    @Override
    public CategoryUpdateResponseDto updateById(int id, CategoryUpdateRequestDto dto) {
        categoryWithSameNameShouldNotExist(dto.getName());

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
        categoryWithSameIdShouldNotExist(id);

        Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found!"));
        return new CategoryGetDto(category.getName(), category.getDescription());
    }


    private void categoryWithSameNameShouldNotExist(String name){
        if(categoryRepository.findByNameIgnoreCase(name).isPresent()){
            throw new BusinessException("A category with this name already exists!");
        }
    }

    private void categoryWithSameIdShouldNotExist(int id){
        if(categoryRepository.findById(id).isPresent()){
            throw new BusinessException("A category with this id already exists!");
        }
    }

}
