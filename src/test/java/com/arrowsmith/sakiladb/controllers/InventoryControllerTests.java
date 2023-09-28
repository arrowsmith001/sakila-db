package com.arrowsmith.sakiladb.controllers;

import com.arrowsmith.sakiladb.entities.Inventory;
import com.arrowsmith.sakiladb.services.InventoryService;
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

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@WebMvcTest(InventoryController.class)
class InventoryControllerTests {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper objectMapper;

	@MockBean
	private InventoryService inventoryService;


	@Test
	@DisplayName("Get Inventory by Id")
	public void testGetInventorySuccess() throws Exception {

		final Inventory inventory = new Inventory();
		final int id = 1;

		inventory.setInventoryId(id);

		when(inventoryService.getInventoryById(id)).thenReturn(inventory);

		MvcResult result = mvc.perform(MockMvcRequestBuilders
				.get("/inventory/" + id)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();

		verify(inventoryService, times(1)).getInventoryById(1);

		String responseJSON = result.getResponse().getContentAsString();
		assertTrue(responseJSON.contains("\"inventoryId\":" + id));
	}

	@Test
	@DisplayName("Add New Inventory")
	public void testAddNewInventorySuccess() throws Exception {

		final Inventory inventory = new Inventory();
		final int id = 999;

		inventory.setInventoryId(id);

		when(inventoryService.saveInventory(any(Inventory.class))).thenReturn(inventory);

		MvcResult result = mvc
				.perform(MockMvcRequestBuilders.post("/inventory")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(new Inventory())))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();


		verify(inventoryService, times(1)).saveInventory(any(Inventory.class));

		String responseJSON = result.getResponse().getContentAsString();
		assertTrue(responseJSON.contains("\"inventoryId\":" + id));

	}

	@Test
	@DisplayName("Get Inventories by Film and Store")
	public void testGetAllInventorysSuccess() throws Exception {

		final int filmId = 999;
		final int storeId = 777;

		MvcResult result = mvc
				.perform(MockMvcRequestBuilders.get("/inventory?filmId=" + filmId + "&storeId=" + storeId)
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();

		verify(inventoryService, times(1)).findAllByFilmIdAndStoreId(filmId, storeId);


	}


	@Test
	@DisplayName("Delete inventory")
	public void testDeleteInventorySuccess() throws Exception {

		final int id = 999;

		mvc
				.perform(MockMvcRequestBuilders.delete("/inventory/" + id)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();


		verify(inventoryService, times(1)).deleteInventory(id);
	}






}
