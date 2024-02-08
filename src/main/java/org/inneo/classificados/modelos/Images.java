package org.inneo.classificados.modelos;

import lombok.Data;

import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.UUID;
import jakarta.persistence.Id;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.validation.constraints.NotBlank;

@Builder
@Entity @Data @NoArgsConstructor @AllArgsConstructor
@Table(schema = "public", name = "images")
public class Images {
	@Id
	@GeneratedValue
    private UUID uuid;
	
	@NotBlank
	@Column(name = "name")
    private String name;
    
    @Column(name = "classifiedId", nullable = false)
	private UUID classifiedId;
    
    @Column(name = "image")
    private byte[] bytes; 
    
    private Boolean active;
    
    public String getBytesToBase64() {
    	Encoder encoder = Base64.getUrlEncoder();
    	return encoder.encodeToString(bytes);
    }
    
}
