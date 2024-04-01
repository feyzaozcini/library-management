package org.haiykut.libraryy.services.concretes;
import lombok.RequiredArgsConstructor;
import org.haiykut.libraryy.entities.Category;
import org.haiykut.libraryy.repositories.CategoryRepository;
import org.haiykut.libraryy.services.abstracts.CategoryService;
import org.haiykut.libraryy.services.dtos.requests.category.CategoryAddRequestDto;
import org.haiykut.libraryy.services.dtos.requests.category.CategoryUpdateRequestDto;
import org.haiykut.libraryy.services.dtos.responses.Category.CategoryAddResponseDto;
import org.haiykut.libraryy.services.mappers.CategoryMapper;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    @Override
    public CategoryAddResponseDto add(CategoryAddRequestDto dto) {
        Category newCategory = CategoryMapper.INSTANCE.categoryFromRequest(dto);
        categoryRepository.save(newCategory);
        return new CategoryAddResponseDto(newCategory.getId(), newCategory.getName());
    }
    @Override
    public String deleteById(int id) {
        categoryRepository.deleteById(id);
        return "Silindi!";
    }
    @Override
    public String updateById(int id, CategoryUpdateRequestDto dto) {
        Category updatedCategory = CategoryMapper.INSTANCE.categoryFromRequest(dto);
        updatedCategory.setId(id);
        categoryRepository.save(updatedCategory);
        return "Guncellendi";
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(int id) {
        return categoryRepository.findById(id).orElseThrow();
    }
}
