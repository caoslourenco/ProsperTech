package com.prosperTech.marketplace.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.prosperTechType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "tb_category")
public class Category {

	@Id
	@GeneratedValue(strategy = prosperTechType.IDENTITY)
	private Long id;
	
	
	@NotBlank(message = "O Atributo nome é obrigatório.")
	@Size(min = 3, max = 255, message = "O atributo nome deve conter no mínimo 3 e no máximo 255 caracteres.")
	private String name;
	
	@NotBlank(message = "O Atributo descrição é obrigatório.")
	@Size(min = 3, max = 1000, message = "O atributo descrição deve conter no mímino 3 e no máximo 1000 caracteres.")
	private String description;
	
	@OneToMany (fetch = FetchType.LAZY, mappedBy = "category", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("category")
	private List<Product> product;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}
	
	
}
