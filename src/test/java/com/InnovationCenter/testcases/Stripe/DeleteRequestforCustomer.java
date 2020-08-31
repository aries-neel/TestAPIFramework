package com.InnovationCenter.testcases.Stripe;

import java.util.Hashtable;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.InnovationCenter.SetUp.BaseTest;
import com.InnovationCenter.Stripe.APIs.DeleteCustomerAPI;
import com.InnovationCenter.Utility.CommonDataProvider;

import io.restassured.response.Response;

public class DeleteRequestforCustomer extends BaseTest{
	
	@Test(dataProviderClass=CommonDataProvider.class, dataProvider="data")
	public void validateDeleteCustomerRequest(Hashtable<String, String> data) {
		
					
		/*RestAssured.baseURI="https://api.stripe.com";
		RestAssured.basePath="/v1";*/
		
		Response response=DeleteCustomerAPI.sendingDELETERequestWithValidID(data);
		
		// here we validate json response 
		
		JSONObject json= new JSONObject(response.asString());
		String actual_id=json.get("id").toString();
		
		Assert.assertEquals(actual_id, data.get("id"));
		
		System.out.println(response.prettyPrint());
		Assert.assertEquals(response.statusCode(), 200);
		
	}

}
