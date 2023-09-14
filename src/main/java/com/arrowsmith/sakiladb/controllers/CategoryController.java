package com.arrowsmith.sakiladb.controllers;

import com.arrowsmith.sakiladb.entities.Category;
import com.arrowsmith.sakiladb.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("")
    public Category saveCategory(@RequestBody Category category) { return categoryService.saveCategory(category); }

    @GetMapping("")
    public List<Category> getAllCategories() { return categoryService.getAllCategories(); }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Byte id) {
        return categoryService.getCategoryById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Byte id) {
        categoryService.deleteCategory(id);
    }
}