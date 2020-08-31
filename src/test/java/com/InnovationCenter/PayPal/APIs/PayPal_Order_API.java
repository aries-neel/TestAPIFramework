package com.InnovationCenter.PayPal.APIs;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.InnovationCenter.PayPal.POJO.PayPal_Create_Order;
import com.InnovationCenter.PayPal.POJO.PurchaseUnit;
import com.InnovationCenter.SetUp.BaseTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PayPal_Order_API extends BaseTest {

	static String client_Id = prop.getProperty("client_Id");
	static String secret_key = prop.getProperty("secret_key");
	static String access_token;
	public static String order_ID;

	public static String getAccessToken() {

		Response response = given().param("grant_type", "client_credentials").auth().preemptive()
				.basic(client_Id, secret_key).contentType(ContentType.JSON).post("/v1/oauth2/token");

		response.prettyPrint();

		access_token = response.jsonPath().get("access_token").toString();

		return access_token;
	}

	public static Response createOrder(String access_token) {

		ArrayList<PurchaseUnit> list = new ArrayList<PurchaseUnit>();
		list.add(new PurchaseUnit("USD", 150.00));

		PayPal_Create_Order order = new PayPal_Create_Order("CAPTURE", list);

		Response res = given().auth().oauth2(access_token).contentType(ContentType.JSON).body(order)
				.post("/v2/checkout/orders");

		res.prettyPrint();
		System.out.println("%%%%%=============================%%%%");
		order_ID = res.jsonPath().get("id").toString();
		

		return res;
	}

	public static Response getOrderDetail(String access_token) {

		Response res = given().auth().oauth2(access_token).contentType(ContentType.JSON)
				.get("/v2/checkout/orders" + "/" + order_ID);

		Assert.assertEquals(res.getStatusCode(), 200);

		return res;
	}

}
