package com.InnovationCenter.testcases;


import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.InnovationCenter.APIs.CreateCustomerAPI;
import com.InnovationCenter.SetUp.BaseTest;
import com.InnovationCenter.Utility.CommonDataProvider;

import io.restassured.response.Response;


public class ValidateAPIKeyOfStripe extends BaseTest {
	
	
	
	
	@Test(dataProviderClass=CommonDataProvider.class, dataProvider="data")
	public void validateCreateCustomerwithValidAuthKey(Hashtable<String, String> data) {
		
					
		/*RestAssured.baseURI="https://api.stripe.com";
		RestAssured.basePath="/v1";*/
		
		Response response=CreateCustomerAPI.sendingPOSTRequestWithValidAuthKey(data);
		
		System.out.println(response.prettyPrint());
		Assert.assertEquals(response.statusCode(), 200);
		
	}
	/*@Test(dataProviderClass=CommonDataProvider.class, dataProvider="data")
	public void validateCreateCustomerwithInValidAuthKey(Hashtable<String, String> data) 
	
	{
		
					// redundant code
		RestAssured.baseURI="https://api.stripe.com";
		RestAssured.basePath="/v1";
		
		Response response=CreateCustomerAPI.sendingPOSTRequestWithInValidAuthKey(data);
		System.out.println(response.prettyPrint());
		
		Assert.assertEquals(response.statusCode(), 200);
		
	}*/
	
	
	
	
}
