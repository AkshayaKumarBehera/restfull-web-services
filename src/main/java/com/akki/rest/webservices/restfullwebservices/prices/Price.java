package com.akki.rest.webservices.restfullwebservices.prices;

public class Price {
    private String range;
    private Double minPrice;
    private  Double maxPrice;

    protected Price(){

    };
    public Price(String range, Double minPrice, Double maxPrice) {
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

    @Override
    public String toString() {
        return "Price{" +
                "range='" + range + '\'' +
                ", minPrice=" + minPrice +
                ", maxPrice=" + maxPrice +
                '}';
    }
}
