package com.capgemini.event;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class EventService {

	private final EventRepository repo;

	public EventService(EventRepository repo) {
		this.repo = repo;
	}

	public List<Event> getAllEvents() {
		return repo.findAll();
	}

	public List<Event> getUpcomingEvents() {
		return repo.findByEventDateAfter(LocalDate.now());
	}

	public Event getEventById(Long id) {
		return repo.findById(id).orElseThrow(() -> new RuntimeException("Event not found"));
	}

	public List<Event> filterByType(String type) {
		return repo.findByEventType(type);
	}

	public List<Event> searchByTitle(String keyword) {
		return repo.findByTitleContainingIgnoreCase(keyword);
	}

	public Event createEvent(Event event) {
		event.setStatus("SCHEDULED");
		return repo.save(event);
	}

	public Event updateEvent(Long id, Event updated) {
		Event e = getEventById(id);

		e.setTitle(updated.getTitle());
		e.setDescription(updated.getDescription());
		e.setEventType(updated.getEventType());
		e.setLocation(updated.getLocation());
		e.setEventDate(updated.getEventDate());
		e.setStartTime(updated.getStartTime());
		e.setEndTime(updated.getEndTime());

		return repo.save(e);
	}

	public Event cancelEvent(Long id) {
		Event e = getEventById(id);
		e.setStatus("CANCELLED");
		return repo.save(e);
	}

	public void deleteEvent(Long id) {
		repo.deleteById(id);
	}
}