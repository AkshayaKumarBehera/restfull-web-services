package com.akki.rest.webservices.restfullwebservices.controller;

import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import com.akki.rest.webservices.restfullwebservices.services.PriceServiceImpl;
import com.akki.rest.webservices.restfullwebservices.services.ProductServiceImpl;
import com.akki.rest.webservices.restfullwebservices.exception.ProductNotFoundException;
import com.akki.rest.webservices.restfullwebservices.model.ProductModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ProductController {

	@Autowired
	private ProductServiceImpl service;

	@Autowired
	private PriceServiceImpl priceServiceImpl;

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@GetMapping("/products")
	public ResponseEntity<Object> retrieveAllProducts() {
		logger.info("retrieveAllProducts Method entry to retrieve all products");
		return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
	}

	@PutMapping("/products/{id}")
	public ResponseEntity<Object> updateProduct(@PathVariable int id, @RequestBody ProductModel productModel) {
		logger.info("updateProduct Method entry to update certain product");

		ProductModel updatedProduct = service.updateProduct(id, productModel);

		if(updatedProduct ==null)
			throw new ProductNotFoundException("id-"+ id);

		return new ResponseEntity<>("Product is updated successfully", HttpStatus.OK);
	}

	@DeleteMapping("/products/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable int id) {
		logger.info("deleteUser Method entry to delete certain product");
		ProductModel productModel = service.deleteById(id);
		if(productModel ==null)
			throw new ProductNotFoundException("id-"+ id);
		return new ResponseEntity<>("Product is deleted successfully", HttpStatus.OK);
	}

	@PostMapping("/products")
	public ResponseEntity<Object> createProduct(@Valid @RequestBody ProductModel productModel) {
		logger.info("createProduct Method entry to create certain product");
		ProductModel savedProductModel = service.save(productModel);
		return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
	}

	@GetMapping("/products/{id}")
	public ResponseEntity<Object> retrieveProduct(@PathVariable int id) {
		logger.info("retrieveProduct Method entry to retrieve certain product");
		ProductModel productModel = service.findOne(id);

		if(productModel ==null)
			throw new ProductNotFoundException("id-"+ id);

		EntityModel<ProductModel> model = new EntityModel<>(productModel);
		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllProducts());
		model.add(linkTo.withRel("all-products"));

		return new ResponseEntity<>(model, HttpStatus.OK);
	}
}
