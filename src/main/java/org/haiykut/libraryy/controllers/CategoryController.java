package org.haiykut.libraryy.controllers;

import lombok.RequiredArgsConstructor;
import org.haiykut.libraryy.entities.Category;
import org.haiykut.libraryy.services.abstracts.CategoryService;
import org.haiykut.libraryy.services.dtos.requests.category.CategoryAddRequestDto;
import org.haiykut.libraryy.services.dtos.requests.category.CategoryUpdateRequestDto;
import org.haiykut.libraryy.services.dtos.responses.CategoryAddResponseDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    @GetMapping("/all")
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }
    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable int id){
        return categoryService.getCategoryById(id);
    }
    @PostMapping("/add")
    public CategoryAddResponseDto add(@RequestBody CategoryAddRequestDto dto){
        return categoryService.add(dto);

    }
    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable int id){
        return categoryService.deleteById(id);
    }
    @PutMapping("/update/{id}")
    public String updateById(@PathVariable int id, CategoryUpdateRequestDto dto){
        return categoryService.updateById(id, dto);
    }
}
