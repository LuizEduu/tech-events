package br.com.luizeduardo.techevents.domain.events.enterprise.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Table(name = "coupons")
@Entity
@Data
@NoArgsConstructor
public class Coupon {

	@Id
	@GeneratedValue
	private UUID id;

	private Integer discount;

	private Instant valid;

	@ManyToOne
	@JoinColumn(name = "event_id")
	private Event event;
}
