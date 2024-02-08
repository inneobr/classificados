package org.inneo.classificados.requestsDto;

import java.util.UUID;

import org.inneo.classificados.modelos.Category;

public record CategoryResponse(UUID uuid, String name) {
	public CategoryResponse(Category category) {
		 this(category.getUuid(), category.getName());	
	}
}
