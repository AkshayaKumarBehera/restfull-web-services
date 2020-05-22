
package com.akki.rest.webservices.restfullwebservices.products;

import com.akki.rest.webservices.restfullwebservices.prices.Price;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class Product {

	private Integer product_id;

	@Size(min=2, message="Name should have atleast 2 characters")
	private String title;

	private String seller_Id;

	private  String manufacturer;


	public Product(Integer product_id, @Size(min = 2, message = "Name should have atleast 2 characters") String title, String seller_Id, String manufacturer) {
		super();
		this.product_id = product_id;
		this.title = title;
		this.seller_Id = seller_Id;
		this.manufacturer = manufacturer;
	}

	protected Product() {

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

	@Override
	public String toString() {
		return "Product{" +
				"product_id='" + product_id + '\'' +
				", title='" + title + '\'' +
				", seller_Id='" + seller_Id + '\'' +
				", manufacturer='" + manufacturer + '\'' +
				'}';
	}
	/*@Override
	public String toString() {
		return String.format("User [id=%s, name=%s, birthDate=%s]", id, name, birthDate);
	}*/

}
