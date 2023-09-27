package com.arrowsmith.sakiladb.services;

import com.arrowsmith.sakiladb.entities.Film;
import com.arrowsmith.sakiladb.repositories.FilmRepository;
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
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
class FilmServiceTests {

	@Autowired
	private ObjectMapper objectMapper;

	@Mock
	private FilmRepository filmRepository;

	@InjectMocks
	private FilmService filmService;


	@Test
	void contextLoads() {

	}

	@Test
	@DisplayName("")
	void getPopularSelectionSuccess() {
		when(filmRepository.getPopularFilms(10)).thenReturn(new ArrayList<>(10));

		filmService.getPopularFilms(10);

		verify(filmRepository, times(1)).getPopularFilms(10);
	}


}
