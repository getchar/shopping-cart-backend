package com.dlizarra.starter.product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode(of = { "id" })
@ToString(of = { "id", "name" })
@Setter
@Getter
@Entity
@Table(name = "products")
public class Product {
	@Id @GeneratedValue
	private Integer id;
	private String name;
	private String snippet;
	private int price;
	private int dealCount;
	private int dealPrice;
	private String imgsrc;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSnippet() {
		return snippet;
	}

	public void setSnippet(String snippet) {
		this.snippet = snippet;
	}

	public String getImgsrc() {
		return imgsrc;
	}

	public void setImgsrc(String imgsrc) {
		this.imgsrc = imgsrc;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getDealCount() {
		return dealCount;
	}

	public void setDealCount(int dealCount) {
		this.dealCount = dealCount;
	}

	public int getDealPrice() {
		return dealPrice;
	}

	public void setDealPrice(int dealPrice) {
		this.dealPrice = dealPrice;
	}
}
