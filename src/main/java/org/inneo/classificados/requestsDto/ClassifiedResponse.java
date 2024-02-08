package org.inneo.classificados.requestsDto;

import java.util.Date;
import java.util.UUID;
import org.inneo.classificados.modelos.Classified;

public record ClassifiedResponse(UUID uuid, String title, String content, UUID publisher, UUID category, Date published, Integer views) {
	public ClassifiedResponse(Classified classified) {
		 this(classified.getUuid(), classified.getTitle(), classified.getContent(), classified.getPublisherId(), classified.getCategoryId(), classified.getPublished(), classified.getViews());	
	}
	
	public static ClassifiedResponse construir(Classified classified) {
		return new ClassifiedResponse(classified.getUuid(), classified.getTitle(), classified.getContent(), classified.getPublisherId(), classified.getCategoryId(), classified.getPublished(), classified.getViews());
	}
}
