package br.com.luizeduardo.techevents.domain.events.enterprise.entities;

import br.com.luizeduardo.techevents.domain.DomainEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Table(name = "events")
@Entity
@Getter
@Setter
public class Event extends DomainEntity {
	@Id
	private UUID id;

	private String title;

	private String description;

	private String imageUrl;

	private String eventUrl;

	private Boolean remote;

	private Instant date;

	private Instant createdAt;

	private Event(final UUID id,
								final String title,
								final String description,
								final String imageUrl,
								final String eventUrl,
								final Boolean remote,
								final Instant date,
								final Instant createdAt
								) {
			super(id);
			this.title = title;
			this.description = description;
			this.imageUrl = imageUrl;
			this.eventUrl = eventUrl;
			this.remote = remote;
			this.date = date;
			this.createdAt = createdAt;
	}

	public static Event newEvent(
		final UUID id,
		final String title,
		final String description,
		final String imageUrl,
		final String eventUrl,
		final Boolean remote,
		final Instant date
	){
		final var eventId = id != null ? id : UUID.randomUUID();
		final var now = Instant.now();

		return new Event(eventId, title, description, imageUrl, eventUrl, remote, date, now);
	}

}
