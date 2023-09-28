package com.arrowsmith.sakiladb.controllers;

import com.arrowsmith.sakiladb.entities.Rental;
import com.arrowsmith.sakiladb.services.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "https://main.d34jypsxbhc933.amplifyapp.com"})
@RequestMapping("/rental")
public class RentalController {

    @Autowired
    private RentalService rentalService;

    @PostMapping(path="")
    public Rental saveRental(@RequestBody Rental rental) { return rentalService.saveRental(rental); }

    @GetMapping("")
    public List<Rental> getAllRentals() { return rentalService.getAllRentals(); }

    @GetMapping("/{id}")
    public Rental getRentalById(@PathVariable Integer id) {
        return rentalService.getRentalById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteRental(@PathVariable Integer id) {
        rentalService.deleteRental(id);
    }


}