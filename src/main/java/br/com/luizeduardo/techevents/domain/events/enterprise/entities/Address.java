package br.com.luizeduardo.techevents.domain.events.enterprise.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Table(name = "address")
@Entity
@Data
@NoArgsConstructor
public class Address {

	@Id
	@GeneratedValue
	private UUID id;

	private String city;

	private String uf;

	private String street;

	private String number;

	@ManyToOne()
	@JoinColumn(name = "event_id")
	private Event event;

}
