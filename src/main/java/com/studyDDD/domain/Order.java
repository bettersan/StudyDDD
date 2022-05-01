package com.studyDDD.domain;

import java.util.List;

import com.studyDDD.enums.OrderState;

public class Order {
	private OrderState state;
	private ShippingInfo shippingInfo;
	private List<OrderLine> orderLines;
	private Money totalAmounts;
	
	public Order(List<OrderLine> orderLines) {
		setOrderLines(orderLines);
	}
	
	private void setOrderLines(List<OrderLine> orderLines) {
		verifyAtLeastOneOrMoreOrderLines(orderLines);
		this.orderLines = orderLines;
	}
	
	private void verifyAtLeastOneOrMoreOrderLines(List<OrderLine> orderLines) {
		if(orderLines == null || orderLines.isEmpty()) {
			throw new IllegalArgumentException("no OrderLines");
		}
	}
	
	private void calculateTotalAmounts() {
		int sum = orderLines.stream()
							.mapToInt( x -> x.getAmounts())
							.sum();
		this.totalAmounts = new Money(sum);
		
	}
	
	
	private boolean isShippingChangeable() {
		return state == OrderState.PAYMENT_WAITING || state == OrderState.PREPARING;
	}
	
	public void changeShipped() {
		
	}
	
	public void changeShippingInnfo(ShippingInfo newShippingInfo) {
		if(!state.isShippingChangeable()) {
			throw new IllegalStateException("cant' change shipping in " + state);
		}
		
		this.shippingInfo = newShippingInfo;
	}
	
	public void cancel() {
		
	}
	
	public void completePayment() {
		
	}
	
	
	
}


