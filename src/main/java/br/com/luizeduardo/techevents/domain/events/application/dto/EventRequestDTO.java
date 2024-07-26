package br.com.luizeduardo.techevents.domain.events.application.dto;

import org.springframework.web.multipart.MultipartFile;

import java.time.Instant;

public record EventRequestDTO(
	String title,
	String description,
	String eventUrl,
	Instant date,
	String city,
	String state,
	Boolean remote,
	String imageUrl
) {

	public static EventRequestDTO with(
		final String title,
		final String description,
		final String eventUrl,
		final Instant date,
		final String  city,
		final String state,
		final Boolean remote,
		final String imageUrl
	) {
		return new EventRequestDTO(
			title,
			description,
			eventUrl,
			date,
			city,
			state,
			remote,
			imageUrl
		);
	}
}
