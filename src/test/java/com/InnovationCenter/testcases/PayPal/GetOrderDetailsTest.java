package com.InnovationCenter.testcases.PayPal;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.InnovationCenter.PayPal.APIs.PayPal_Order_API;
import com.InnovationCenter.SetUp.BaseTest;

import io.restassured.response.Response;

public class GetOrderDetailsTest  extends BaseTest{
	
	
	@Test
	public void getOrderDetail() {
		
		String token=PayPal_Order_API.getAccessToken();
		Response res=PayPal_Order_API.createOrder(token);
		System.out.println(PayPal_Order_API.order_ID);
		Assert.assertEquals(res.getStatusCode(), 201);
	}

}
