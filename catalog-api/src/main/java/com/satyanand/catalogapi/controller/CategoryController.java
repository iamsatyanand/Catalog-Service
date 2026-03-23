package com.satyanand.catalogapi.controller;

import com.satyanand.catalogapi.dto.CategoryRequest;
import com.satyanand.catalogapi.dto.CategoryResponse;
import com.satyanand.catalogapi.mapper.CategoryDtoMapper;
import com.satyanand.catalogapplication.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public CategoryResponse create(@RequestBody CategoryRequest request) {
        var category = categoryService.createCategory(
                request.getName(),
                request.getParentId()
        );

        return CategoryDtoMapper.toResponse(category);
    }

    @PutMapping("/{id}")
    public CategoryResponse update(@PathVariable Long id,
                                   @RequestBody CategoryRequest request) {

        var category = categoryService.updateCategory(
                id,
                request.getName(),
                request.getParentId()
        );

        return CategoryDtoMapper.toResponse(category);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }

    @GetMapping("/{id}")
    public CategoryResponse getById(@PathVariable Long id) {
        return CategoryDtoMapper.toResponse(
                categoryService.getCategory(id)
        );
    }

    @GetMapping
    public List<CategoryResponse> getAll() {
        return categoryService.getAllCategories()
                .stream()
                .map(CategoryDtoMapper::toResponse)
                .collect(Collectors.toList());
    }

    @GetMapping("/tree")
    public List<CategoryResponse> getTree() {
        return categoryService.getCategoryTree()
                .stream()
                .map(CategoryDtoMapper::toResponse)
                .toList();
    }
}