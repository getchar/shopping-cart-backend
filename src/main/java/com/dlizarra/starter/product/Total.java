package com.dlizarra.starter.product;

import java.util.ArrayList;
import java.util.List;

public class Total {
	private int cost;
	private List<TotalItem> totalItems = new ArrayList<TotalItem>();
	
	public void addTotalItem(int quantity, String productName) {
		totalItems.add(new TotalItem(quantity, productName));
	}
	
	public int getCost() {
		return cost;
	}
	
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	public List<TotalItem> getTotalItems() {
		return totalItems;
	}
	
	public void setTotalItems(List<TotalItem> purchases) {
		this.totalItems = purchases;
	}
	
}
