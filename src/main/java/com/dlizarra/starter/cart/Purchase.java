package com.dlizarra.starter.cart;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Purchase {
	@Id @GeneratedValue
	private Integer id;
	private int quantity;
	private Integer productId;
	
	public Purchase(Integer productId) {
		setQuantity(0);
		setProductId(productId);
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

}
