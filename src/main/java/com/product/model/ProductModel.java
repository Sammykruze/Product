package com.product.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProductModel {
	
	@Id  											
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long id;
	public String productName;
	public int productPrice;
	public String productCategory;
	public int productYear;
	public String countryProduced;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public int getProductYear() {
		return productYear;
	}
	public void setProductYear(int productYear) {
		this.productYear = productYear;
	}
	public String getCountryProduced() {
		return countryProduced;
	}
	public void setCountryProduced(String countryProduced) {
		this.countryProduced = countryProduced;
	}
	
	
	
	

}
