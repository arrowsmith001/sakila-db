package com.arrowsmith.sakiladb.controllers;

import com.arrowsmith.sakiladb.entities.Customer;
import com.arrowsmith.sakiladb.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(path="")
    public Customer saveCustomer(@RequestBody Customer customer) {

        System.out.println(customer);
        return customerService.saveCustomer(customer); }

    @GetMapping("")
    public List<Customer> getAllCustomers() { return customerService.getAllCustomers(); }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Integer id) {
        return customerService.getCustomerById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Integer id) {
        customerService.deleteCustomer(id);
    }


    @PostMapping("/email")
    public Customer getCustomerByEmail(@RequestBody Credentials credentials){
        return customerService.getCustomerByEmail(credentials.email);
    }

}

