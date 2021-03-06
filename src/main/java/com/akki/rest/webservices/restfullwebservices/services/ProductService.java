package com.akki.rest.webservices.restfullwebservices.services;

import com.akki.rest.webservices.restfullwebservices.model.ProductModel;

import java.util.List;

public interface ProductService {
    public List<ProductModel> findAll();
    public ProductModel save(ProductModel productModel);
    public ProductModel findOne(int id);
    public ProductModel deleteById(int id);
    public ProductModel updateProduct(int id, ProductModel productModel);
}
