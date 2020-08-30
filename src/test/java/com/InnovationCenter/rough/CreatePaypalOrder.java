package com.InnovationCenter.rough;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class CreatePaypalOrder {
	
	static String client_Id="AQMM_ge08WDFl42ObIAoFaCacmT918yBLs2BQwER_ec7FHjooO3hvEcmUCDMQdUGgc6lfb8lJjVtJAg_";
	static String secret_key="ENR07MbeJj7ipWgBPr8_vem4vuqVQ0Sm2buWQzPhH3BUB4J0TWuNWggzO71gnhpBj-RhfAqqcVnpKucT";
	static String access_token;
	
	@Test(priority=1)
	public void getAccessToken() {
		
		RestAssured.baseURI="https://api.sandbox.paypal.com";
		
		
		Response response=given()
		.param("grant_type", "client_credentials")
		.auth().preemptive().basic(client_Id, secret_key)
		.contentType(ContentType.JSON)
		.post("/v1/oauth2/token");
		
		response.prettyPrint();
		
		access_token =response.jsonPath().get("access_token").toString();
		
	}
	
	@Test(priority=2 , dependsOnMethods="getAccessToken")
	public void createOrder() {
		
		RestAssured.baseURI="https://api.sandbox.paypal.com";
		
		String body="{\r\n" + 
				"  \"intent\": \"CAPTURE\",\r\n" + 
				"  \"purchase_units\": [\r\n" + 
				"    {\r\n" + 
				"      \"amount\": {\r\n" + 
				"        \"currency_code\": \"USD\",\r\n" + 
				"        \"value\": \"100.00\"\r\n" + 
				"      }\r\n" + 
				"    }\r\n" + 
				"  ]\r\n" + 
				"}";
		
		
	    Response res=given()
	   .auth().oauth2(access_token)
	   .contentType(ContentType.JSON)
	   .body(body)
	   .post("/v2/checkout/orders");
		
	    res.prettyPrint();
	    System.out.println("%%%%%=============================%%%%");
		String actual_Status =res.jsonPath().get("status");
		String expected_Status="CREATED";
		
		Assert.assertEquals(actual_Status, expected_Status);
		
		
		
		
	}

}
