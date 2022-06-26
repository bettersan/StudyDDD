package com.studyDDD.domain;

import com.studyDDD.Money;

public class OrderLine {
	private Product product;
	private Money price;
	private int quantity;
	private Money amounts;
	
	public OrderLine(Product product, Money price, int quantity) {
		this.product = product;
		this.price = price;
		this.quantity = quantity;
		this.amounts = calculateAmounts();
	}
	
	private Money calculateAmounts() {
		return price.multiply(quantity);
	}
	
	public Money getAmounts() {
		return amounts;
	}
}
