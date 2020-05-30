package com.akki.rest.webservices.restfullwebservices.services;

import com.akki.rest.webservices.restfullwebservices.model.PriceDataModel;

public interface PriceService {
    public PriceDataModel findPriceByProductId(int productId);
    public PriceDataModel save(PriceDataModel priceDataModel);
    public PriceDataModel deleteByProdId(int productId);
}
