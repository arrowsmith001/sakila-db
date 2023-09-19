package com.arrowsmith.sakiladb.services;

import com.arrowsmith.sakiladb.entities.Address;
import com.arrowsmith.sakiladb.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    public Address getAddressById(Integer id) {
        return addressRepository.findById(id).orElse(null);
    }

    public void deleteAddress(Integer id) {
        addressRepository.deleteById(id);
    }
}