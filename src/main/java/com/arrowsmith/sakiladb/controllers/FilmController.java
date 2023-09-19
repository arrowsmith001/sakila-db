package com.arrowsmith.sakiladb.controllers;

import com.arrowsmith.sakiladb.entities.Film;
import com.arrowsmith.sakiladb.services.FilmService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/film")
public class FilmController {

    @Autowired
    private FilmService filmService;

    @PostMapping(path="")
    public Film saveFilm(@RequestBody Film film) { return filmService.saveFilm(film); }

    @GetMapping("")
    public List<Film> getAllFilms() { return filmService.getAllFilms(); }

    @GetMapping("/{id}")
    public Film getFilmById(@PathVariable Integer id) {
        return filmService.getFilmById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteFilm(@PathVariable Integer id) {
        filmService.deleteFilm(id);
    }

}