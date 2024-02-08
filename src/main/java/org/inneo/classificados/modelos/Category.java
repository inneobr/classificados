package org.inneo.classificados.modelos;

import lombok.Data;
import lombok.Builder;
import java.util.UUID;
import jakarta.persistence.Id;

import lombok.NoArgsConstructor;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.validation.constraints.NotBlank;

@Builder
@Entity @Data @NoArgsConstructor @AllArgsConstructor
@Table(schema = "public", name = "category")
public class Category {
	@Id
	@GeneratedValue
    private UUID uuid;
	
	@NotBlank
	@Column(name="name", unique = true)
	private String name;
	
	@Column(name = "active")
	private Boolean active;
}
