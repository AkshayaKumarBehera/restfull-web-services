package com.akki.rest.webservices.restfullwebservices.services;

import com.akki.rest.webservices.restfullwebservices.model.PriceDataModel;
import com.akki.rest.webservices.restfullwebservices.model.PriceModel;
import com.akki.rest.webservices.restfullwebservices.services.PriceServiceImpl;
import com.akki.rest.webservices.restfullwebservices.services.ProductServiceImpl;
import com.akki.rest.webservices.restfullwebservices.model.ProductModel;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImplTest {

    @Mock
    PriceServiceImpl priceServiceImplMock;

    @InjectMocks
    ProductServiceImpl productServiceImplMock;

    @Test
    public void testFindAllProducts() {
        PriceDataModel pp = new PriceDataModel();
        pp.setProduct_id(100);
        PriceModel priceModel = new PriceModel();
        priceModel.setMaxPrice(5.0);
        priceModel.setMinPrice(3.0);
        priceModel.setRange("4-5");
        pp.setPriceModel(priceModel);
        Mockito.when(priceServiceImplMock.findPriceByProductId(100)).thenReturn(pp);
        Assert.assertEquals(pp, priceServiceImplMock.findPriceByProductId(100));

        List<ProductModel> productList = new ArrayList<>();
        productList.add(new ProductModel(100, "Prod1", "Seller1","manufacturer1",new PriceModel("2-3",new Double(2.00),new Double(3.00))));
        productList.add(new ProductModel(200, "Prod2", "Seller2","manufacturer2",new PriceModel("3-4",new Double(3.00),new Double(4.00))));
        productList.add(new ProductModel(300, "Prod3", "Seller3","manufacturer3", new PriceModel("4-5",new Double(4.00),new Double(5.00))));
        //Mockito.when(productServiceImplMock.findAll()).thenReturn(productList);
        //Assert.assertEquals(productList, productServiceImplMock.findAll());

        Assert.assertEquals(3, productServiceImplMock.findAll().toArray().length);
        List<ProductModel>  productModels = productServiceImplMock.findAll();
        assertThat(productModels.size()).isEqualTo(3);

        //For First Product
        assertThat(productModels.get(0).getProduct_id()).isEqualTo(100);
        assertThat(productModels.get(0).getSeller_Id()).isEqualTo("Seller1");
        assertThat(productModels.get(0).getTitle()).isEqualTo("Prod1");
        assertThat(productModels.get(0).getManufacturer()).isEqualTo("manufacturer1");

        //For all products we can write here
    }
    @Test
    public void testCreateProduct(){
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
 }

}
