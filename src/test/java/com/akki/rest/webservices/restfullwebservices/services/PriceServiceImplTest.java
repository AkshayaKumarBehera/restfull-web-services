package com.akki.rest.webservices.restfullwebservices.services;

import com.akki.rest.webservices.restfullwebservices.dao.PriceDaoImpl;
import com.akki.rest.webservices.restfullwebservices.model.PriceModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

@ExtendWith(MockitoExtension.class)
public class PriceServiceImplTest {
    @Mock
    PriceDaoImpl priceDaoImplMock;

    @InjectMocks
    PriceServiceImpl priceServiceImplMock;

    @Test
    public void getAllPrices(){
        Map<Integer, PriceModel> priceModels = new HashMap<Integer, PriceModel>();

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

        Mockito.when(priceDaoImplMock.getProductsPrices()).thenReturn(priceModels.values());
        Assertions.assertEquals(priceModels.values(), priceServiceImplMock.getAllPrices());
    }

    @Test
    public void findPriceByProductId(){
        PriceModel priceModel = new PriceModel();
        priceModel.setMaxPrice(5.0);
        priceModel.setMinPrice(4.0);
        priceModel.setRange("4-5");


        Mockito.when(priceDaoImplMock.findPriceByProductId(100)).thenReturn(priceModel);
        Assertions.assertEquals(priceModel, priceServiceImplMock.findPriceByProductId(100));
    }
}
