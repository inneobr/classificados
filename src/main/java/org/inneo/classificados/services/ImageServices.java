package org.inneo.classificados.services;

import java.util.List;
import java.util.UUID;
import java.io.IOException;

import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import jakarta.transaction.Transactional;

import org.inneo.classificados.modelos.Images;
import org.springframework.stereotype.Service;
import org.inneo.classificados.repositories.ImageRep;
import org.springframework.web.multipart.MultipartFile;
import org.inneo.classificados.requestsDto.ImagesResponse;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class ImageServices {
	private final ImageRep imageRep;
	
	public void upload(MultipartFile arquivo, UUID uuid) throws IOException {
		Images images = Images.builder()
				.bytes(ImageUtility.compressImage(arquivo.getBytes()))
				.name(arquivo.getOriginalFilename())
				.classifiedId(uuid)
				.active(true)
				.build();
		imageRep.save(images);
		log.info("Images {} successfully published", images.getClassifiedId());
	}
	
	public Images toView(UUID uuid) {
		log.info("Image successfully view.");
		return imageRep.findById(uuid).get();
	}
	
	public List<ImagesResponse> findAll() {
		List<ImagesResponse> response = imageRep.findAll().stream().map(ImagesResponse::new).toList();
		log.info("Listing images {}.", response.size());
		return response;
	}
	
	public void delete(UUID uuid) {
		Images image = imageRep.findById(uuid).get();
		image.setActive(true);
		imageRep.save(image);
		log.info("Image {} successfully disabled.", image.getUuid());
	}
	
}
