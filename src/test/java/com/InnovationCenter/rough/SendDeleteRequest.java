package com.InnovationCenter.rough;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;

public class SendDeleteRequest {

	public static void main(String[] args) {
		
		Response response = given().auth().basic("sk_test_lsiwjIexmN0I0WJ1ddS2aDvp00Kd0MB6EY", "")
				.delete("https://api.stripe.com/v1/customers/cus_Hr6wQthknRM8ox");
		
		response.prettyPrint();
	}

}
