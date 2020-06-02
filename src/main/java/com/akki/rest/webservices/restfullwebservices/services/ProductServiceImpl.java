package com.akki.rest.webservices.restfullwebservices.services;

import com.akki.rest.webservices.restfullwebservices.dao.ProductDao;
import com.akki.rest.webservices.restfullwebservices.model.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDao productDoa;

	public List<ProductModel> findAll() {
		return productDoa.findAll();
	}

	public ProductModel save(ProductModel productModel) {
		return productDoa.save(productModel);
	}

	public ProductModel updateProduct(int id, ProductModel productModel) {
		return productDoa.updateProduct(id, productModel);
	}

	public ProductModel deleteById(int id) {
		return productDoa.deleteById(id);
	}

	public ProductModel findOne(int id) {
		return productDoa.findOne(id);
	}
}
