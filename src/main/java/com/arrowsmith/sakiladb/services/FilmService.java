package com.arrowsmith.sakiladb.services;

import com.arrowsmith.sakiladb.entities.*;
import com.arrowsmith.sakiladb.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {

    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private FilmActorRepository filmActorRepository;
    @Autowired
    private InventoryRepository inventoryRepository;
    @Autowired
    private RentalRepository rentalRepository;

    public Film saveFilm(Film Film) {
        return filmRepository.save(Film);
    }

    public List<Film> getAllFilms() {
        return filmRepository.findAll();
    }

    public Film getFilmById(Integer id) {
        return filmRepository.findById(id).orElse(null);
    }

    public void deleteFilm(Integer id) {


        filmActorRepository.deleteByFilmId(id);
        rentalRepository.deleteByInventoriesWithFilmId(id);
        inventoryRepository.deleteByFilmId(id);

        filmRepository.deleteById(id);
    }


    public List<Film> getFilmsByCategory(Integer categoryId) {

        return filmRepository.findAllByCategory(categoryId);
    }

    public List<Film> getRandomFilmSelection(Integer limit) {
        return filmRepository.getRandomSelection(limit);
    }

    public List<Film> getPopularFilms(Integer limit){
        return filmRepository.getPopularFilms(limit);
    }

  }