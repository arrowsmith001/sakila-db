package com.arrowsmith.sakiladb.services;

import com.arrowsmith.sakiladb.entities.Actor;
import com.arrowsmith.sakiladb.repositories.ActorRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
class ActorServiceTests {

	@Autowired
	private ObjectMapper objectMapper;

	@Mock
	private ActorRepository actorRepository;

	@InjectMocks
	private ActorService actorService;


	@Test
	void getAllSuccess() {
		actorService.getAllActors();

		verify(actorRepository, times(1)).findAll();
	}

	@Test
	void getByIdSuccess() {

		final int id = 999;

		actorService.getActorById(id);

		verify(actorRepository, times(1)).findById(id);
	}

	@Test
	void deleteByIdSuccess() {

		final int id = 999;

		actorService.deleteActor(id);

		verify(actorRepository, times(1)).deleteById(id);
	}


	@Test
	void saveSuccess() {

		final Actor actor = new Actor();

		actorService.saveActor(actor);

		verify(actorRepository, times(1)).save(actor);
	}


}
