package com.studyDDD.service;

import java.util.Arrays;
import java.util.List;

import com.studyDDD.Money;
import com.studyDDD.MutableMoney;
import com.studyDDD.domain.Customer;
import com.studyDDD.domain.OrderLine;
import com.studyDDD.infra.DroolsRuleEngine;

public class CalculateDiscountService {
	private DroolsRuleEngine ruleEngine;
	
	public CalculateDiscountService() {
		ruleEngine = new DroolsRuleEngine();
	}
	
	public Money calculateDiscount(List<OrderLine> orderLines, String customerId) {
		Customer customer = findCustomer(customerId);
		
		MutableMoney money = new MutableMoney(0);
		List<?> facts = Arrays.asList(customer, money);
		facts.addAll(orderLines);
		ruleEngine.evalute("discountCalculation", facts);
		return money.toImmutableMoney();
	}
	
	private Customer findCustomer(String custoerId) {
		
		return new Customer();
	}
}
