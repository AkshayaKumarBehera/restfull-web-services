package com.akki.rest.webservices.restfullwebservices.prices;

public class PriceData {
    private int product_id;
    private Price price;

    public PriceData(int product_id, Price price) {
        this.product_id = product_id;
        this.price = price;
    }

    public PriceData() {

    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
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
                "product_id=" + product_id +
                ", price=" + price +
                '}';
    }
}
