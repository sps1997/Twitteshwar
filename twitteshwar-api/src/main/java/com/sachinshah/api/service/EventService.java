package com.sachinshah.api.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sachinshah.api.model.Event;

@Service
public class EventService {

	public void createOrUpdate(Event event) {
		// TODO Auto-generated method stub
		
	}
	
	public void delete(Long eventId) {
		// TODO Auto-generated method stub
		
	}

	public List<Event> getEvents() {
		List<Event> events = new ArrayList<Event>();
		
		Event event = new Event();
		event.setId(1000l);
		event.setName("Test Event 1");
		event.setDescription("aking bath cermeony at 1");
		event.setDate(new Date());
		event.setCreatedBy("Sachin Shah");
		
		events.add(event);
		
		event = new Event();
		event.setId(1001l);
		event.setName("Test Event 2");
		event.setDescription("TEst event at mustafa later at 2 pm");
		event.setDate(new Date());
		event.setCreatedBy("Munish Gogna");
		
		events.add(event);
		
		
		return events;
	}

	
}
