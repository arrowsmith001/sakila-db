package com.arrowsmith.sakiladb.services;

import com.arrowsmith.sakiladb.entities.Customer;
import com.arrowsmith.sakiladb.repositories.CustomerRepository;
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
class CustomerServiceTests {

	@Autowired
	private ObjectMapper objectMapper;

	@Mock
	private CustomerRepository customerRepository;

	@InjectMocks
	private CustomerService customerService;

	@Test
	void getAllSuccess() {
		customerService.getAllCustomers();

		verify(customerRepository, times(1)).findAll();
	}

	@Test
	void getByIdSuccess() {

		final int id = 999;

		customerService.getCustomerById(id);

		verify(customerRepository, times(1)).findById(id);
	}

	@Test
	void deleteByIdSuccess() {

		final int id = 999;

		customerService.deleteCustomer(id);

		verify(customerRepository, times(1)).deleteById(id);
	}


	@Test
	void saveSuccess() {

		final Customer customer = new Customer();

		customerService.saveCustomer(customer);

		verify(customerRepository, times(1)).save(customer);
	}


}
