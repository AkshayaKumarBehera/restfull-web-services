package com.akki.rest.webservices.restfullwebservices.dao;

import com.akki.rest.webservices.restfullwebservices.exception.ProductNotFoundException;
import com.akki.rest.webservices.restfullwebservices.model.PriceModel;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Component
public class PriceDaoImpl implements PriceDao{

    private static Map<Integer, PriceModel> priceModels = new HashMap<Integer, PriceModel>();

    static {
        PriceModel priceModel1 = new PriceModel();
        priceModel1.setProduct_id(100);
        priceModel1.setMaxPrice(new Double(5.00));
        priceModel1.setMinPrice(new Double(4.50));
        priceModel1.setRange("4.00-5.00");
        priceModels.put(priceModel1.getProduct_id(),priceModel1);

        PriceModel priceModel2 = new PriceModel();
        priceModel2.setProduct_id(200);
        priceModel2.setMaxPrice(new Double(5.00));
        priceModel2.setMinPrice(new Double(4.50));
        priceModel2.setRange("4.00-5.00");
        priceModels.put(priceModel2.getProduct_id(),priceModel2);

        PriceModel priceModel3 = new PriceModel();
        priceModel3.setProduct_id(300);
        priceModel3.setMaxPrice(new Double(5.00));
        priceModel3.setMinPrice(new Double(4.50));
        priceModel3.setRange("4.00-5.00");
        priceModels.put(priceModel3.getProduct_id(),priceModel3);
    }

    @Override
    public PriceModel createProductPrice(PriceModel priceModel) {
        return priceModels.put(priceModel.getProduct_id(), priceModel);
    }

    @Override
    public Collection<PriceModel> getProductsPrices() {
        return priceModels.values();
    }

    @Override
    public PriceModel updateProductPrice(Integer productId, PriceModel updatedPriceModel) {
        priceModels.remove(productId);
        updatedPriceModel.setProduct_id(productId);
        priceModels.put(productId, updatedPriceModel);
        return updatedPriceModel;
    }

    @Override
    public PriceModel deletePriceByProductId(Integer productId) {
        return priceModels.remove(productId);
    }

    @Override
    public PriceModel findPriceByProductId(Integer productId) {
        for(Map.Entry<Integer,PriceModel> entry  : priceModels.entrySet()){
            if(entry.getKey().equals(productId)){
                return entry.getValue();
            }
        }
        return null;
    }
}
