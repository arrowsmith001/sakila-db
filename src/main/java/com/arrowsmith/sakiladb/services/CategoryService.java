package com.arrowsmith.sakiladb.services;

import com.arrowsmith.sakiladb.entities.Category;
import com.arrowsmith.sakiladb.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category saveCategory(Category Category) {
        return categoryRepository.save(Category);
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Byte id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public void deleteCategory(Byte id) {
        categoryRepository.deleteById(id);
    }
}