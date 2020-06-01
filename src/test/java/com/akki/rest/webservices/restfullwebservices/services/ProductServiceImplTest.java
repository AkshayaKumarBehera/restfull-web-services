package com.akki.rest.webservices.restfullwebservices.services;

import com.akki.rest.webservices.restfullwebservices.dao.ProductDaoImpl;
import com.akki.rest.webservices.restfullwebservices.model.PriceModel;
import com.akki.rest.webservices.restfullwebservices.model.ProductModel;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImplTest {

    @Mock
    ProductDaoImpl productDaoImplMock;

    @InjectMocks
    ProductServiceImpl productServiceImplMock;

    @Test
    public void testFindAllProducts() {

        List<ProductModel> productList = new ArrayList<>();
        productList.add(new ProductModel(100, "Prod1", "Seller1","manufacturer1",new PriceModel(100,"2-3",new Double(2.00),new Double(3.00))));
        productList.add(new ProductModel(200, "Prod2", "Seller2","manufacturer2",new PriceModel(200,"3-4",new Double(3.00),new Double(4.00))));
        productList.add(new ProductModel(300, "Prod3", "Seller3","manufacturer3", new PriceModel(300,"4-5",new Double(4.00),new Double(5.00))));
        Mockito.when(productDaoImplMock.findAll()).thenReturn(productList);
        Assert.assertEquals(productList, productServiceImplMock.findAll());

        Assert.assertEquals(3, productDaoImplMock.findAll().toArray().length);
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

 }

}
