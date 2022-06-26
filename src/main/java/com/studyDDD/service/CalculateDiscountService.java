package com.studyDDD.service;

import java.util.Arrays;
import java.util.List;

import com.studyDDD.ExNoCustomerException;
import com.studyDDD.Money;
import com.studyDDD.MutableMoney;
import com.studyDDD.domain.Customer;
import com.studyDDD.domain.OrderLine;
import com.studyDDD.infra.DroolsRuleDiscounter;
import com.studyDDD.infra.DroolsRuleEngine;
import com.studyDDD.infra.repo.CustomerRepository;
import com.studyDDD.stub.RuleDiscounter;

public class CalculateDiscountService {
	private CustomerRepository customerRepository;
	private RuleDiscounter ruleDiscounter;
	
	public CalculateDiscountService(CustomerRepository customerRepository, RuleDiscounter ruleDiscounter) {
		this.customerRepository = customerRepository;
		this.ruleDiscounter = ruleDiscounter;
	}
	
	public Money calculateDiscount(List<OrderLine> orderLines, String customerId) {
		Customer customer = findCustomer(customerId);
		
		return ruleDiscounter.applyRules(customer, orderLines);
	}
	
	private Customer findCustomer(String custoerId) {
		Customer customer = customerRepository.findById(custoerId);
		if(customer == null) throw new ExNoCustomerException();
		return new Customer();
	}
}
