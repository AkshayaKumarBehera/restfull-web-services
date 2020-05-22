package com.akki.rest.webservices.restfullwebservices.prices;

import com.akki.rest.webservices.restfullwebservices.products.Product;
import com.akki.rest.webservices.restfullwebservices.products.ProductNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PriceDaoService {

	private static List<Product> products = new ArrayList<>();
	private static PriceData priceData = new PriceData();


	static {
		priceData.setProduct_id("12345");
		Price price = new Price();
		price.setMaxPrice(new Double(5.00));
		price.setMinPrice(new Double(4.50));
		price.setRange("4.00-5.00");
		priceData.setPrice(price);
	}
 public PriceData findPriceByProductId(String productId){

	 PriceData priceData = new PriceData();
	 priceData.setProduct_id(productId);
	 Price price = new Price();
	 price.setMaxPrice(new Double(2.00));
	 price.setMinPrice(new Double(1.50));
	 price.setRange("1.00-2.00");
	 priceData.setPrice(price);

	 return priceData;
 }
	public PriceData save(PriceData priceData) {
		if (priceData.getProduct_id()== null) {
			throw new ProductNotFoundException("Product id not found");
		}
		PriceData NewPriceData = new PriceData(priceData.getProduct_id(),priceData.getPrice());
		return NewPriceData;
	}

	public PriceData deleteByProdId(int productId) {
		if(priceData.getPrice() != null){
			priceData.setPrice(null);
		}
		return priceData;
	}

}
