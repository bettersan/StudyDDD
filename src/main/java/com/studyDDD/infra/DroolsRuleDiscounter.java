package com.studyDDD.infra;

import java.util.List;

import com.studyDDD.Money;
import com.studyDDD.MutableMoney;
import com.studyDDD.domain.Customer;
import com.studyDDD.domain.OrderLine;
import com.studyDDD.stub.RuleDiscounter;

public class DroolsRuleDiscounter implements RuleDiscounter {
	private KieContainer kContainer;
	
	public DroolsRuleDiscounter() {
		KieServices ks = KieServices.Factory.get();
		kContainer = ks.getKieClasspathContainer();
	}

	@Override
	public Money applyRules(Customer customer, List<OrderLine> orderLines) {
		KieSession kSession = kContainer.newKieSession("discountSession");
		Money money = new MutableMoney(0);
		try {
			facts.forEach(x -> kSession.insert(x)));
			kSession.fireAllRules();
		} finally {
			kSession.dispose();
		}
		
		return money.toImmutableMoney();
	}
	
}
