package com.akki.rest.webservices.restfullwebservices.controller;

import com.akki.rest.webservices.restfullwebservices.model.PriceModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

class PriceControllerTest extends AbstractTest{

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
    }

    @Test
    public void createProductPriceTest() throws Exception{
        String uri = "/products/prices";

        PriceModel priceModel = new PriceModel();
        priceModel.setProduct_id(100);
        priceModel.setMinPrice(new Double(2));
        priceModel.setMaxPrice(new Double(3));
        priceModel.setRange("2-3");

        String inputJson = super.mapToJson(priceModel);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        Assertions.assertEquals(201, status);
        String content = mvcResult.getResponse().getContentAsString();
        Assertions.assertEquals(content, "Price is created successfully");
    }

    @Test
    public void getAllPricesTest() throws Exception{
        String uri = "/products/prices";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        Assertions.assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        PriceModel[] priceModels = super.mapFromJson(content, PriceModel[].class);
        Assertions.assertTrue(priceModels.length > 0);
    }

    @Test
    public void updatePriceTest() throws Exception{
        String uri = "/products/price/100";
        PriceModel price = new PriceModel();
        price.setProduct_id(100);
        String inputJson = super.mapToJson(price);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        Assertions.assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Assertions.assertEquals(content, "Price is updated successfully");
    }

    @Test
    public void deletePriceTest() throws Exception{
        String uri = "/products/price/100";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        Assertions.assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Assertions.assertEquals(content, "Price is deleted successfully");
    }

    @Test
    public void getPriceByProductIdTest() throws Exception{
        /*String uri = "/products/price/100";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        Assertions.assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        PriceModel price = super.mapFromJson(content, PriceModel.class);
        Assertions.assertEquals(100, price.getProduct_id());*/
    }
}