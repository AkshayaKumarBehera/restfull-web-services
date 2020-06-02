package com.akki.rest.webservices.restfullwebservices.services;

import com.akki.rest.webservices.restfullwebservices.dao.PriceDao;
import com.akki.rest.webservices.restfullwebservices.model.PriceModel;
import com.akki.rest.webservices.restfullwebservices.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class PriceServiceImpl implements PriceService{

	@Autowired
	private PriceDao priceDao;

	public Collection<PriceModel> getAllPrices(){
		return priceDao.getProductsPrices();
	}

	public PriceModel createProductPrice(PriceModel newPriceModel) {
		if (newPriceModel.getProduct_id() <= 0) {
			throw new ProductNotFoundException("Product id should not be negative");
		}
		PriceModel newPriceData = priceDao.createProductPrice(newPriceModel);
		return  newPriceData;
	}

	public PriceModel updatePrice(Integer productId, PriceModel updatedPriceModel){
		return priceDao.updateProductPrice(productId, updatedPriceModel);
	}

	public PriceModel deletePriceByProdId(Integer productId) {

		return priceDao.deletePriceByProductId(productId);
	}

	public PriceModel findPriceByProductId(Integer productId){

		return priceDao.findPriceByProductId(productId);
	}

}
