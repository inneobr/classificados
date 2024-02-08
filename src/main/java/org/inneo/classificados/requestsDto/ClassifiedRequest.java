package org.inneo.classificados.requestsDto;

import java.util.UUID;

public record ClassifiedRequest(String title, String content, UUID category, UUID publisher) {
}
