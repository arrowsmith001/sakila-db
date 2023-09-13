package com.arrowsmith.sakiladb;

import com.arrowsmith.sakiladb.entities.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {

    @Autowired
    private FilmRepository filmRepository;

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
        filmRepository.deleteById(id);
    }
}