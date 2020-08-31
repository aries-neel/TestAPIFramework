package com.InnovationCenter.Stripe.APIs;

import static io.restassured.RestAssured.given;

import java.util.Hashtable;

import com.InnovationCenter.SetUp.BaseTest;

import io.restassured.response.Response;

public class DeleteCustomerAPI extends BaseTest{
	
	
	public static Response sendingDELETERequestWithValidID(Hashtable<String, String> data) {

		Response response = given().auth().basic(prop.getProperty("validSecretKey"), "")
				.delete(prop.getProperty("customerEndPoint")+"/"+data.get("id"));
			
		return response;

	}

}
