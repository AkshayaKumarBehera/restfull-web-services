package com.akki.rest.webservices.restfullwebservices.dao;

import com.akki.rest.webservices.restfullwebservices.model.PriceModel;

import java.util.Collection;

public interface PriceDao {
    public PriceModel createProductPrice(PriceModel priceModel);
    public Collection<PriceModel> getProductsPrices();
    public PriceModel updateProductPrice(Integer productId, PriceModel updatedPriceModel);
    public PriceModel deletePriceByProductId(Integer productId);
    public PriceModel findPriceByProductId(Integer productId);
}
