package com.prosperTech.marketplace.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prosperTech.marketplace.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	public List<Product> findAllByNameContainingIgnoreCase(String name);
}
