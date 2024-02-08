package org.inneo.classificados.modelos;

import lombok.Data;
import java.util.UUID;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.validation.constraints.NotBlank;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
@Table(schema = "public", name = "comment")
public class Comment {
	@Id
	@GeneratedValue
    private UUID uuid;
	
	@NotBlank
	@Column(name="content")
	private String content;
	
	@NotBlank
	@Column(name = "publisher_id")
	private UUID publisherId;	
	
	@NotBlank
	@Column(name = "classified_id")
	private UUID classifiedId;
	
	private Boolean active;
}
