package com.arrowsmith.sakiladb.controllers;

import com.arrowsmith.sakiladb.entities.Actor;
import com.arrowsmith.sakiladb.services.ActorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@WebMvcTest(ActorController.class)
public class ActorControllerTests {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper objectMapper;

	@MockBean
	private ActorService actorService;



	@Test
	@DisplayName("Get Actor by Id")
	public void testGetActorSuccess() throws Exception {

		final Actor actor = new Actor();
		final int id = 1;

		actor.setActorId(id);

		when(actorService.getActorById(id)).thenReturn(actor);

		MvcResult result = mvc.perform(MockMvcRequestBuilders
				.get("/actor/" + id)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();

		verify(actorService, times(1)).getActorById(1);

		String responseJSON = result.getResponse().getContentAsString();
		assertTrue(responseJSON.contains("\"actorId\":" + id));
	}

	@Test
	@DisplayName("Add New Actor")
	public void testAddNewActorSuccess() throws Exception {

		final Actor actor = new Actor();
		final int id = 999;

		actor.setActorId(id);

		when(actorService.saveActor(any(Actor.class))).thenReturn(actor);

		MvcResult result = mvc
				.perform(MockMvcRequestBuilders.post("/actor")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(new Actor())))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();


		verify(actorService, times(1)).saveActor(any(Actor.class));

		String responseJSON = result.getResponse().getContentAsString();
		assertTrue(responseJSON.contains("\"actorId\":" + id));

	}

	@Test
	@DisplayName("Get All Actors")
	public void testGetAllActorsSuccess() throws Exception {

		final List<Actor> actors = new ArrayList<>();

		for (int i = 0; i < 3; i++)
		{
			final Actor newActor = new Actor();
			newActor.setActorId(i);

			actors.add(newActor);
		}

		when(actorService.getAllActors()).thenReturn(actors);

		MvcResult result = mvc
				.perform(MockMvcRequestBuilders.get("/actor")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();


		verify(actorService, times(1)).getAllActors();
		String responseJSON = result.getResponse().getContentAsString();

		for (int i = 0; i < 3; i++)
		{
			assertTrue(responseJSON.contains("\"actorId\":" + i));
		}

	}


	@Test
	@DisplayName("Delete actor")
	public void testDeleteActorSuccess() throws Exception {

		final int id = 999;

		mvc
				.perform(MockMvcRequestBuilders.delete("/actor/" + id)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();


		verify(actorService, times(1)).deleteActor(id);
	}






}
