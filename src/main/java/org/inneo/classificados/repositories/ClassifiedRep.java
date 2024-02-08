package org.inneo.classificados.repositories;

import java.util.UUID;

import org.inneo.classificados.modelos.Classified;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ClassifiedRep extends JpaRepository<Classified, UUID>, JpaSpecificationExecutor<Classified>{
	
}
