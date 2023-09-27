package com.arrowsmith.sakiladb.base;


import com.arrowsmith.sakiladb.controllers.CategoryController;
import com.arrowsmith.sakiladb.entities.Category;
import com.arrowsmith.sakiladb.repositories.CategoryRepository;
import com.arrowsmith.sakiladb.services.CategoryService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
public class TestTest {


    @BeforeEach
    void setUp() {

        MockitoAnnotations.initMocks(this);

        final Category newCategory = new Category();
        newCategory.category_id = 1;
        newCategory.name = "My category";

        when(categoryRepo.findById(1)).thenReturn(Optional.of(newCategory));
    }

    @Mock
    CategoryRepository categoryRepo;
    @InjectMocks
    CategoryService categoryService;
    @InjectMocks
    CategoryController categoryController;



    @Test
    public void test()
    {
        final Category cat = categoryService.getCategoryById(1); // categoryController.getCategoryById(1);
        final Category cat2 = categoryController.getCategoryById(1); // categoryController.getCategoryById(1);

        System.out.println(cat2);
    }
}
