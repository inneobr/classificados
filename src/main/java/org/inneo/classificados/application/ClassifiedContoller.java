package org.inneo.classificados.application;

import java.util.List;
import java.util.UUID;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import org.inneo.classificados.services.ClassifiedServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.inneo.classificados.requestsDto.ClassifiedRequest;
import org.inneo.classificados.requestsDto.ClassifiedResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/classified")
public class ClassifiedContoller {
	
	private final ClassifiedServices classifiedServices;
	
	@PostMapping("/product")
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody @Valid ClassifiedRequest request) {
		classifiedServices.create(request);
	}
	
	@PutMapping("/product")
	@ResponseStatus(HttpStatus.CREATED)
	public void update(@RequestBody @Valid ClassifiedResponse request) {
		classifiedServices.update(request);
	}
	
	@GetMapping("/product:{uuid}")
	@ResponseStatus(HttpStatus.CREATED)
	public ClassifiedResponse view(@PathVariable(name="uuid") UUID uuid) {
		return classifiedServices.toView(uuid);
	}
	
	@GetMapping("/product")
	@ResponseStatus(HttpStatus.CREATED)
	public List<ClassifiedResponse> findAll() {
		return classifiedServices.findAll();
	}
	
	@PutMapping("/product/disable:{uuid}")
	@ResponseStatus(HttpStatus.CREATED)
	public void disable(@PathVariable(name="uuid") UUID uuid) {
		classifiedServices.disable(uuid);
	}
	
	@PutMapping("/product/enable:{uuid}")
	@ResponseStatus(HttpStatus.CREATED)
	public void enable(@PathVariable(name="uuid") UUID uuid) {
		classifiedServices.enable(uuid);
	}
	

}
