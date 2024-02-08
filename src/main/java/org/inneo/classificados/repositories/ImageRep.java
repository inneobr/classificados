package org.inneo.classificados.repositories;

import java.util.UUID;
import org.inneo.classificados.modelos.Images;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ImageRep extends JpaRepository<Images, UUID>, JpaSpecificationExecutor<Images>{

}
