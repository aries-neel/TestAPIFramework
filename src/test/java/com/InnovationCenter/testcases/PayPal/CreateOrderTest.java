package com.InnovationCenter.testcases.PayPal;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.InnovationCenter.PayPal.APIs.PayPal_Order_API;
import com.InnovationCenter.SetUp.BaseTest;

import io.restassured.response.Response;

public class CreateOrderTest  extends BaseTest{
	
	@Test
	public void createOrder() {
	
		String token=PayPal_Order_API.getAccessToken();
		System.out.println(token);
		Response res=PayPal_Order_API.createOrder( token);
		String actual_Status =res.jsonPath().get("status");
		String expected_Status="CREATED";

		Assert.assertEquals(actual_Status, expected_Status);
	}

}
