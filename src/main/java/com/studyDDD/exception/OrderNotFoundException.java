package com.studyDDD.exception;

public class OrderNotFoundException extends Exception {
	
	public OrderNotFoundException(String orderId) {
		super("The '" + orderId + "' Order Not Founded" );
	}

}
