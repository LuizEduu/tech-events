package br.com.luizeduardo.techevents.infra.database.Jpa.repositories;

import br.com.luizeduardo.techevents.domain.events.enterprise.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EventsRepository extends JpaRepository<Event, UUID>  {}
