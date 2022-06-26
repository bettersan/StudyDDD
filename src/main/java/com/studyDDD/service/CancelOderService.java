package com.studyDDD.service;

import com.studyDDD.domain.Order;
import com.studyDDD.exception.OrderNotFoundException;

public class CancelOderService {
	
	public void cancelOrder(String orderId){
		try {
			Order order = findOrderById(orderId);
			if (order == null) throw new OrderNotFoundException(orderId);
			order.cancel();
		}catch (OrderNotFoundException e) {
			System.err.println(e.getMessage());
		}
		
	}
	
	
	private Order findOrderById(String orderId) {
		Order order = new Order(null, null, null, null);
		return order;
	}
}
