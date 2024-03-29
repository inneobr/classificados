 package org.inneo.classificados.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.inneo.classificados.modelos.Category;
import org.inneo.classificados.modelos.Classified;
import org.inneo.classificados.repositories.CategoryRep;
import org.inneo.classificados.repositories.ClassifiedRep;
import org.inneo.classificados.requestSpec.ClassifieldSpecs;
import org.inneo.classificados.requestsDto.ClassifiedRequest;
import org.inneo.classificados.requestsDto.ClassifiedResponse;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class ClassifiedServices {
	private final ClassifiedRep classifiedRep;
	private final CategoryRep categoryRep;
	
	public Classified create(ClassifiedRequest request) {
		Classified classified = Classified.builder()
				.title(request.title())
				.content(request.content())
				.publisherId(request.publisher())
				.categoryId(request.category())
				.active(true)
				.views(0)
				.build();		
		
		log.info("Classified {} successfully published", classified.getUuid());
		return classifiedRep.save(classified);
	} 
	
	public void update(ClassifiedResponse request) {
		Classified classified = classifiedRep.findById(request.uuid()).get();		
		if(!request.publisher().equals(classified.getPublisherId())) {
			log.info("Only the owner of the ad can edit it.");
			throw new RuntimeException("Only the owner of the ad can edit it.");
		}	
		BeanUtils.copyProperties(request, classified);		
		classifiedRep.save(classified);
		log.info("Classified '{}' updated successfully.", classified.getTitle());		
	}
	
	public ClassifiedResponse toView(UUID uuid) {
		Classified classified = classifiedRep.findById(uuid).get();
		Category category = categoryRep.findById(classified.getCategoryId()).get();
		classified.setCategory(category.getName());
		classified.newView();
		classifiedRep.save(classified);
		
		ClassifiedResponse response = ClassifiedResponse.construir(classified);
		log.info("classified {} successfully opened.", classified.getUuid());
		return response;
	}
	
	public List<ClassifiedResponse> findAll() {
		List<Classified> classifieds = new ArrayList<>();
		for(Classified classified :classifiedRep.findAll(ClassifieldSpecs.isActive(true))){
			Category category = categoryRep.findById(classified.getCategoryId()).get();
			classified.setCategory(category.getName());
			classifieds.add(classified);
		}
		
		List<ClassifiedResponse> response = classifieds.stream().map(ClassifiedResponse::new).toList();
		log.info("Listing classified {}.", response.size());
		return response;
	}
	
	public void disable(UUID uuid) {
		Classified classified = classifiedRep.findById(uuid).get();
		classified.setActive(false);
		classifiedRep.save(classified);
		log.info("Classified {} disabled successfully.", classified.getUuid());
	}
	
	public void enable(UUID uuid) {
		Classified classified = classifiedRep.findById(uuid).get();
		classified.setActive(true);
		classifiedRep.save(classified);
		log.info("Classified {} successfully enabled.", classified.getUuid());
	}
}
