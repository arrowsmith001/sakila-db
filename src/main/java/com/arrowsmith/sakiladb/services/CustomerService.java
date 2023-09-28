package com.arrowsmith.sakiladb.services;

import com.arrowsmith.sakiladb.entities.Customer;
import com.arrowsmith.sakiladb.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer saveCustomer(Customer Customer) {
        return customerRepository.save(Customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Integer id) {
        return customerRepository.findById(id).orElse(null);
    }

    public void deleteCustomer(Integer id) {
        customerRepository.deleteById(id);
    }



    public Customer getCustomerByEmail(String email) {
        return customerRepository.findByEmail(email);

    }
}