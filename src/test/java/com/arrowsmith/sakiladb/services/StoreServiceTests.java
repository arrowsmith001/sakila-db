package com.arrowsmith.sakiladb.services;

import com.arrowsmith.sakiladb.entities.Store;
import com.arrowsmith.sakiladb.repositories.StoreRepository;
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
class StoreServiceTests {

	@Autowired
	private ObjectMapper objectMapper;

	@Mock
	private StoreRepository storeRepository;

	@InjectMocks
	private StoreService storeService;


	@Test
	void getAllSuccess() {
		storeService.getAllStores();

		verify(storeRepository, times(1)).findAll();
	}

	@Test
	void getByIdSuccess() {

		final int id = 999;

		storeService.getStoreById(id);

		verify(storeRepository, times(1)).findById(id);
	}

	@Test
	void deleteByIdSuccess() {

		final int id = 999;

		storeService.deleteStore(id);

		verify(storeRepository, times(1)).deleteById(id);
	}


	@Test
	void saveSuccess() {

		final Store store = new Store();

		storeService.saveStore(store);

		verify(storeRepository, times(1)).save(store);
	}


}
