package com.arrowsmith.sakiladb;

import com.arrowsmith.sakiladb.base.EntityTest;
import com.arrowsmith.sakiladb.controllers.CategoryController;
import com.arrowsmith.sakiladb.controllers.FilmController;
import com.arrowsmith.sakiladb.controllers.LanguageController;
import com.arrowsmith.sakiladb.entities.Category;
import com.arrowsmith.sakiladb.entities.Film;
import com.arrowsmith.sakiladb.repositories.FilmRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

class FilmTests extends EntityTest<Film> {

	@Autowired
	FilmController filmController;
	@Autowired
	FilmRepository filmRepository;
	@Autowired
	CategoryController categoryController;
	@Autowired
	LanguageController languageController;


	@Test
	void contextLoads() {

	}

	@Test
	public void canCreate() {

		Film film = getBasic();
		addAdditional(film);

		final Film newFilm = filmController.saveFilm(film);

		Assert.assertTrue(filmRepository.existsById(newFilm.film_id), "Film doesn't exist");
	}

	@Test
	public void canDelete() {

		final Film film = getBasic();
		final Film newFilm = filmController.saveFilm(film);

		final Integer id = newFilm.film_id;

		Assert.assertTrue(filmRepository.existsById(id));

		filmController.deleteFilm(id);

		Assert.assertFalse(filmRepository.existsById(id));
	}

	@Override
	public void canUpdate() {

		final Film film = getBasic();
		final Film savedFilm = filmController.saveFilm(film);
		final Integer filmId = savedFilm.film_id;

		final String newTitle = savedFilm.title + "1";
		savedFilm.title = newTitle;

		filmController.saveFilm(savedFilm);

		final Film readFilm = filmController.getFilmById(filmId);

		Assert.assertEquals(readFilm.title, newTitle);
	}

	@Override @Test
	public void canRead() {
		final Film film = getBasic();

		final Film savedFilm = filmController.saveFilm(film);

		final Film readFilm = filmController.getFilmById(film.film_id);

		Assert.assertEquals(readFilm.film_id, savedFilm.film_id);
	}

	@Test
	void canCreateCategory() {
		Category category = new Category();
		categoryController.saveCategory(category);
	}



	@Test
	void getFilmsByCategoryWorks() {
		int categoryId = 1;

		List<Film> films = filmController.getFilmsByCategory(categoryId);

		boolean allContainCategory = films.stream().allMatch(f -> {
			final List<Category> categories = f.categories;
			return categories.stream().anyMatch(c -> c.category_id == categoryId);
		});

		Assert.assertTrue(allContainCategory, "Category not found in at least 1 film");
	}


	@Override
	public Film getBasic() {

		final Film film = new Film();

		film.language = languageController.getLanguageById(1);
		film.rental_duration = ((byte) 0);
		film.title = ("title");

		return film;
	}

	protected void addAdditional(Film film) {
		film.rating = "PG";
		film.description = "desc";
		film.last_update = Timestamp.from(Instant.now());
		film.categories = new ArrayList<>();
		film.replacement_cost = BigDecimal.ONE;
		film.special_features = "Deleted Scenes";
	}

}