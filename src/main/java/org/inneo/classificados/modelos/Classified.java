package org.inneo.classificados.modelos;

import lombok.Data;
import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.NoArgsConstructor;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.CreationTimestamp;

@Builder
@Entity @Data @NoArgsConstructor @AllArgsConstructor
@Table(schema="public", name="classified")
public class Classified {
	@Id
	@GeneratedValue
    private UUID uuid;
	
	@NotBlank
	@Column(name="title")
	private String title;
	
	@Lob
	@NotBlank
	private String content;	
	
	@Column(name = "publisher_id", nullable = false)
	private UUID publisherId;
	
	@Column(name = "category_id", nullable = false)
	private UUID categoryId;
	
	@CreationTimestamp
	@Column(name = "published", updatable = false)   
	private Date published;
	
    @Column(name = "finished")
	private Date finished;	
    
	@Column(name = "active")
	private Boolean active;	
    
	@Column(name = "views")
	private Integer views;
	
	public void newView() {
		if(views == null) views = 0;
        views ++;
    }
}
