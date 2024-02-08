package org.inneo.classificados.application;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.inneo.classificados.services.CategoryServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.inneo.classificados.requestsDto.CategoryRequest;
import org.inneo.classificados.requestsDto.CategoryResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/classified")
public class CategoryController {
	private final CategoryServices categoryService;
	
	@PostMapping("/category")
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@Valid @RequestBody CategoryRequest request) {
		categoryService.create(request);
	}
	
	@PutMapping("/category")
	@ResponseStatus(HttpStatus.CREATED)
	public void update(@Valid @RequestBody CategoryResponse request) {
		categoryService.update(request);
	}
	
	@GetMapping("/category")
	@ResponseStatus(HttpStatus.CREATED)
	public List<CategoryResponse> findAll() {
		return categoryService.findAll();
	}
	
	@PutMapping("/category/disable:{uuid}")
	@ResponseStatus(HttpStatus.CREATED)
	public void disable(@PathVariable(name="uuid") UUID uuid) {
		categoryService.disable(uuid);
	}
	
	@PutMapping("/category/enable:{uuid}")
	@ResponseStatus(HttpStatus.CREATED)
	public void enable(@PathVariable(name="uuid") UUID uuid) {
		categoryService.enable(uuid);
	}
}
