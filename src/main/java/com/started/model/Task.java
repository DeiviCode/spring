package com.started.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity(name = "tasks")
public class Task {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Size(min = 3, max = 15, message = "El tamaño debe tener  entre 3 y 15 caracteres")
	@NotBlank(message = "El campo es requerido")
	private String title;
	@NotBlank(message = "El campo es requerido")
	private String description;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Task(String title, String description) {
		super();
		this.title = title;
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Task() {
	}
	
	
	
	
}
