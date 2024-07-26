package br.com.luizeduardo.techevents.domain;

import lombok.Getter;

import java.util.Objects;
import java.util.UUID;

@Getter
public abstract class DomainEntity {
	protected final UUID id;

	protected DomainEntity(final UUID id) {
		Objects.requireNonNull(id, "'id' shoud not be null");
		this.id = id;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final DomainEntity entity = (DomainEntity) o;
		return Objects.equals(getId(), entity.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId());
	}
}
