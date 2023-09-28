package com.arrowsmith.sakiladb.services;

import com.arrowsmith.sakiladb.entities.Actor;
import com.arrowsmith.sakiladb.repositories.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService {

    @Autowired
    private ActorRepository actorRepository;

    public Actor saveActor(Actor actor) {
        return actorRepository.save(actor);
    }

    public List<Actor> getAllActors() {
        return actorRepository.findAll();
    }

    public Actor getActorById(Integer id) {
        return actorRepository.findById(id).orElse(null);
    }

    public void deleteActor(Integer id) {
        actorRepository.deleteById(id);
    }
}