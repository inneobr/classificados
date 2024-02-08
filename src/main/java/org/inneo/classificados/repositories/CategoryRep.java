package org.inneo.classificados.repositories;

import java.util.UUID;

import org.inneo.classificados.modelos.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CategoryRep extends JpaRepository<Category, UUID>, JpaSpecificationExecutor<Category>{

}
