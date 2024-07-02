package com.prosperTech.marketplace.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.prosperTechType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_user")
public class User {
	
	@Id
	@GeneratedValue(strategy = prosperTechType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O atributo nome não pode estar vazio.")
	@Size(min = 2, max = 255, message = "O atributo nome deve conter no mímino 2 e no máximo 255 caracteres.")
    private String name;
	
	@Schema(example = "email@email.com.br")
	@NotBlank(message = "O atributo email não pode estar vazio.")
	@Email(message = "O atributo email deve ser um email válido.")
    private String email;
	
	@NotBlank(message = "O atributo password não pode estar vazio.")
	@Size(min = 8, message = "O atributo password deve conter no mímino 8 caracteres.")
    private String password;
	
	@NotBlank(message = "O atributo address não pode estar vazio.")
	@Size(min = 5, max = 255, message = "O atributo address deve conter no mímino 3 e no máximo 255 caracteres.")
    private String address; 
	
    private String phone;
    
    private String photo;
    
    
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
    
    
}
