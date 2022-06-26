package com.studyDDD;

public class ExOrderNotFoundException extends Exception {
	
	public ExOrderNotFoundException(String orderId) {
		super("The '" + orderId + "' Order Not Founded" );
	}

}
