package com.arrowsmith.sakiladb.controllers;

import com.arrowsmith.sakiladb.entities.Category;
import com.arrowsmith.sakiladb.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "https://main.d34jypsxbhc933.amplifyapp.com"})
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("")
    public Category saveCategory(@RequestBody Category category) { return categoryService.saveCategory(category); }

    @GetMapping("")
    public List<Category> getAllCategories() { return categoryService.getAllCategories(); }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Integer id) {
        return categoryService.getCategoryById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Integer id) {
        categoryService.deleteCategory(id);
    }
}