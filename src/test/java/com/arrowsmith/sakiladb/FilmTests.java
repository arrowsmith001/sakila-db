package com.arrowsmith.sakiladb;

import com.arrowsmith.sakiladb.base.EntityTest;
import com.arrowsmith.sakiladb.controllers.CategoryController;
import com.arrowsmith.sakiladb.controllers.FilmController;
import com.arrowsmith.sakiladb.controllers.LanguageController;
import com.arrowsmith.sakiladb.entities.Category;
import com.arrowsmith.sakiladb.entities.Film;
import com.arrowsmith.sakiladb.repositories.CategoryRepository;
import com.arrowsmith.sakiladb.repositories.FilmRepository;
import com.arrowsmith.sakiladb.repositories.LanguageRepository;
import com.arrowsmith.sakiladb.services.CategoryService;
import com.arrowsmith.sakiladb.services.FilmService;
import com.arrowsmith.sakiladb.services.LanguageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
class FilmTests extends EntityTest<Film> {

	@BeforeEach
	void setUp() {

		MockitoAnnotations.initMocks(this);

		final Category newCategory = new Category();
		newCategory.category_id = 1;
		newCategory.name = "My category";

		when(filmRepository.existsById(1)).thenReturn(true);
	}

	@Mock
	FilmRepository filmRepository;
	@Mock
	CategoryRepository categoryRepository;
	@Mock
	LanguageRepository languageRepository;

	@InjectMocks
	FilmService filmService;
	@InjectMocks
	CategoryService categoryService;
	@InjectMocks
	LanguageService languageService;


	@Test
	void contextLoads() {
		assert(filmRepository.existsById(1));
	}

//	@Test
//	public void canCreate() {
//
//		Film film = getBasic();
//		addAdditional(film);
//
//		final Film newFilm = filmController.saveFilm(film);
//
//		Assert.assertTrue(filmService.existsById(newFilm.film_id), "Film doesn't exist");
//	}
//
//	@Test
//	public void canDelete() {
//
//		final Film film = getBasic();
//		final Film newFilm = filmController.saveFilm(film);
//
//		final Integer id = newFilm.film_id;
//
//		Assert.assertTrue(filmRepository.existsById(id));
//
//		filmController.deleteFilm(id);
//
//		Assert.assertFalse(filmRepository.existsById(id));
//	}
//
//	@Override
//	public void canUpdate() {
//
//		final Film film = getBasic();
//		final Film savedFilm = filmController.saveFilm(film);
//		final Integer filmId = savedFilm.film_id;
//
//		final String newTitle = savedFilm.title + "1";
//		savedFilm.title = newTitle;
//
//		filmController.saveFilm(savedFilm);
//
//		final Film readFilm = filmController.getFilmById(filmId);
//
//		Assert.assertEquals(readFilm.title, newTitle);
//	}
//
//	@Override @Test
//	public void canRead() {
//		final Film film = getBasic();
//
//		final Film savedFilm = filmController.saveFilm(film);
//
//		final Film readFilm = filmController.getFilmById(film.film_id);
//
//		Assert.assertEquals(readFilm.film_id, savedFilm.film_id);
//	}
//
//	@Test
//	void canCreateCategory() {
//		Category category = new Category();
//		categoryController.saveCategory(category);
//	}
//
//
//
//	@Test
//	void getFilmsByCategoryWorks() {
//		int categoryId = 1;
//
//		List<Film> films = filmController.getFilmsByCategory(categoryId);
//
//		boolean allContainCategory = films.stream().allMatch(f -> {
//			final List<Category> categories = f.categories;
//			return categories.stream().anyMatch(c -> c.category_id == categoryId);
//		});
//
//		Assert.assertTrue(allContainCategory, "Category not found in at least 1 film");
//	}
//
//
//	@Override
//	public Film getBasic() {
//
//		final Film film = new Film();
//
//		film.language = languageController.getLanguageById(1);
//		film.rental_duration = ((byte) 0);
//		film.title = ("title");
//
//		return film;
//	}
//
//	protected void addAdditional(Film film) {
//		film.rating = "PG";
//		film.description = "desc";
//		film.last_update = Timestamp.from(Instant.now());
//		film.categories = new ArrayList<>();
//		film.replacement_cost = BigDecimal.ONE;
//		film.special_features = "Deleted Scenes";
//	}

}
