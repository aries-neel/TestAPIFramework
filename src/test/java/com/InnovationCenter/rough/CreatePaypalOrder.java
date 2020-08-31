package com.InnovationCenter.rough;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.InnovationCenter.PayPal.POJO.Amount;
import com.InnovationCenter.PayPal.POJO.PayPal_Create_Order;
import com.InnovationCenter.PayPal.POJO.PurchaseUnit;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class CreatePaypalOrder {
	
	static String client_Id="AQMM_ge08WDFl42ObIAoFaCacmT918yBLs2BQwER_ec7FHjooO3hvEcmUCDMQdUGgc6lfb8lJjVtJAg_";
	static String secret_key="ENR07MbeJj7ipWgBPr8_vem4vuqVQ0Sm2buWQzPhH3BUB4J0TWuNWggzO71gnhpBj-RhfAqqcVnpKucT";
	static String access_token;
	static String order_ID;
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
		
		ArrayList<PurchaseUnit> list= new ArrayList<PurchaseUnit> ();
		list.add(new PurchaseUnit("USD", 150.00));
		
		PayPal_Create_Order order= new PayPal_Create_Order("CAPTURE",list);
		
		
		/*
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
		*/
		
	    Response res=given()
	   .auth().oauth2(access_token)
	   .contentType(ContentType.JSON)
	   .body(order)
	   .post("/v2/checkout/orders");
		
	    res.prettyPrint();
	    System.out.println("%%%%%=============================%%%%");
		String actual_Status =res.jsonPath().get("status");
		String expected_Status="CREATED";
		order_ID=res.jsonPath().get("id").toString();
		Assert.assertEquals(actual_Status, expected_Status);
		
	}
	
	
	@Test(priority=3)
	public void getOrderDetail() {
		
		RestAssured.baseURI="https://api.sandbox.paypal.com";
		
		
		
		  Response res=given()
				   .auth().oauth2(access_token)
				   .contentType(ContentType.JSON)
				   .get("/v2/checkout/orders"+"/"+order_ID);
					
				    res.prettyPrint();
				    
				    Assert.assertEquals(res.getStatusCode(), 200);
		
	}

}
