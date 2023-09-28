package com.arrowsmith.sakiladb.services;

import com.arrowsmith.sakiladb.entities.Language;
import com.arrowsmith.sakiladb.repositories.LanguageRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
class LanguageServiceTests {

	@Autowired
	private ObjectMapper objectMapper;

	@Mock
	private LanguageRepository languageRepository;

	@InjectMocks
	private LanguageService languageService;


	@Test
	void contextLoads() {

	}

	@Test
	void getAllSuccess() {
		languageService.getAllLanguages();

		verify(languageRepository, times(1)).findAll();
	}

	@Test
	void getByIdSuccess() {

		final int id = 999;

		languageService.getLanguageById(id);

		verify(languageRepository, times(1)).findById(id);
	}

	@Test
	void deleteByIdSuccess() {

		final int id = 999;

		languageService.deleteLanguage(id);

		verify(languageRepository, times(1)).deleteById(id);
	}


	@Test
	void saveSuccess() {

		final Language language = new Language();

		languageService.saveLanguage(language);

		verify(languageRepository, times(1)).save(language);
	}


}
