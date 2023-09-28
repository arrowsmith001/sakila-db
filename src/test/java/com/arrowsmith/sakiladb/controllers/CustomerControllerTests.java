package com.arrowsmith.sakiladb.controllers;

import com.arrowsmith.sakiladb.entities.Customer;
import com.arrowsmith.sakiladb.services.CustomerService;
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


@WebMvcTest(CustomerController.class)
class CustomerControllerTests {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper objectMapper;

	@MockBean
	private CustomerService customerService;


	@Test
	@DisplayName("Get Customer by Id")
	public void testGetCustomerSuccess() throws Exception {

		final Customer customer = new Customer();
		final int id = 1;

		customer.setCustomer_id(id);

		when(customerService.getCustomerById(id)).thenReturn(customer);

		MvcResult result = mvc.perform(MockMvcRequestBuilders
				.get("/customer/" + id)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();

		verify(customerService, times(1)).getCustomerById(1);

		String responseJSON = result.getResponse().getContentAsString();
		assertTrue(responseJSON.contains("\"customer_id\":" + id));
	}

	@Test
	@DisplayName("Add New Customer")
	public void testAddNewCustomerSuccess() throws Exception {

		final Customer customer = new Customer();
		final int id = 999;

		customer.setCustomer_id(id);

		when(customerService.saveCustomer(any(Customer.class))).thenReturn(customer);

		MvcResult result = mvc
				.perform(MockMvcRequestBuilders.post("/customer")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(new Customer())))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();


		verify(customerService, times(1)).saveCustomer(any(Customer.class));

		String responseJSON = result.getResponse().getContentAsString();
		assertTrue(responseJSON.contains("\"customer_id\":" + id));

	}

	@Test
	@DisplayName("Get All Customers")
	public void testGetAllCustomersSuccess() throws Exception {

		final List<Customer> customers = new ArrayList<>();

		for (int i = 0; i < 3; i++)
		{
			final Customer newCustomer = new Customer();
			newCustomer.setCustomer_id(i);
			customers.add(newCustomer);
		}

		when(customerService.getAllCustomers()).thenReturn(customers);

		MvcResult result = mvc
				.perform(MockMvcRequestBuilders.get("/customer")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();


		verify(customerService, times(1)).getAllCustomers();
		String responseJSON = result.getResponse().getContentAsString();

		for (int i = 0; i < 3; i++)
		{
			assertTrue(responseJSON.contains("\"customer_id\":" + i));
		}

	}


	@Test
	@DisplayName("Delete customer")
	public void testDeleteCustomerSuccess() throws Exception {

		final int id = 999;

		mvc
				.perform(MockMvcRequestBuilders.delete("/customer/" + id)
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();


		verify(customerService, times(1)).deleteCustomer(id);
	}
	@Test
	@DisplayName("Get customer by email")
	public void getCustomerByEmail() throws Exception {

		final String email = "a@a.a";
		final Credentials credentials = new Credentials();
		credentials.email = email;

		mvc
				.perform(MockMvcRequestBuilders.delete("/customer/email")
						.content(objectMapper.writeValueAsString(credentials))
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();


		verify(customerService, times(1)).getCustomerByEmail(email);
	}






}
