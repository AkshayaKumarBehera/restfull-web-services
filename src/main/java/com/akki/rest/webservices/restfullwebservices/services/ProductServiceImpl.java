package com.akki.rest.webservices.restfullwebservices.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.akki.rest.webservices.restfullwebservices.model.PriceModel;
import com.akki.rest.webservices.restfullwebservices.model.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService{
	
	private static List<ProductModel> productModels = new ArrayList<>();

	private static int productsCount = 1000;

	@Autowired
	private PriceServiceImpl priceService;

	static {
		productModels.add(new ProductModel(100, "Prod1", "Seller1","manufacturer1",new PriceModel("2-3",new Double(2.00),new Double(3.00))));
		productModels.add(new ProductModel(200, "Prod2", "Seller2","manufacturer2",new PriceModel("3-4",new Double(3.00),new Double(4.00))));
		productModels.add(new ProductModel(300, "Prod3", "Seller3","manufacturer3", new PriceModel("4-5",new Double(4.00),new Double(5.00))));
	}

	public List<ProductModel> findAll() {

		return productModels;
	}

	public ProductModel save(ProductModel productModel) {
		if (productModel.getProduct_id()== null) {
			productModel.setProduct_id(++productsCount);
		}
		productModels.add(productModel);
		return productModel;
	}

	public ProductModel findOne(int id) {
		for (ProductModel productModel : productModels) {
			if (productModel.getProduct_id() == id) {
				return productModel;
			}
		}
		return null;
	}

	public ProductModel deleteById(int id) {
		Iterator<ProductModel> iterator = productModels.iterator();
		ProductModel productModel = null;
		while (iterator.hasNext()) {
			productModel = iterator.next();
			if (productModel.getProduct_id() == id) {
				iterator.remove();
				return productModel;
			}
		}
		return productModel;
	}

	public ProductModel updateProduct(int id, ProductModel productModel) {
		ProductModel oldProduct= null;
		Iterator<ProductModel> iterator = productModels.iterator();
		while (iterator.hasNext()) {
			oldProduct = iterator.next();
			if (oldProduct.getProduct_id() == id) {
				//iterator.remove();
				//ProductModel newProduct = new ProductModel();
				oldProduct.setProduct_id(id);
				oldProduct.setTitle(productModel.getTitle());
				oldProduct.setManufacturer(productModel.getManufacturer());
				oldProduct.setSeller_Id(productModel.getSeller_Id());
				productModels.add(oldProduct);
				return oldProduct;
			}
		}
		return oldProduct;
	}
}
