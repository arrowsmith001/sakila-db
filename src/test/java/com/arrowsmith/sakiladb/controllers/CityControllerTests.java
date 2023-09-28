package com.arrowsmith.sakiladb.controllers;

import com.arrowsmith.sakiladb.entities.City;
import com.arrowsmith.sakiladb.services.CityService;
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


@WebMvcTest(CityController.class)
class CityControllerTests {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper objectMapper;

	@MockBean
	private CityService cityService;


	@Test
	@DisplayName("Context Loads")
	void contextLoads() {

	}


	@Test
	@DisplayName("Get City by Id")
	public void testGetCitySuccess() throws Exception {

		final City city = new City();
		final int id = 1;

		city.setCity_id(id);

		when(cityService.getCityById(id)).thenReturn(city);

		MvcResult result = mvc.perform(MockMvcRequestBuilders
				.get("/city/" + id)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();

		verify(cityService, times(1)).getCityById(1);

		String responseJSON = result.getResponse().getContentAsString();
		assertTrue(responseJSON.contains("\"city_id\":" + id));
	}

	@Test
	@DisplayName("Add New City")
	public void testAddNewCitySuccess() throws Exception {

		final City city = new City();
		final int id = 999;

		city.setCity_id(id);

		when(cityService.saveCity(any(City.class))).thenReturn(city);

		MvcResult result = mvc
				.perform(MockMvcRequestBuilders.post("/city")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(new City())))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();


		verify(cityService, times(1)).saveCity(any(City.class));

		String responseJSON = result.getResponse().getContentAsString();
		assertTrue(responseJSON.contains("\"city_id\":" + id));

	}

	@Test
	@DisplayName("Get All Citys")
	public void testGetAllCitysSuccess() throws Exception {

		final List<City> citys = new ArrayList<>();

		for (int i = 0; i < 3; i++)
		{
			final City newCity = new City();
			newCity.setCity_id(i);
			citys.add(newCity);
		}

		when(cityService.getAllCitys()).thenReturn(citys);

		MvcResult result = mvc
				.perform(MockMvcRequestBuilders.get("/city")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();


		verify(cityService, times(1)).getAllCitys();
		String responseJSON = result.getResponse().getContentAsString();

		for (int i = 0; i < 3; i++)
		{
			assertTrue(responseJSON.contains("\"city_id\":" + i));
		}

	}


	@Test
	@DisplayName("Delete city")
	public void testDeleteCitySuccess() throws Exception {

		final int id = 999;

		mvc
				.perform(MockMvcRequestBuilders.delete("/city/" + id)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();


		verify(cityService, times(1)).deleteCity(id);
	}






}
