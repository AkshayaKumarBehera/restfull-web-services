package com.akki.rest.webservices.restfullwebservices.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.akki.rest.webservices.restfullwebservices.model.PriceModel;
import com.akki.rest.webservices.restfullwebservices.model.ProductModel;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

public class ProductControllerTest extends AbstractTest {

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void getProductsList() throws Exception {
        String uri = "/products";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        ProductModel[] productlist = super.mapFromJson(content, ProductModel[].class);
        assertTrue(productlist.length > 0);
    }

    @Test
    public void createProduct() throws Exception{
        String uri = "/products";

        ProductModel productModel1 = new ProductModel();
        productModel1.setProduct_id(600);
        productModel1.setSeller_Id("Sell6");
        productModel1.setManufacturer("Manufac6");
        productModel1.setTitle("Prod6");
        PriceModel priceModel = new PriceModel();
        priceModel.setMinPrice(new Double(600));
        priceModel.setMaxPrice(new Double(700));
        priceModel.setRange("600-700");
        productModel1.setPriceModel(priceModel);

        String inputJson = super.mapToJson(productModel1);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "Product is created successfully");
    }

    @Test
    public void deleteProduct() throws Exception {
        String uri = "/products/100";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "Product is deleted successfully");
    }

    @Test
    public void updateProduct() throws Exception {
        String uri = "/products/100";
        ProductModel product = new ProductModel();
        product.setTitle("Prod11");
        String inputJson = super.mapToJson(product);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "Product is updated successfully");
    }
}
