package com.arrowsmith.sakiladb.services;

import com.arrowsmith.sakiladb.entities.Film;
import com.arrowsmith.sakiladb.repositories.FilmActorRepository;
import com.arrowsmith.sakiladb.repositories.FilmRepository;
import com.arrowsmith.sakiladb.repositories.InventoryRepository;
import com.arrowsmith.sakiladb.repositories.RentalRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
class FilmServiceTests {

	@Autowired
	private ObjectMapper objectMapper;

	@Mock
	private FilmRepository filmRepository;
	@Mock
	private FilmActorRepository filmActorRepository;
	@Mock
	private RentalRepository rentalRepository;
	@Mock
	private InventoryRepository inventoryRepository;

	@InjectMocks
	private FilmService filmService;


	@Test
	void getAllSuccess() {
		filmService.getAllFilms();

		verify(filmRepository, times(1)).findAll();
	}
	@Test
	void getByIdSuccess() {

		final int id = 999;

		filmService.getFilmById(id);

		verify(filmRepository, times(1)).findById(id);
	}

	@Test
	void deleteByIdSuccess() {

		final int id = 999;

		filmService.deleteFilm(id);

		verify(filmRepository, times(1)).deleteById(id);
	}
	@Test
	void getByCategorySuccess() {

		final int id = 999;

		filmService.getFilmsByCategory(id);

		verify(filmRepository, times(1)).findAllByCategory(id);
	}

	@Test
	void saveSuccess() {

		final Film film = new Film();

		filmService.saveFilm(film);

		verify(filmRepository, times(1)).save(film);
	}
	@Test
	void getRandomSuccess() {

		final int limit = 10;

		filmService.getRandomFilmSelection(limit);

		verify(filmRepository, times(1)).getRandomSelection(limit);
	}


	@Test
	@DisplayName("Popular Selection")
	void getPopularSelectionSuccess() {
		final int limit = 10;

		filmService.getPopularFilms(limit);

		verify(filmRepository, times(1)).getPopularFilms(limit);
	}


}
