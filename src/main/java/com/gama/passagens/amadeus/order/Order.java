package com.gama.passagens.amadeus.order;

import java.math.BigDecimal;

public class Order {
	private BigDecimal price;
	private String id;
	private String json;
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getJson() {
		return json;
	}
	public void setJson(String json) {
		this.json = json;
	}
	
}
