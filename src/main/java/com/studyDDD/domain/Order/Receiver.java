package com.studyDDD.domain.Order;

public class Receiver {
	private String name;
	private String phoneNumber;
	
	public Receiver (String name, String phoneNnumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	
	public String getName () {
		return name;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
}
