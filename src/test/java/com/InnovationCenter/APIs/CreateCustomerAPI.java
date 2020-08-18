package com.InnovationCenter.APIs;

import static io.restassured.RestAssured.given;

import java.util.Hashtable;

import com.InnovationCenter.SetUp.BaseTest;

import io.restassured.response.Response;

public class CreateCustomerAPI extends BaseTest {

	public static Response sendingPOSTRequestWithValidAuthKey(Hashtable<String, String> data) {

		Response response = given().auth().basic(prop.getProperty("validSecretKey"), "")
				.formParam("description", data.get("description")).formParam("email", data.get("email"))
				.formParam("name", data.get("name")).log().all().post(prop.getProperty("customerEndPoint"));

		return response;

	}

	public static Response sendingPOSTRequestWithInValidAuthKey(Hashtable<String, String> data) {

		Response response = given().auth().basic(prop.getProperty("inValidSceretKey"), "")
				.formParam("description", data.get("description")).formParam("email", data.get("email"))
				.formParam("name", data.get("name")).log().all().post(prop.getProperty("customerEndPoint"));

		return response;

	}

}
