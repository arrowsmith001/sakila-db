package com.arrowsmith.sakiladb.controllers;

import com.arrowsmith.sakiladb.entities.City;
import com.arrowsmith.sakiladb.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityService cityService;

    @PostMapping(path="")
    public City saveCity(@RequestBody City city) { return cityService.saveCity(city); }

    @GetMapping("")
    public List<City> getAllCitys() { return cityService.getAllCitys(); }

    @GetMapping("/{id}")
    public City getCityById(@PathVariable Integer id) {
        return cityService.getCityById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCity(@PathVariable Integer id) {
        cityService.deleteCity(id);
    }

}