package com.arrowsmith.sakiladb.controllers;

import com.arrowsmith.sakiladb.entities.Address;
import com.arrowsmith.sakiladb.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "https://main.d34jypsxbhc933.amplifyapp.com"})
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping("")
    public Address saveAddress(@RequestBody Address address) {return addressService.saveAddress(address);}

    @GetMapping("")
    public List<Address> getAllAddresses() { return addressService.getAllAddresses(); }

    @GetMapping("/{id}")
    public Address getAddressById(@PathVariable Integer id) {
        return addressService.getAddressById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable Integer id) {
        addressService.deleteAddress(id);
    }
}