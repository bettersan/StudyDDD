package com.studyDDD.infra;

import java.util.List;

public class DroolsRuleEngine {
	private KieContainer kContainer;
	
	public DroolsRuleEngine() {
		KieServices ks = KieServices.Factory.get();
		kContainer = ks.getKieClasspathContainer();
	}
	
	public void evalute(String sessionName, List<?> facts) {
		KieSession kSeesion = kContainer.newKieSession(sessionName);
		try {
			facts.forEach(x -> kSession.insert(x)));
			kSession.fireAllRules();
		} finally {
			kSession.dispose();
		}
	}

}
