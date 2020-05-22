package com.akki.rest.webservices.restfullwebservices.products;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ProductDaoService {
	
	private static List<Product> products = new ArrayList<>();

	private static int usersCount = 1000;

	static {
		products.add(new Product(100, "Prod1", "Seller1","manfock1"));
		products.add(new Product(200, "Prod2", "Seller2","manfock2"));
		products.add(new Product(300, "Prod3", "Seller3","manfock3"));
	}

	public List<Product> findAll() {
		return products;
	}

	public Product save(Product product) {
		if (product.getProduct_id()== null) {
			product.setProduct_id(++usersCount);
		}
		products.add(product);
		return product;
	}

	public Product findOne(int id) {
		for (Product product : products) {
			if (product.getProduct_id() == id) {
				return product;
			}
		}
		return null;
	}

	public Product deleteById(int id) {
		Iterator<Product> iterator = products.iterator();
		while (iterator.hasNext()) {
			Product product = iterator.next();
			if (product.getProduct_id() == id) {
				iterator.remove();
				return product;
			}
		}
		return null;
	}

}
