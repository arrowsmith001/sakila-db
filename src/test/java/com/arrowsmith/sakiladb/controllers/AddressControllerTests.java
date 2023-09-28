package com.arrowsmith.sakiladb.controllers;

import com.arrowsmith.sakiladb.entities.Address;
import com.arrowsmith.sakiladb.services.AddressService;
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


@WebMvcTest(AddressController.class)
class AddressControllerTests {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper objectMapper;

	@MockBean
	private AddressService addressService;



	@Test
	@DisplayName("Get Address by Id")
	void testGetAddressSuccess() throws Exception {

		final Address address = new Address();
		final int id = 1;

		address.setAddressId(id);

		when(addressService.getAddressById(id)).thenReturn(address);

		MvcResult result = mvc.perform(MockMvcRequestBuilders
				.get("/address/" + id)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();

		verify(addressService, times(1)).getAddressById(1);

		String responseJSON = result.getResponse().getContentAsString();
		assertTrue(responseJSON.contains("\"addressId\":" + id));
	}

	@Test
	@DisplayName("Add New Address")
	void testAddNewAddressSuccess() throws Exception {

		final Address address = new Address();
		final int id = 999;

		address.setAddressId(id);

		when(addressService.saveAddress(any(Address.class))).thenReturn(address);

		MvcResult result = mvc
				.perform(MockMvcRequestBuilders.post("/address")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(new Address())))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();


		verify(addressService, times(1)).saveAddress(any(Address.class));

		String responseJSON = result.getResponse().getContentAsString();
		assertTrue(responseJSON.contains("\"addressId\":" + id));

	}

	@Test
	@DisplayName("Get All Addresss")
	void testGetAllAddresssSuccess() throws Exception {

		final List<Address> addresss = new ArrayList<>();

		for (int i = 0; i < 3; i++)
		{
			final Address newAddress = new Address();
			newAddress.setAddressId(i);
			addresss.add(newAddress);
		}

		when(addressService.getAllAddresses()).thenReturn(addresss);

		MvcResult result = mvc
				.perform(MockMvcRequestBuilders.get("/address")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();


		verify(addressService, times(1)).getAllAddresses();
		String responseJSON = result.getResponse().getContentAsString();

		for (int i = 0; i < 3; i++)
		{
			assertTrue(responseJSON.contains("\"addressId\":" + i));
		}

	}


	@Test
	@DisplayName("Delete address")
	void testDeleteAddressSuccess() throws Exception {

		final int id = 999;

		mvc
				.perform(MockMvcRequestBuilders.delete("/address/" + id)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();


		verify(addressService, times(1)).deleteAddress(id);
	}






}
