package com.arrowsmith.sakiladb;

import com.arrowsmith.sakiladb.controllers.CategoryController;
import com.arrowsmith.sakiladb.controllers.FilmController;
import com.arrowsmith.sakiladb.controllers.LanguageController;
import com.arrowsmith.sakiladb.entities.Category;
import com.arrowsmith.sakiladb.entities.Film;
import com.arrowsmith.sakiladb.repositories.FilmRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class CategoryTests {

	@Autowired
	CategoryController categoryController;


	@Test
	void contextLoads() {

	}

	@Test
	void canCreateCategory() {
		Category category = new Category();
		categoryController.saveCategory(category);
	}



}
