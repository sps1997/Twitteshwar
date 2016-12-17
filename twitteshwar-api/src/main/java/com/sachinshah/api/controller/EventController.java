package com.sachinshah.api.controller;

import java.util.List;

import javax.ws.rs.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sachinshah.api.model.Event;
import com.sachinshah.api.service.EventService;

@RestController
@RequestMapping(value = "/api", produces = "application/json")
public class EventController {

	private Gson gson = new GsonBuilder().create();

	@Autowired
	private EventService eventService;

	@RequestMapping(value = "/event/createOrUpdate", method = RequestMethod.POST)
	public ResponseEntity<String> createOrUpdate(@RequestBody Event event) {
		System.out.println("Create Event : " + event);

		eventService.createOrUpdate(event);

		return ResponseEntity.ok("{\"result\":\"OK\"}");

	}

	@RequestMapping(value = "/event/getAll", method = RequestMethod.GET)
	public ResponseEntity<String> getAllEvents(@RequestParam(name = "callback") String callback) {
		System.out.println("Get Events : ");

		List<Event> events = eventService.getEvents();

		return ResponseEntity.ok(String.format("%s (%s);", callback, gson.toJson(events)));

	}

	@RequestMapping(value = "/event/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteEvent(@PathVariable("id") Long eventId) {
		System.out.println("Get Events to delete : " + eventId);

		eventService.delete(eventId);

		return ResponseEntity.ok("{\"result\":\"OK\"}");

	}

}
