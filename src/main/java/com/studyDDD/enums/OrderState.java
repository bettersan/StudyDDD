package com.studyDDD.enums;

public enum OrderState {
	PAYMENT_WAITING{ //주문 대기중
		public boolean isShippingChangeable() {
			return true;
		}
	},
	
	PREPARING{ // 상품 준비중
		public boolean isShippingChangeable() {
			return true;
		}
	},
	
	SHIPPED, //배송됨
	DELIVERING, //배달중
	DELIVERY_COMPLETED, //배달완료
	CANCELED;
	
	public boolean isShippingChangeable() {
		return false;
	}
}
