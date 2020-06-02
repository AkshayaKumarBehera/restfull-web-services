package com.akki.rest.webservices.restfullwebservices.controller;

import com.akki.rest.webservices.restfullwebservices.model.PriceModel;
import com.akki.rest.webservices.restfullwebservices.services.PriceService;
import com.akki.rest.webservices.restfullwebservices.exception.ProductNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class PriceController {
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    PriceService priceService;

    @PostMapping("/products/prices")
    public ResponseEntity<Object> createProductPrice(@Valid @RequestBody PriceModel priceModel){
        logger.info("Entry of createProductPrice method inside Price Controller");
        PriceModel newPrice = priceService.createProductPrice(priceModel);
        return new ResponseEntity<>("Price is created successfully", HttpStatus.CREATED);
    }

    @GetMapping("/products/prices")
    public  ResponseEntity<Object> getAllPrices(){
        logger.info("Entry of GetAllPrices method inside Price Controller");
        return new ResponseEntity<>(priceService.getAllPrices(), HttpStatus.OK);
    }

    @PutMapping("/products/price/{id}")
    public ResponseEntity<Object> updatePrice(@PathVariable Integer id, @RequestBody PriceModel updatedPrice){
        logger.info("Inside update price method");
        priceService.updatePrice(id, updatedPrice);

        return new ResponseEntity<>("Price is updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("/products/price/{id}")
    public ResponseEntity<Object> deletePrice(@PathVariable Integer id){
        logger.info("Entry of deletePrice method inside Price Controller");
        PriceModel priceModel = priceService.deletePriceByProdId(id);
        if(priceModel == null)
            throw new ProductNotFoundException("Product Id:"+id);
        return new ResponseEntity<>("Price is deleted successfully", HttpStatus.OK);
    }

    @GetMapping("/products/price/{id}")
    public ResponseEntity<Object> getPriceByProductId(@PathVariable Integer id){
        logger.info("Entry of getPriceByProductId method inside Price Controller");
        PriceModel priceData = priceService.findPriceByProductId(id);
        if(priceData==null)
            throw new ProductNotFoundException("Product does not exit -- Product Id:"+ id);

        return new ResponseEntity<>(priceData, HttpStatus.OK);
    }
}
