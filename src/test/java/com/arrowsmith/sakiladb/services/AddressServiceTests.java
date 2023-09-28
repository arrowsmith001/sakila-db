package com.arrowsmith.sakiladb.services;

import com.arrowsmith.sakiladb.entities.Address;
import com.arrowsmith.sakiladb.repositories.AddressRepository;
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
class AddressServiceTests {

	@Autowired
	private ObjectMapper objectMapper;

	@Mock
	private AddressRepository addressRepository;

	@InjectMocks
	private AddressService addressService;


	@Test
	void contextLoads() {

	}

	@Test
	void getAllSuccess() {
		addressService.getAllAddresses();

		verify(addressRepository, times(1)).findAll();
	}

	@Test
	void getByIdSuccess() {

		final int id = 999;

		addressService.getAddressById(id);

		verify(addressRepository, times(1)).findById(id);
	}

	@Test
	void deleteByIdSuccess() {

		final int id = 999;

		addressService.deleteAddress(id);

		verify(addressRepository, times(1)).deleteById(id);
	}


	@Test
	void saveSuccess() {

		final Address address = new Address();

		addressService.saveAddress(address);

		verify(addressRepository, times(1)).save(address);
	}


}
