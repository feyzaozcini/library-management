package org.haiykut.libraryy.services.concretes;
import lombok.RequiredArgsConstructor;
import org.haiykut.libraryy.entities.Category;
import org.haiykut.libraryy.repositories.CategoryRepository;
import org.haiykut.libraryy.services.abstracts.CategoryService;
import org.haiykut.libraryy.services.dtos.requests.category.CategoryAddRequestDto;
import org.haiykut.libraryy.services.dtos.requests.category.CategoryUpdateRequestDto;
import org.haiykut.libraryy.services.dtos.responses.CategoryAddResponseDto;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    @Override
    public CategoryAddResponseDto add(CategoryAddRequestDto dto) {
        Category newCategory = new Category();
        newCategory.setName(dto.getName());
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
        Category requestedCategory = categoryRepository.findById(id).orElseThrow();
        requestedCategory.setName(dto.getName());
        categoryRepository.save(requestedCategory);
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
