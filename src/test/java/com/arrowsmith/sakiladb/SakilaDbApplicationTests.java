package com.arrowsmith.sakiladb;

import com.arrowsmith.sakiladb.controllers.CategoryController;
import com.arrowsmith.sakiladb.controllers.FilmController;
import com.arrowsmith.sakiladb.controllers.LanguageController;
import com.arrowsmith.sakiladb.entities.Category;
import com.arrowsmith.sakiladb.entities.Film;
import com.arrowsmith.sakiladb.entities.Language;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;

@SpringBootTest
class SakilaDbApplicationTests {

	@Autowired
	FilmController filmController;
	@Autowired
	CategoryController categoryController;
	@Autowired
	LanguageController languageController;



	@Test
	void contextLoads() {

	}

	@Test
	void canCreateCategory() {
		Category category = new Category();
		categoryController.saveCategory(category);
	}

	@Test
	void canCreateFilm() {
		int id = 999999999;
		filmController.deleteFilm(id);

		Film film = new Film();

        film.language = languageController.getLanguageById(1);
		film.rental_duration = ((byte) 0);
		film.title = ("title");

		film.film_id = id;
		film.rating = "PG";
		film.description = "desc";
		film.last_update = Timestamp.from(Instant.now());
		film.categories = new ArrayList<>();
		film.replacement_cost = BigDecimal.ONE;
		film.special_features = "Deleted Scenes";

		filmController.saveFilm(film);
	}


}
