package org.inneo.classificados.services;

import org.inneo.classificados.requestsDto.CategoryRequest;
import org.inneo.classificados.requestsDto.CategoryResponse;
import org.inneo.classificados.repositories.CategoryRep;
import org.inneo.classificados.requestSpec.CategorySpecs;
import org.inneo.classificados.modelos.Category;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.UUID;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class CategoryServices {
	private final CategoryRep categorRep;
	
	public void create(CategoryRequest request) {
		Category category = Category.builder()
				.name(request.name())
				.active(true)
				.build();
		
		categorRep.save(category);
		log.info("Category {} successfully registered.", category.getName());
	}
	
	public void update(CategoryResponse request) {
		Category category = categorRep.findById(request.uuid()).get();
		BeanUtils.copyProperties(request, category);		
		categorRep.save(category);
		log.info("Category {} updated successfully.", category.getName());
	}
	
	public List<CategoryResponse> findAll() {
		List<CategoryResponse> response =  categorRep.findAll(CategorySpecs.isActive(true)).stream().map(CategoryResponse::new).toList();
		log.info("Listing categories {}.", response.size());
		return response;
	}
	
	public void disable(UUID uuid) {
		Category category = categorRep.findById(uuid).get();
		category.setActive(false);
		categorRep.save(category);
		log.info("Category {} disabled successfully.", category.getUuid());
	}
	
	public void enable(UUID uuid) {
		Category category = categorRep.findById(uuid).get();
		category.setActive(true);
		categorRep.save(category);
		log.info("Category {} successfully enabled.", category.getUuid());
	}
}
