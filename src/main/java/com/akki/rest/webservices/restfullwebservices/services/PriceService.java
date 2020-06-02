package com.akki.rest.webservices.restfullwebservices.services;

import com.akki.rest.webservices.restfullwebservices.model.PriceModel;

import java.util.Collection;

public interface PriceService {
    public PriceModel createProductPrice(PriceModel priceModel);
    public Collection<PriceModel> getAllPrices();
    public PriceModel updatePrice(Integer productId, PriceModel updatedPriceModel);
    public PriceModel deletePriceByProdId(Integer productId);
    public PriceModel findPriceByProductId(Integer productId);

}
