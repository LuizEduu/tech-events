package br.com.luizeduardo.techevents.infra.database.Jpa.repositories;

import br.com.luizeduardo.techevents.domain.events.enterprise.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaAddressRepository extends JpaRepository<Address, UUID> {
}
