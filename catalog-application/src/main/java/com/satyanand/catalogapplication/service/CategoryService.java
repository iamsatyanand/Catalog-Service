package com.satyanand.catalogapplication.service;

import com.satyanand.catalogdomain.model.Category;
import com.satyanand.catalogdomain.repository.CategoryRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category createCategory(String name, Long parentId) {
        Category parent = null;

        if (parentId != null) {
            parent = categoryRepository.findById(parentId)
                    .orElseThrow(() -> new RuntimeException("Parent category not found"));
        }

        Category category = new Category(null, name, parent);
        return categoryRepository.save(category);
    }

    public Category updateCategory(Long id, String name, Long parentId) {
        Category existing = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        Category parent = null;
        if (parentId != null) {
            parent = categoryRepository.findById(parentId)
                    .orElseThrow(() -> new RuntimeException("Parent category not found"));
        }

        Category updated = new Category(id, name, parent);
        return categoryRepository.save(updated);
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    public Category getCategory(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public List<Category> getCategoryTree(){
        List<Category> categoryList = categoryRepository.findAll();

        Map<Long, Category> categoryMap = new HashMap<>();
        for(Category c : categoryList){
            categoryMap.put(c.getId(), c);
        }

        List<Category> categoryTree = new ArrayList<>();
        for(Category c : categoryList){
            if(c.getParent() != null){
                Category parent = categoryMap.get(c.getParent().getId());
                if(parent.getChildren() == null){
                    parent.setChildren(new ArrayList<>());
                }
                parent.getChildren().add(c);
            }
            else{
                categoryTree.add(c);
            }
        }
        return categoryTree;
    }
}
