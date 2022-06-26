package com.studyDDD;
// TODO Money 클래스의 패키지 위치는 어디가 좋을까...?
public class MutableMoney extends Money {
	public MutableMoney(int value) {
		super(value);
	}

	private int value;
	
	//변하지 않는 금액을 리턴시켜주나?
	public Money toImmutableMoney() {
		return new MutableMoney(this.value);
	}
	
}
