package com.studyDDD.domain.Order;

// 배송정보
public class ShippingInfo {
	private Receiver receiver;
	private Address address;
	
	public void getReceiver (Receiver receiver) {
		this.receiver = receiver;
	}
	
	public void getAddress(Address address) {
		this.address = address;
	}
	
	
}
