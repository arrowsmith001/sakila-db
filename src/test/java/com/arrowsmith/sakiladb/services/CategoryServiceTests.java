package com.arrowsmith.sakiladb.services;

import com.arrowsmith.sakiladb.entities.Category;
import com.arrowsmith.sakiladb.repositories.CategoryRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
class CategoryServiceTests {

	@Autowired
	private ObjectMapper objectMapper;

	@Mock
	private CategoryRepository categoryRepository;

	@InjectMocks
	private CategoryService categoryService;


	@Test
	void contextLoads() {

	}

	@Test
	void getAllSuccess() {
		categoryService.getAllCategories();

		verify(categoryRepository, times(1)).findAll();
	}

	@Test
	void getByIdSuccess() {

		final int id = 999;

		categoryService.getCategoryById(id);

		verify(categoryRepository, times(1)).findById(id);
	}

	@Test
	void deleteByIdSuccess() {

		final int id = 999;

		categoryService.deleteCategory(id);

		verify(categoryRepository, times(1)).deleteById(id);
	}


	@Test
	void saveSuccess() {

		final Category category = new Category();

		categoryService.saveCategory(category);

		verify(categoryRepository, times(1)).save(category);
	}


}
