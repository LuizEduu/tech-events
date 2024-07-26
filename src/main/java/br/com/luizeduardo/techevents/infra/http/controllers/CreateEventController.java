package br.com.luizeduardo.techevents.infra.http.controllers;

import br.com.luizeduardo.techevents.domain.events.application.dto.EventRequestDTO;
import br.com.luizeduardo.techevents.domain.events.application.usecases.CreateEventUseCase;
import br.com.luizeduardo.techevents.domain.events.enterprise.entities.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller("/events")
public class CreateEventController {

	@Autowired
	private CreateEventUseCase useCase;

	@PostMapping
	public ResponseEntity<Event> handle(@RequestBody EventRequestDTO body) throws Exception {
		final var event = this.useCase.execute(body);

		return ResponseEntity.status(HttpStatus.CREATED).body(event);
	}

}
