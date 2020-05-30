package com.akki.rest.webservices.restfullwebservices.services;

import com.akki.rest.webservices.restfullwebservices.model.PriceModel;
import com.akki.rest.webservices.restfullwebservices.model.PriceDataModel;
import com.akki.rest.webservices.restfullwebservices.exception.ProductNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class PriceServiceImpl implements PriceService{

	private static PriceDataModel priceDataModel = new PriceDataModel();

 public PriceDataModel findPriceByProductId(int productId){

 	if(100 == productId) {
		PriceDataModel priceDataModel1 = new PriceDataModel();
		priceDataModel1.setProduct_id(100);
		PriceModel priceModel1 = new PriceModel();
		priceModel1.setMaxPrice(new Double(5.00));
		priceModel1.setMinPrice(new Double(4.50));
		priceModel1.setRange("4.00-5.00");
		priceDataModel1.setPriceModel(priceModel1);
		return priceDataModel1;
	}
 	else if(200 == productId) {
		PriceDataModel priceDataModel2 = new PriceDataModel();
		priceDataModel2.setProduct_id(200);
		PriceModel priceModel2 = new PriceModel();
		priceModel2.setMaxPrice(new Double(5.00));
		priceModel2.setMinPrice(new Double(4.50));
		priceModel2.setRange("4.00-5.00");
		priceDataModel2.setPriceModel(priceModel2);
		return priceDataModel2;
	}

 	else if(300 == productId) {
		PriceDataModel priceDataModel3 = new PriceDataModel();
		priceDataModel3.setProduct_id(300);
		PriceModel priceModel3 = new PriceModel();
		priceModel3.setMaxPrice(new Double(5.00));
		priceModel3.setMinPrice(new Double(4.50));
		priceModel3.setRange("4.00-5.00");
		priceDataModel3.setPriceModel(priceModel3);
		return priceDataModel3;
	}

	 else{
	 	throw new ProductNotFoundException("Product Id:"+ productId);
	 }
 }
	public PriceDataModel save(PriceDataModel priceDataModel) {
		if (priceDataModel.getProduct_id() < 0) {
			throw new ProductNotFoundException("Product id not found");
		}
		PriceDataModel newPriceDataModel = new PriceDataModel(priceDataModel.getProduct_id(), priceDataModel.getPriceModel());
		return newPriceDataModel;
	}

	public PriceDataModel deleteByProdId(int productId) {
		if(priceDataModel.getPriceModel() != null){
			priceDataModel.setPriceModel(null);
		}
		return priceDataModel;
	}

}
