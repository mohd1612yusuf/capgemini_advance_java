package com.capgemini.event;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/events")
public class EventController {

	private final EventService service;

	public EventController(EventService service) {
		this.service = service;
	}

	@GetMapping
	public List<Event> getAllEvents() {
		return service.getAllEvents();
	}

	@GetMapping("/upcoming")
	public List<Event> upcomingEvents() {
		return service.getUpcomingEvents();
	}

	@GetMapping("/{id}")
	public Event getEventById(@PathVariable Long id) {
		return service.getEventById(id);
	}

	@GetMapping("/type/{eventType}")
	public List<Event> filterByType(@PathVariable String eventType) {
		return service.filterByType(eventType);
	}

	@GetMapping("/search")
	public List<Event> search(@RequestParam String title) {
		return service.searchByTitle(title);
	}

	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	public Event create(@RequestBody Event event) {
		return service.createEvent(event);
	}

	@PutMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public Event update(@PathVariable Long id, @RequestBody Event event) {
		return service.updateEvent(id, event);
	}

	@PatchMapping("/{id}/cancel")
	@PreAuthorize("hasRole('ADMIN')")
	public Event cancel(@PathVariable Long id) {
		return service.cancelEvent(id);
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public String delete(@PathVariable Long id) {
		service.deleteEvent(id);
		return "Event deleted";
	}
}