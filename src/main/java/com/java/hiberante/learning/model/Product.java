package com.java.hiberante.learning.model;

public class Product {

	private int productId;
	private String productName;
	private String description;
	private double productprice;

	public Product() {

	}

	public Product(int productId, String productName, String description, double productprice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.description = description;
		this.productprice = productprice;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getProductprice() {
		return productprice;
	}

	public void setProductprice(double productprice) {
		this.productprice = productprice;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", description=" + description
				+ ", productprice=" + productprice + "]";
	}
	

}
