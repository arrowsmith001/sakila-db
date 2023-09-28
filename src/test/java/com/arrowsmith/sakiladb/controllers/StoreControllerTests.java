package com.arrowsmith.sakiladb.controllers;

import com.arrowsmith.sakiladb.entities.Store;
import com.arrowsmith.sakiladb.services.StoreService;
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


@WebMvcTest(StoreController.class)
class StoreControllerTests {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper objectMapper;

	@MockBean
	private StoreService storeService;


	@Test
	@DisplayName("Get Store by Id")
	void testGetStoreSuccess() throws Exception {

		final Store store = new Store();
		final int id = 1;

		store.setStoreId(id);

		when(storeService.getStoreById(id)).thenReturn(store);

		MvcResult result = mvc.perform(MockMvcRequestBuilders
				.get("/store/" + id)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();

		verify(storeService, times(1)).getStoreById(1);

		String responseJSON = result.getResponse().getContentAsString();
		assertTrue(responseJSON.contains("\"storeId\":" + id));
	}

	@Test
	@DisplayName("Add New Store")
	void testAddNewStoreSuccess() throws Exception {

		final Store store = new Store();
		final int id = 999;

		store.setStoreId(id);

		when(storeService.saveStore(any(Store.class))).thenReturn(store);

		MvcResult result = mvc
				.perform(MockMvcRequestBuilders.post("/store")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(new Store())))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();


		verify(storeService, times(1)).saveStore(any(Store.class));

		String responseJSON = result.getResponse().getContentAsString();
		assertTrue(responseJSON.contains("\"storeId\":" + id));

	}

	@Test
	@DisplayName("Get All Stores")
	void testGetAllStoresSuccess() throws Exception {

		final List<Store> stores = new ArrayList<>();

		for (int i = 0; i < 3; i++)
		{
			final Store newStore = new Store();
			newStore.setStoreId(i);
			stores.add(newStore);
		}

		when(storeService.getAllStores()).thenReturn(stores);

		MvcResult result = mvc
				.perform(MockMvcRequestBuilders.get("/store")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();


		verify(storeService, times(1)).getAllStores();
		String responseJSON = result.getResponse().getContentAsString();

		for (int i = 0; i < 3; i++)
		{
			assertTrue(responseJSON.contains("\"storeId\":" + i));
		}

	}


	@Test
	@DisplayName("Delete store")
	void testDeleteStoreSuccess() throws Exception {

		final int id = 999;

		mvc
				.perform(MockMvcRequestBuilders.delete("/store/" + id)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();


		verify(storeService, times(1)).deleteStore(id);
	}






}
