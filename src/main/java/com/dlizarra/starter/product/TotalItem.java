package com.dlizarra.starter.product;

public class TotalItem {
	private int quantity;
	private String productName;
	
	public TotalItem(int quantity, String productName) {
		setQuantity(quantity);
		setProductName(productName);
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}

}
