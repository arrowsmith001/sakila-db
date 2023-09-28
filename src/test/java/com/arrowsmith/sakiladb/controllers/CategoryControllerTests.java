package com.arrowsmith.sakiladb.controllers;

import com.arrowsmith.sakiladb.entities.Category;
import com.arrowsmith.sakiladb.services.CategoryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@WebMvcTest(CategoryController.class)
public class CategoryControllerTests {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper objectMapper;

	@MockBean
	private CategoryService categoryService;



	@Test
	@DisplayName("Get Category by Id")
	public void testGetCategorySuccess() throws Exception {

		final Category category = new Category();
		final int id = 1;

		category.setCategoryId(id);

		when(categoryService.getCategoryById(id)).thenReturn(category);

		MvcResult result = mvc.perform(MockMvcRequestBuilders
				.get("/category/" + id)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();

		verify(categoryService, times(1)).getCategoryById(1);

		String responseJSON = result.getResponse().getContentAsString();
		assertTrue(responseJSON.contains("\"categoryId\":" + id));
	}

	@Test
	@DisplayName("Add New Category")
	public void testAddNewCategorySuccess() throws Exception {

		final Category category = new Category();
		final int id = 999;

		category.setCategoryId(id);

		when(categoryService.saveCategory(any(Category.class))).thenReturn(category);

		MvcResult result = mvc
				.perform(MockMvcRequestBuilders.post("/category")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(new Category())))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();


		verify(categoryService, times(1)).saveCategory(any(Category.class));

		String responseJSON = result.getResponse().getContentAsString();
		assertTrue(responseJSON.contains("\"categoryId\":" + id));

	}

	@Test
	@DisplayName("Get All Categorys")
	public void testGetAllCategorysSuccess() throws Exception {

		final List<Category> categorys = new ArrayList<>();

		for (int i = 0; i < 3; i++)
		{
			final Category newCategory = new Category();
			newCategory.setCategoryId(i);
			categorys.add(newCategory);
		}

		when(categoryService.getAllCategories()).thenReturn(categorys);

		MvcResult result = mvc
				.perform(MockMvcRequestBuilders.get("/category")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();


		verify(categoryService, times(1)).getAllCategories();
		String responseJSON = result.getResponse().getContentAsString();

		for (int i = 0; i < 3; i++)
		{
			assertTrue(responseJSON.contains("\"categoryId\":" + i));
		}

	}


	@Test
	@DisplayName("Delete category")
	public void testDeleteCategorySuccess() throws Exception {

		final int id = 999;

		mvc
				.perform(MockMvcRequestBuilders.delete("/category/" + id)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();


		verify(categoryService, times(1)).deleteCategory(id);
	}






}
