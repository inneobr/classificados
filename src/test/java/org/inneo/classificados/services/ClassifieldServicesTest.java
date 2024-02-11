package org.inneo.classificados.services;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import org.inneo.classificados.requestsDto.ClassifiedRequest;
import org.inneo.classificados.requestsDto.ClassifiedResponse;
import org.inneo.classificados.repositories.ClassifiedRep;
import org.inneo.classificados.modelos.Classified;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class ClassifieldServicesTest {
	
	@Mock
	ClassifiedServices classifiedServices;
	
	@Mock
	ClassifiedRep classifiedRep;
	
	ClassifiedRequest classifiedRequest;
	
	ClassifiedResponse classifielResponse;
	
	Classified classified;
	
	@BeforeEach
    public void setUp() {
		classified = Classified.builder()
				.title("Cadastro juniti test")
				.content("Apenas um cadastro de testes")
				.categoryId(UUID.randomUUID())
				.publisherId(UUID.randomUUID())
				.active(true)
				.build();
		
		classifiedRequest = new ClassifiedRequest("Cadastro juniti test", "Apenas um cadastro de testes", null, UUID.randomUUID());
    }	
	
	@Test
	@DisplayName("Shoud create a classifiel with success")
    void shoudCreateClassifielWithSuccess() {
		var response  = assertDoesNotThrow(() -> classifiedServices.create(classifiedRequest));	
		verifyNoMoreInteractions(classifiedRep);
		assertEquals(response, null);
	}
	
	@Test
	@DisplayName("Shoud find all classifiel with success")
    void shoudFindAllClassifielWithSuccess() {
	    List<ClassifiedResponse> responses = classifiedServices.findAll();
		verifyNoMoreInteractions(classifiedRep);
		assertNotNull(responses);		
	}
}
