package com.arrowsmith.sakiladb.controllers;

import com.arrowsmith.sakiladb.entities.Language;
import com.arrowsmith.sakiladb.services.LanguageService;
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


@WebMvcTest(LanguageController.class)
class LanguageControllerTests {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper objectMapper;

	@MockBean
	private LanguageService languageService;


	@Test
	@DisplayName("Get Language by Id")
	void testGetLanguageSuccess() throws Exception {

		final Language language = new Language();
		final int id = 1;

		language.setLanguageId(id);

		when(languageService.getLanguageById(id)).thenReturn(language);

		MvcResult result = mvc.perform(MockMvcRequestBuilders
				.get("/language/" + id)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();

		verify(languageService, times(1)).getLanguageById(1);

		String responseJSON = result.getResponse().getContentAsString();
		assertTrue(responseJSON.contains("\"languageId\":" + id));
	}

	@Test
	@DisplayName("Add New Language")
	void testAddNewLanguageSuccess() throws Exception {

		final Language language = new Language();
		final int id = 999;

		language.setLanguageId(id);

		when(languageService.saveLanguage(any(Language.class))).thenReturn(language);

		MvcResult result = mvc
				.perform(MockMvcRequestBuilders.post("/language")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(new Language())))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();


		verify(languageService, times(1)).saveLanguage(any(Language.class));

		String responseJSON = result.getResponse().getContentAsString();
		assertTrue(responseJSON.contains("\"languageId\":" + id));

	}

	@Test
	@DisplayName("Get All Languages")
	void testGetAllLanguagesSuccess() throws Exception {

		final List<Language> languages = new ArrayList<>();

		for (int i = 0; i < 3; i++)
		{
			final Language newLanguage = new Language();
			newLanguage.setLanguageId(i);
			languages.add(newLanguage);
		}

		when(languageService.getAllLanguages()).thenReturn(languages);

		MvcResult result = mvc
				.perform(MockMvcRequestBuilders.get("/language")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();


		verify(languageService, times(1)).getAllLanguages();
		String responseJSON = result.getResponse().getContentAsString();

		for (int i = 0; i < 3; i++)
		{
			assertTrue(responseJSON.contains("\"languageId\":" + i));
		}

	}


	@Test
	@DisplayName("Delete language")
	void testDeleteLanguageSuccess() throws Exception {

		final int id = 999;

		mvc
				.perform(MockMvcRequestBuilders.delete("/language/" + id)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();


		verify(languageService, times(1)).deleteLanguage(id);
	}






}
