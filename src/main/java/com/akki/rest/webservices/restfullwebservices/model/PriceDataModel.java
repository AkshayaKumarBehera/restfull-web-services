package com.akki.rest.webservices.restfullwebservices.model;

public class PriceDataModel {
    private int product_id;
    private PriceModel priceModel;

    public PriceDataModel(int product_id, PriceModel priceModel) {
        this.product_id = product_id;
        this.priceModel = priceModel;
    }

    public PriceDataModel() {

    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public PriceModel getPriceModel() {

        return priceModel;
    }

    public void setPriceModel(PriceModel priceModel) {
        this.priceModel = priceModel;
    }

    @Override
    public String toString() {
        return "PriceData{" +
                "product_id=" + product_id +
                ", price=" + priceModel +
                '}';
    }
}
