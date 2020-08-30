package com.InnovationCenter.PayPal.APIs;

public class Amount {
	
	
	private String currency_code;
	private Double value;
	
	
	public Amount(String currency_code , Double value) {
		
		this.currency_code=currency_code;
		this.value=value;
		
		
	}


	public String getCurrency_code() {
		return currency_code;
	}


	public void setCurrency_code(String currency_code) {
		this.currency_code = currency_code;
	}


	public Double getValue() {
		return value;
	}


	public void setValue(Double value) {
		this.value = value;
	}


	

}
