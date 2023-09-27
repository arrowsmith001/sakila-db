package com.arrowsmith.sakiladb;

import com.arrowsmith.sakiladb.controllers.CategoryController;
import com.arrowsmith.sakiladb.controllers.FilmController;
import com.arrowsmith.sakiladb.controllers.LanguageController;
import com.arrowsmith.sakiladb.entities.Category;
import com.arrowsmith.sakiladb.entities.Film;
import com.arrowsmith.sakiladb.repositories.FilmRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.testng.Assert;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
class CategoryTests {

	@Mock
	CategoryController categoryController;

	@Test
	void contextLoads() {

	}


	@Test
	void canCreateCategory() {
		Category category = new Category();
		//categoryController.saveCategory(category);
	}



}
