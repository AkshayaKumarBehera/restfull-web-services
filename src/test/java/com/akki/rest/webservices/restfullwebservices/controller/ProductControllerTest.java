package com.akki.rest.webservices.restfullwebservices.controller;

import com.akki.rest.webservices.restfullwebservices.model.PriceModel;
import com.akki.rest.webservices.restfullwebservices.model.ProductModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


public class ProductControllerTest extends AbstractTest {

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
    }

    @Test
    public void getProductsListTest() throws Exception {
        String uri = "/products";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        Assertions.assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        ProductModel[] products = super.mapFromJson(content, ProductModel[].class);
        Assertions.assertTrue(products.length > 0);
    }

    @Test
    public void createProductTest() throws Exception{
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
        Assertions.assertEquals(201, status);
        String content = mvcResult.getResponse().getContentAsString();
        Assertions.assertEquals(content, "Product is created successfully");
    }

    @Test
    public void deleteProductTest() throws Exception {
        String uri = "/products/100";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        Assertions.assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Assertions.assertEquals(content, "Product is deleted successfully");
    }

    @Test
    public void updateProductTest() throws Exception {
        String uri = "/products/100";
        ProductModel product = new ProductModel();
        product.setProduct_id(100);
        String inputJson = super.mapToJson(product);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        Assertions.assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Assertions.assertEquals(content, "Product is updated successfully");
    }

    @Test
    public void getProductByProductId() throws Exception{
        /*String uri = "/products/100";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        Assertions.assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        ProductModel product = super.mapFromJson(content, ProductModel.class);
        Assertions.assertEquals(100, product.getProduct_id());*/
    }
}
