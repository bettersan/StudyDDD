package com.studyDDD.stub;

import java.util.List;

import com.studyDDD.Money;
import com.studyDDD.domain.Customer;
import com.studyDDD.domain.OrderLine;

public interface RuleDiscounter {
	Money applyRules(Customer customer, List<OrderLine> orderLines);
}
