package com.arrowsmith.sakiladb.services;

import com.arrowsmith.sakiladb.entities.Rental;
import com.arrowsmith.sakiladb.repositories.RentalRepository;
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
class RentalServiceTests {

	@Autowired
	private ObjectMapper objectMapper;

	@Mock
	private RentalRepository rentalRepository;

	@InjectMocks
	private RentalService rentalService;

	@Test
	void getAllSuccess() {
		rentalService.getAllRentals();

		verify(rentalRepository, times(1)).findAll();
	}

	@Test
	void getByIdSuccess() {

		final int id = 999;

		rentalService.getRentalById(id);

		verify(rentalRepository, times(1)).findById(id);
	}

	@Test
	void deleteByIdSuccess() {

		final int id = 999;

		rentalService.deleteRental(id);

		verify(rentalRepository, times(1)).deleteById(id);
	}


	@Test
	void saveSuccess() {

		final Rental rental = new Rental();

		rentalService.saveRental(rental);

		verify(rentalRepository, times(1)).save(rental);
	}


}
