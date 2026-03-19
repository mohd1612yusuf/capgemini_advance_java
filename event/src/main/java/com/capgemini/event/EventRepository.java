package com.capgemini.event;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
	List<Event> findByEventDateAfter(LocalDate date);
	List<Event> findByEventType(String eventType);
	List<Event> findByTitleContainingIgnoreCase(String title);
}