package com.akki.rest.webservices.restfullwebservices.controller;

import com.akki.rest.webservices.restfullwebservices.services.PriceServiceImpl;
import com.akki.rest.webservices.restfullwebservices.model.PriceDataModel;
import com.akki.rest.webservices.restfullwebservices.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class PriceController {
    @Autowired
    PriceServiceImpl priceServiceImpl;

    @GetMapping("/price/product/{id}")
    public PriceDataModel getPrice(@PathVariable int id){
        PriceDataModel priceData = priceServiceImpl.findPriceByProductId(id);

        if(priceData==null)
            throw new ProductNotFoundException("id-"+ id);

        return priceData;
    }

    @PostMapping("/price")
    public ResponseEntity<Object> createPrice(@Valid @RequestBody PriceDataModel priceDataModel){
        PriceDataModel savedPriceDataModel = priceServiceImpl.save(priceDataModel);
        /*URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPriceDataModel.getProduct_id()).toUri();
        return ResponseEntity.created(location).build();*/
        return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/price/product/{id}")
    public ResponseEntity<Object> deletePrice(@PathVariable int id){
        PriceDataModel priceDataModel = priceServiceImpl.deleteByProdId(id);
        if(priceDataModel == null)
            throw new ProductNotFoundException("Product Id:"+id);
        return new ResponseEntity<>("Price is deleted successfully", HttpStatus.OK);
    }
}
