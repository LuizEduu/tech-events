package br.com.luizeduardo.techevents.domain.events.application.usecases;

import br.com.luizeduardo.techevents.domain.events.application.dto.EventRequestDTO;
import br.com.luizeduardo.techevents.domain.events.enterprise.entities.Event;
import br.com.luizeduardo.techevents.infra.database.Jpa.repositories.EventsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CreateEventUseCase {

	@Autowired
	private EventsRepository eventsRepository;

	public Event execute(EventRequestDTO dto) {
			final var id = UUID.randomUUID();

			final var event =  Event.newEvent(id, dto.title(), dto.description(), dto.imageUrl(), dto.eventUrl(), dto.remote(), dto.date());

			this.eventsRepository.save(event);

			return event;
	}
}
