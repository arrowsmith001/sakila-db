package com.arrowsmith.sakiladb.controllers;

import com.arrowsmith.sakiladb.base.ServiceTests;
import com.arrowsmith.sakiladb.entities.Film;
import com.arrowsmith.sakiladb.repositories.FilmRepository;
import com.arrowsmith.sakiladb.services.FilmService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@WebMvcTest(FilmController.class)
class FilmControllerTests {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper objectMapper;

	@MockBean
	private FilmService filmService;


	@Test
	@DisplayName("Context Loads")
	void contextLoads() {

	}


	@Test
	@DisplayName("Get Film by Id")
	public void testGetFilmSuccess() throws Exception {

		final Film film = new Film();
		final int id = 1;

		film.film_id = id;

		when(filmService.getFilmById(id)).thenReturn(film);

		MvcResult result = mvc.perform(MockMvcRequestBuilders
				.get("/film/" + id)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();

		verify(filmService, times(1)).getFilmById(1);

		String responseJSON = result.getResponse().getContentAsString();
		assertTrue(responseJSON.contains("\"film_id\":" + id));
	}

	@Test
	@DisplayName("Add New Film")
	public void testAddNewFilmSuccess() throws Exception {

		final Film film = new Film();
		final int id = 999;

		film.film_id = id;

		when(filmService.saveFilm(any(Film.class))).thenReturn(film);

		MvcResult result = mvc
				.perform(MockMvcRequestBuilders.post("/film")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(new Film())))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();


		verify(filmService, times(1)).saveFilm(any(Film.class));

		String responseJSON = result.getResponse().getContentAsString();
		assertTrue(responseJSON.contains("\"film_id\":" + id));

	}

	@Test
	@DisplayName("Get All Films")
	public void testGetAllFilmsSuccess() throws Exception {

		final List<Film> films = new ArrayList<>();

		for (int i = 0; i < 3; i++)
		{
			final Film newFilm = new Film();
			newFilm.film_id = i;
			films.add(newFilm);
		}

		when(filmService.getAllFilms()).thenReturn(films);

		MvcResult result = mvc
				.perform(MockMvcRequestBuilders.get("/film")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();


		verify(filmService, times(1)).getAllFilms();
		String responseJSON = result.getResponse().getContentAsString();

		for (int i = 0; i < 3; i++)
		{
			assertTrue(responseJSON.contains("\"film_id\":" + i));
		}

	}


	@Test
	@DisplayName("Delete film")
	public void testDeleteFilmSuccess() throws Exception {

		final int id = 999;

		mvc
				.perform(MockMvcRequestBuilders.delete("/film/" + id)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();


		verify(filmService, times(1)).deleteFilm(id);
	}



	@Test
	@DisplayName("Get Random Selection")
	public void testRandomSelectionSuccess() throws Exception {

		final int limit = 10;

		when(filmService.getRandomFilmSelection(limit)).thenReturn(new ArrayList<>(limit));

		MvcResult result = mvc
				.perform(MockMvcRequestBuilders.get("/film/random/" + limit)
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();


		verify(filmService, times(1)).getRandomFilmSelection(limit);

	}

	@Test
	@DisplayName("Get Popular Selection")
	public void testPopularSelectionSuccess() throws Exception {

		final int limit = 10;

		when(filmService.getPopularFilms(limit)).thenReturn(new ArrayList<>(limit));

		MvcResult result = mvc
				.perform(MockMvcRequestBuilders.get("/film/popular/" + limit)
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();


		verify(filmService, times(1)).getPopularFilms(limit);

	}

	@Test
	@DisplayName("Get Films by Category")
	public void getFilmsByCategorySuccess() throws Exception {

		final Film film = new Film();

		final int categoryId = 0;

		when(filmService.getFilmsByCategory(categoryId)).thenReturn(new ArrayList<>());

		MvcResult result = mvc
				.perform(MockMvcRequestBuilders.get("/film/category?id=" + categoryId)
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();


		verify(filmService, times(1)).getFilmsByCategory(categoryId);

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
