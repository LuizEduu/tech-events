package br.com.luizeduardo.techevents.domain.events.enterprise.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Table(name = "events")
@Entity
@Data
@NoArgsConstructor
public class Event {
	@Id
	@GeneratedValue
	private UUID id;

	private String title;

	private String description;

	private String imageUrl;

	private String eventUrl;

	private Boolean remote;

	private Instant date;
}
