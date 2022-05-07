package com.studyDDD.domain.Order;

import java.util.List;

import com.studyDDD.domain.Order.OrderLine;
import com.studyDDD.domain.Order.ShippingInfo;
import com.studyDDD.dontKnow.Money;
import com.studyDDD.enums.OrderState;

// 주문
public class Order {
	private OrderNo id;
	private String orderNumber;
	private Orderer orderer;
	private OrderState state;
	private ShippingInfo shippingInfo;
	private List<OrderLine> orderLines; //주문항목? 주문..라인?
	private Money totalAmounts;
	
	public Order(Orderer orderer, List<OrderLine> orderLines, ShippingInfo shippingInfo, OrderState state) {
		// 생성자에서 도메인 규칙을 구현할 수 있다.
		setOrderer(orderer);
		setOrderLines(orderLines);
		setShippingInfo(shippingInfo);
		setOrderState(state);
	}
	
	public OrderNo getID() {
		return id;
	}
	
	public void setOrderer(Orderer orderer) {
		if(orderer == null) throw new IllegalArgumentException("no orderer");
		this.orderer = orderer;
	}
	
	private void setOrderLines(List<OrderLine> orderLines) {
		verifyAtLeastOneOrMoreOrderLines(orderLines);
		this.orderLines = orderLines;
		calculateTotalAmounts();
	}
	
	private void setOrderState(OrderState state) {
		if(state == null) throw new IllegalArgumentException("no order state");
		this.state = state;
	}
	
	
	private void verifyAtLeastOneOrMoreOrderLines(List<OrderLine> orderLines) {
		if(orderLines == null || orderLines.isEmpty()) {
			throw new IllegalArgumentException("no OrderLines");
		}
	}
	
	private void calculateTotalAmounts() { //여기 어떻게 바꿔야되냐 ㅠㅠ
		this.totalAmounts = orderLines.stream().mapToInt(x -> x.getAmounts()).sum();
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
	
	private void setShippingInfo(ShippingInfo shippingInfo) {
		if (shippingInfo == null) throw new IllegalArgumentException("no ShippingInfo");
		this.shippingInfo = shippingInfo;
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
	
	@Override
	public boolean equals(Object obj) {
		//엔티티를 구현한 클래스는 식별자를 이용해서 eqauls와 hashCode 메소드를 구현할 수 있다.
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
	
}


