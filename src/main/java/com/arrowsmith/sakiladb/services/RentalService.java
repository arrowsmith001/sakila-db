package com.arrowsmith.sakiladb.services;

import com.arrowsmith.sakiladb.entities.Rental;
import com.arrowsmith.sakiladb.repositories.RentalRepository;
import com.arrowsmith.sakiladb.repositories.InventoryRepository;
import com.arrowsmith.sakiladb.repositories.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalService {

    @Autowired
    private RentalRepository rentalRepository;

    public Rental saveRental(Rental Rental) {
        return rentalRepository.save(Rental);
    }

    public List<Rental> getAllRentals() {
        return rentalRepository.findAll();
    }

    public Rental getRentalById(Integer id) {
        return rentalRepository.findById(id).orElse(null);
    }

    public void deleteRental(Integer id) {


        rentalRepository.deleteById(id);
    }

}