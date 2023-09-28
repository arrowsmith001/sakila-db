package com.arrowsmith.sakiladb.controllers;

import com.arrowsmith.sakiladb.entities.Rental;
import com.arrowsmith.sakiladb.services.RentalService;
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


@WebMvcTest(RentalController.class)
class RentalControllerTests {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper objectMapper;

	@MockBean
	private RentalService rentalService;


	@Test
	@DisplayName("Get Rental by Id")
	void testGetRentalSuccess() throws Exception {

		final Rental rental = new Rental();
		final int id = 1;

		rental.setRentalId(id);

		when(rentalService.getRentalById(id)).thenReturn(rental);

		MvcResult result = mvc.perform(MockMvcRequestBuilders
				.get("/rental/" + id)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();

		verify(rentalService, times(1)).getRentalById(1);

		String responseJSON = result.getResponse().getContentAsString();
		assertTrue(responseJSON.contains("\"rentalId\":" + id));
	}

	@Test
	@DisplayName("Add New Rental")
	void testAddNewRentalSuccess() throws Exception {

		final Rental rental = new Rental();
		final int id = 999;

		rental.setRentalId(id);

		when(rentalService.saveRental(any(Rental.class))).thenReturn(rental);

		MvcResult result = mvc
				.perform(MockMvcRequestBuilders.post("/rental")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(new Rental())))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();


		verify(rentalService, times(1)).saveRental(any(Rental.class));

		String responseJSON = result.getResponse().getContentAsString();
		assertTrue(responseJSON.contains("\"rentalId\":" + id));

	}

	@Test
	@DisplayName("Get All Rentals")
	void testGetAllRentalsSuccess() throws Exception {

		final List<Rental> rentals = new ArrayList<>();

		for (int i = 0; i < 3; i++)
		{
			final Rental newRental = new Rental();
			newRental.setRentalId(i);
			rentals.add(newRental);
		}

		when(rentalService.getAllRentals()).thenReturn(rentals);

		MvcResult result = mvc
				.perform(MockMvcRequestBuilders.get("/rental")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();


		verify(rentalService, times(1)).getAllRentals();
		String responseJSON = result.getResponse().getContentAsString();

		for (int i = 0; i < 3; i++)
		{
			assertTrue(responseJSON.contains("\"rentalId\":" + i));
		}

	}


	@Test
	@DisplayName("Delete rental")
	void testDeleteRentalSuccess() throws Exception {

		final int id = 999;

		mvc
				.perform(MockMvcRequestBuilders.delete("/rental/" + id)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();


		verify(rentalService, times(1)).deleteRental(id);
	}






}
