package com.arrowsmith.sakiladb.services;

import com.arrowsmith.sakiladb.entities.City;
import com.arrowsmith.sakiladb.repositories.CityRepository;
import com.arrowsmith.sakiladb.repositories.InventoryRepository;
import com.arrowsmith.sakiladb.repositories.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private InventoryRepository inventoryRepository;
    @Autowired
    private RentalRepository rentalRepository;

    public City saveCity(City city) {
        return cityRepository.save(city);
    }

    public List<City> getAllCitys() {
        return cityRepository.findAll();
    }

    public City getCityById(Integer id) {
        return cityRepository.findById(id).orElse(null);
    }

    public void deleteCity(Integer id) {

        cityRepository.deleteById(id);
    }


}