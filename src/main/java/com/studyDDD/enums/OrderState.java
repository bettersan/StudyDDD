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
	
	SHIPPED,
	DELIVERING, //배송중
	DELIVERY_COMPLETED; //배송완료
	
	public boolean isShippingChangeable() {
		return false;
	}
}
