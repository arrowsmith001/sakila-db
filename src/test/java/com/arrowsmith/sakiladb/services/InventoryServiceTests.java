package com.arrowsmith.sakiladb.services;

import com.arrowsmith.sakiladb.entities.Inventory;
import com.arrowsmith.sakiladb.repositories.InventoryRepository;
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
class InventoryServiceTests {

	@Autowired
	private ObjectMapper objectMapper;

	@Mock
	private InventoryRepository inventoryRepository;

	@InjectMocks
	private InventoryService inventoryService;


	@Test
	void contextLoads() {

	}

	@Test
	void getAllSuccess() {
		inventoryService.getAllInventorys();

		verify(inventoryRepository, times(1)).findAll();
	}

	@Test
	void getByIdSuccess() {

		final int id = 999;

		inventoryService.getInventoryById(id);

		verify(inventoryRepository, times(1)).findById(id);
	}

	@Test
	void deleteByIdSuccess() {

		final int id = 999;

		inventoryService.deleteInventory(id);

		verify(inventoryRepository, times(1)).deleteById(id);
	}


	@Test
	void saveSuccess() {

		final Inventory inventory = new Inventory();

		inventoryService.saveInventory(inventory);

		verify(inventoryRepository, times(1)).save(inventory);
	}


}
