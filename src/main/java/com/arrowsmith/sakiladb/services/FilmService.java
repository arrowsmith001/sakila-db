package com.arrowsmith.sakiladb.services;

import com.arrowsmith.sakiladb.entities.*;
import com.arrowsmith.sakiladb.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class FilmService {

    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private FilmActorRepository filmActorRepository;
    @Autowired
    private FilmCategoryRepository filmCategoryRepository;
    @Autowired
    private ActorRepository actorRepository;
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
        //filmActorRepository.deleteByActorId(id); // This is nonsense

        rentalRepository.deleteByInventoriesWithFilmId(id);
        inventoryRepository.deleteByFilmId(id);

        filmRepository.deleteById(id);
    }

}