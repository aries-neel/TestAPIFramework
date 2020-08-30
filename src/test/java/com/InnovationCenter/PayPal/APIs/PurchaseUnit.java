package com.InnovationCenter.PayPal.APIs;

public class PurchaseUnit {
	
	
	private Amount amount;
	
	public PurchaseUnit(String currency_code,Double value) {
		this.amount= new Amount("USD", 300.00);
		
		
	}

	public Amount getAmount() {
		return amount;
	}

	public void setAmount(Amount amount) {
		this.amount = amount;
	}
	
	
	

}
