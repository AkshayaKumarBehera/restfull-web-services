
package com.akki.rest.webservices.restfullwebservices.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ProductModel {

	@NotNull(message="Product Id should not be null and should have at least 3 digit")
	private Integer product_id;

	@NotNull(message = "Title should not empty")
	@Size(min=2, message="Name should have at least 2 characters")
	private String title;

	@NotEmpty(message = "Seller id should not be empty")
	private String seller_Id;

	@NotBlank(message = "Manufacture name should not be a blank")
	private  String manufacturer;

	private PriceModel priceModel;


	public ProductModel(Integer product_id, String title, String seller_Id, String manufacturer, PriceModel priceModel) {
		super();
		this.product_id = product_id;
		this.title = title;
		this.seller_Id = seller_Id;
		this.manufacturer = manufacturer;
		this.priceModel = priceModel;
	}

	public ProductModel(String title, String seller_Id, String manufacturer, PriceModel priceModel) {
		super();
		this.title = title;
		this.seller_Id = seller_Id;
		this.manufacturer = manufacturer;
		this.priceModel = priceModel;
	}

	public ProductModel() {

	}

	public Integer getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSeller_Id() {
		return seller_Id;
	}

	public void setSeller_Id(String seller_Id) {
		this.seller_Id = seller_Id;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public PriceModel getPriceModel() {
		return priceModel;
	}

	public void setPriceModel(PriceModel priceModel) {
		this.priceModel = priceModel;
	}

	@Override
	public String toString() {
		return "Product{" +
				"product_id=" + product_id +
				", title='" + title + '\'' +
				", seller_Id='" + seller_Id + '\'' +
				", manufacturer='" + manufacturer + '\'' +
				", price=" + priceModel +
				'}';
	}


}
