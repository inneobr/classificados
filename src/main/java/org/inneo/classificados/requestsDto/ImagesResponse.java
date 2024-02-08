package org.inneo.classificados.requestsDto;

import java.util.UUID;
import org.inneo.classificados.modelos.Images;

public record ImagesResponse(UUID uuid, String name, byte[] image) {
	
	public ImagesResponse(Images images) {
		this(images.getUuid(), images.getName(), images.getBytes());
	}
	
	public static ImagesResponse construir(Images images) {
		return new ImagesResponse(images.getUuid(), images.getName(), images.getBytes());
	}
}
