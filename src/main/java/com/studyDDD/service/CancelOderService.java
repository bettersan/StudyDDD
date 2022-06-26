package com.studyDDD.service;

import com.studyDDD.ExOrderNotFoundException;
import com.studyDDD.domain.Order;

public class CancelOderService {
	
	public void cancelOrder(String orderId){
		try {
			Order order = findOrderById(orderId);
			if (order == null) throw new ExOrderNotFoundException(orderId);
			order.cancel();
		}catch (ExOrderNotFoundException e) {
			System.err.println(e.getMessage());
		}
		
	}
	
	
	private Order findOrderById(String orderId) {
		Order order = new Order(null, null, null, null);
		return order;
	}
}
