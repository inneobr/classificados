package org.inneo.classificados.application;

import java.util.List;
import java.util.UUID;

import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import org.inneo.classificados.modelos.Images;
import org.inneo.classificados.requestsDto.ImagesResponse;
import org.inneo.classificados.services.ImageServices;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/classified")
public class ImageController {
	private final ImageServices imageServices;
	
	@PostMapping("/image:{uuid}")
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestParam("arquivo") MultipartFile arquivo, @PathVariable(name="uuid") UUID uuid) throws IOException {			
		imageServices.upload(arquivo, uuid);
	}	
	
	@GetMapping("/image:{uuid}")
	@ResponseStatus(HttpStatus.CREATED)
	public Images toView(@PathVariable(name="uuid") UUID uuid) {
		return imageServices.toView(uuid);
	}
	
	@GetMapping("/image")
	@ResponseStatus(HttpStatus.CREATED)
	public List<ImagesResponse> findAll() {
		return imageServices.findAll();
	}
	
	@DeleteMapping("/image/disable:{uuid}")
	@ResponseStatus(HttpStatus.CREATED)
	public void delete(@PathVariable(name="uuid") UUID uuid) {
		imageServices.delete(uuid);
	}
}
