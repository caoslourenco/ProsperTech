package com.prosperTech.marketplace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.prosperTech.marketplace.model.Category;
import com.prosperTech.marketplace.repository.CategoryRepository;

@RestController
@RequestMapping("/categories")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoryController {
	@Autowired
    private CategoryRepository categoryRepository;

    //  buscar todas as categorias
    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        List<Category> categories = categoryRepository.findAll();
        return ResponseEntity.ok(categories);
    }

    //  buscar categoria por id
    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id) {
        Category category = categoryRepository.findById(id)
                .orElse(null);
        return ResponseEntity.ok(category);
    }

    // criar uma nova categoria
    @PostMapping
    public ResponseEntity<Category> create(@RequestBody Category category) {
        Category savedCategory = categoryRepository.save(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);
    }
    // atualizar uma categoria existente
    @PutMapping
    public ResponseEntity<Category> update(@RequestBody Category category) {
        if (!categoryRepository.existsById(category.getId())) {
            return ResponseEntity.notFound().build();
        }
        //category.setId();
        Category updatedCategory = categoryRepository.save(category);
        return ResponseEntity.ok(updatedCategory);
    }

    // excluir uma categoria
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!categoryRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        categoryRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // consulta específico
    @GetMapping("/name/{name}")
    public ResponseEntity<List<Category>> getByName(@PathVariable String name) {
    	return ResponseEntity.ok(categoryRepository.findAllByNameContainingIgnoreCase(name));
    }
	

}
