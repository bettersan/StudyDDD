package com.studyDDD.domain;

import java.util.List;

import com.studyDDD.domain.OrderLine;
import com.studyDDD.domain.ShippingInfo;
import com.studyDDD.dontKnow.Money;
import com.studyDDD.enums.OrderState;

// 주문
public class Order {
	private String orderNumber;
	private OrderState state;
	private ShippingInfo shippingInfo;
	private List<OrderLine> orderLines; //주문항목? 주문..라인?
	private Money totalAmounts;
	
	public Order(List<OrderLine> orderLines) { // 생성자에서 도메인 규칙을 구현할 수 있다.
		setOrderLines(orderLines);
		setShippingInfo(shippingInfo);
	}
	
	//엔티티를 구현한 클래스는 식별자를 이용해서 eqauls와 hashCode 메소드를 구현할 수 있다.
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || obj.getClass() != Order.class || this.orderNumber == null) return false;
		Order other = (Order) obj;
		return this.orderNumber.equals(other.orderNumber);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (orderNumber == null ? 0 : orderNumber.hashCode());
		return result;
	}
	
	
	
	private void setOrderLines(List<OrderLine> orderLines) {
		verifyAtLeastOneOrMoreOrderLines(orderLines);
		this.orderLines = orderLines;
		calculateTotalAmounts();
	}
	
	private void setShippingInfo(ShippingInfo shippingInfo) {
		if (shippingInfo == null) throw new IllegalArgumentException("no ShippingInfo");
		this.shippingInfo = shippingInfo;
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
		verifyNotYetShipped();
		setShippingInfo(newShippingInfo);
	}
	
	public void cancel() {
		verifyNotYetShipped();
		this.state = OrderState.CANCELED;
	}
	
	private void verifyNotYetShipped() {
		if(state != OrderState.PAYMENT_WAITING && state != OrderState.PREPARING) {
			throw new IllegalStateException("already shipped");
		}
	}
	
	public void completePayment() {
		
	}
	
	
	
}


