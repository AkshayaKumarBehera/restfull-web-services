package com.akki.rest.webservices.restfullwebservices.products;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class ProductResource {

	@Autowired
	private ProductDaoService service;

	@GetMapping("/products")
	public List<Product> retrieveAllProducts() {
		return service.findAll();
	}

	@GetMapping("/products/{id}")
	public Product retrieveUser(@PathVariable int id) {
		Product product = service.findOne(id);
		
		if(product==null)
			throw new ProductNotFoundException("id-"+ id);
		
		return product;
	}

	@DeleteMapping("/products/{id}")
	public void deleteUser(@PathVariable int id) {
		Product product = service.deleteById(id);
		
		if(product==null)
			throw new ProductNotFoundException("id-"+ id);
	}

	@PostMapping("/products")
	public ResponseEntity<Object> createUser(@Valid @RequestBody Product product) {
		Product savedProduct = service.save(product);
		URI location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(savedProduct.getProduct_id()).toUri();
		
		return ResponseEntity.created(location).build();
		
	}
}
