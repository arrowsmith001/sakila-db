package com.arrowsmith.sakiladb.controllers;

import com.arrowsmith.sakiladb.entities.Film;
import com.arrowsmith.sakiladb.services.FilmService;
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


@WebMvcTest(FilmController.class)
class FilmControllerTests {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper objectMapper;

	@MockBean
	private FilmService filmService;



	@Test
	@DisplayName("Get Film by Id")
	void testGetFilmSuccess() throws Exception {

		final Film film = new Film();
		final int id = 1;

		film.setFilmId(id);

		when(filmService.getFilmById(id)).thenReturn(film);

		MvcResult result = mvc.perform(MockMvcRequestBuilders
				.get("/film/" + id)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();

		verify(filmService, times(1)).getFilmById(1);

		String responseJSON = result.getResponse().getContentAsString();
		assertTrue(responseJSON.contains("\"filmId\":" + id));
	}

	@Test
	@DisplayName("Add New Film")
	void testAddNewFilmSuccess() throws Exception {

		final Film film = new Film();
		final int id = 999;

		film.setFilmId(id);

		when(filmService.saveFilm(any(Film.class))).thenReturn(film);

		MvcResult result = mvc
				.perform(MockMvcRequestBuilders.post("/film")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(new Film())))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();


		verify(filmService, times(1)).saveFilm(any(Film.class));

		String responseJSON = result.getResponse().getContentAsString();
		assertTrue(responseJSON.contains("\"filmId\":" + id));

	}

	@Test
	@DisplayName("Get All Films")
	void testGetAllFilmsSuccess() throws Exception {

		final List<Film> films = new ArrayList<>();

		for (int i = 0; i < 3; i++)
		{
			final Film newFilm = new Film();
			newFilm.setFilmId(i);
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
			assertTrue(responseJSON.contains("\"filmId\":" + i));
		}

	}


	@Test
	@DisplayName("Delete film")
	void testDeleteFilmSuccess() throws Exception {

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
	void testRandomSelectionSuccess() throws Exception {

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
	void testPopularSelectionSuccess() throws Exception {

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
	void getFilmsByCategorySuccess() throws Exception {

		final int categoryId = 0;

		when(filmService.getFilmsByCategory(categoryId)).thenReturn(new ArrayList<>());

		MvcResult result = mvc
				.perform(MockMvcRequestBuilders.get("/film/category?id=" + categoryId)
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();


		verify(filmService, times(1)).getFilmsByCategory(categoryId);

	}

	@Test
	@DisplayName("Get Films by Search term")
	void getFilmsBySearchTermSuccess() throws Exception {

		final String term = "";
		final int limit = 0;

		when(filmService.getFilmsBySearchTerm("", 0)).thenReturn(new ArrayList<>());

		MvcResult result = mvc
				.perform(MockMvcRequestBuilders.get("/film/search?term=" + term + "&limit=" + limit)
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();


		verify(filmService, times(1)).getFilmsBySearchTerm(term, limit);

	}

}
