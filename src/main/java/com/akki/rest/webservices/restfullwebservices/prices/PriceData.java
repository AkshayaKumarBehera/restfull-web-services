package com.akki.rest.webservices.restfullwebservices.prices;

public class PriceData {
    private String product_id;
    private Price price;

    public PriceData(String product_id, Price price) {
        this.product_id = product_id;
        this.price = price;
    }

    public PriceData() {

    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "PriceData{" +
                "product_id='" + product_id + '\'' +
                ", price=" + price +
                '}';
    }
}
