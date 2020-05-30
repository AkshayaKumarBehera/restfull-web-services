package com.akki.rest.webservices.restfullwebservices.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class PriceModel {

    @NotNull(message="Product Id should not be null and should have at least 3 digit")
    private Integer product_id;

    @NotNull(message="Price range should not be null")
    private String range;

    @NotNull(message = "Minimum price should not be empty")
    private Double minPrice;

    @NotNull(message = "Maximum price should not be empty")
    private  Double maxPrice;

    public PriceModel(){

    };

    public PriceModel(@NotNull(message = "Product Id should not be null and should have at least 3 digit") Integer product_id, @NotNull(message = "Price range should not be null") String range, @NotNull(message = "Minimum price should not be empty") Double minPrice, @NotNull(message = "Maximum price should not be empty") Double maxPrice) {
        this.product_id = product_id;
        this.range = range;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public Double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Double minPrice) {
        this.minPrice = minPrice;
    }

    public Double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    @Override
    public String toString() {
        return "PriceModel{" +
                "product_id=" + product_id +
                ", range='" + range + '\'' +
                ", minPrice=" + minPrice +
                ", maxPrice=" + maxPrice +
                '}';
    }
}
