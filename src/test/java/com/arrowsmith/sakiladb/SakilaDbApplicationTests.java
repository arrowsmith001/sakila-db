package com.arrowsmith.sakiladb;

import com.arrowsmith.sakiladb.controllers.CategoryController;
import com.arrowsmith.sakiladb.controllers.FilmController;
import com.arrowsmith.sakiladb.entities.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SakilaDbApplicationTests {

	@Autowired
	FilmController filmController;

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
