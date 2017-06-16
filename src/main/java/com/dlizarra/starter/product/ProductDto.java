package com.dlizarra.starter.product;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode(of = { "id" })
@ToString(of = { "name" })
@Setter
@Getter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class ProductDto {
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
	
	public String getImgsrc() {
		return imgsrc;
	}
	
	public void setImgsrc(String imgsrc) {
		this.imgsrc = imgsrc;
	}
	
}
