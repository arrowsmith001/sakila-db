package com.arrowsmith.sakiladb.services;

import com.arrowsmith.sakiladb.entities.City;
import com.arrowsmith.sakiladb.repositories.CityRepository;
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
class CityServiceTests {

	@Autowired
	private ObjectMapper objectMapper;

	@Mock
	private CityRepository cityRepository;

	@InjectMocks
	private CityService cityService;


	@Test
	void contextLoads() {

	}

	@Test
	void getAllSuccess() {
		cityService.getAllCitys();

		verify(cityRepository, times(1)).findAll();
	}

	@Test
	void getByIdSuccess() {

		final int id = 999;

		cityService.getCityById(id);

		verify(cityRepository, times(1)).findById(id);
	}

	@Test
	void deleteByIdSuccess() {

		final int id = 999;

		cityService.deleteCity(id);

		verify(cityRepository, times(1)).deleteById(id);
	}


	@Test
	void saveSuccess() {

		final City city = new City();

		cityService.saveCity(city);

		verify(cityRepository, times(1)).save(city);
	}


}
