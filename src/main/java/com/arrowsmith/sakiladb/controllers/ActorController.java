package com.arrowsmith.sakiladb.controllers;

import com.arrowsmith.sakiladb.entities.Actor;
import com.arrowsmith.sakiladb.services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/actors")
public class ActorController {

    @Autowired
    private ActorService actorService;

    @PostMapping("")
    public Actor saveActor(@RequestBody Actor actor) {
        return actorService.saveActor(actor);
    }

    @GetMapping("")
    public List<Actor> getAllActors() {
            return actorService.getAllActors();
    }

    @GetMapping("/{id}")
    public Actor getActorById(@PathVariable Short id) {
        return actorService.getActorById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteActor(@PathVariable Short id) {
        actorService.deleteActor(id);
    }
}