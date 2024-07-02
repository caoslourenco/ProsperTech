package com.prosperTech.marketplace.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.prosperTechType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = prosperTechType.IDENTITY)
    private Long id;
	
	@NotBlank
	@Size(min = 3, max = 255, message = "O atributo nome deve conter no mímino 3 e no máximo 1000 caracteres.")
    private String name;
	
	@NotNull(message = "O atributo inventário é obrigatório.")
    private int inventory;
    
    @NotNull(message = "O atributo preço é obrigatório.")
    @Column(precision = 8, scale = 2)
    private BigDecimal price;
    
	@Size(max = 1000, message = "O atributo descrição deve conter no máximo 1000 caracteres.")
    private String description;
    
	@Size(max = 1000, message = "O atributo foto deve conter no máximo 1000 caracteres.")
    private String photo;
    
    
    @ManyToOne
    @JsonIgnoreProperties("product")
    private Category category;

    
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

	public int getInventory() {
		return inventory;
	}

	public void setInventory(int inventory) {
		this.inventory = inventory;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
    
    
}
