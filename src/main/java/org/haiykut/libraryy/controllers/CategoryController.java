package org.haiykut.libraryy.controllers;

import lombok.RequiredArgsConstructor;
import org.haiykut.libraryy.services.abstracts.CategoryService;
import org.haiykut.libraryy.services.dtos.requests.category.CategoryAddRequestDto;
import org.haiykut.libraryy.services.dtos.requests.category.CategoryUpdateRequestDto;
import org.haiykut.libraryy.services.dtos.responses.Category.CategoryAddResponseDto;
import org.haiykut.libraryy.services.dtos.responses.Category.CategoryGetDto;
import org.haiykut.libraryy.services.dtos.responses.Category.CategoryUpdateResponseDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/all")
    public List<CategoryGetDto> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public CategoryGetDto getCategoryById(@PathVariable int id){
        return categoryService.getCategoryById(id);
    }

    @PostMapping("/add")
    public CategoryAddResponseDto add(@RequestBody CategoryAddRequestDto dto){
        return categoryService.add(dto);
    }


    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable int id) {
        categoryService.deleteById(id);
    }


    @PutMapping("/update/{id}")
    public CategoryUpdateResponseDto updateById(@PathVariable int id, @RequestBody CategoryUpdateRequestDto dto){
        return categoryService.updateById(id, dto);
    }
}
