package com.InnovationCenter.SetUp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.InnovationCenter.Utility.ExcelReader;

import io.restassured.RestAssured;

public class BaseTest {
	
	
	/*
	 * this class is base for every testcases that all initialization for
	 * Extent / log4j/ properties/ ExcelReader/ etc
	 * 
	 * 	BasePath/ BaseURI
	 *  test Fixtures methods 
	 *  Setup()
	 *  tearDown()
	 */
	public static Properties prop = new Properties();
	private FileInputStream fis;
	public static ExcelReader excel= new ExcelReader(".\\src\\test\\resources\\excel\\testData.xlsx");
	
	@BeforeSuite
	public void setUp() {
		
		
		
		 try {
			fis = new FileInputStream("D:\\RestAssuredAPI\\RestAssuredAPIFramework\\src\\test\\resources\\config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RestAssured.baseURI=prop.getProperty("baseUri");
		RestAssured.basePath=prop.getProperty("basePath");
		
		
		
	}
	@AfterSuite
	public void tearDown() {
		
	}
	
}
