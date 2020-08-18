package com.InnovationCenter.Utility;

import java.lang.reflect.Method;
import java.util.Hashtable;

import org.testng.annotations.DataProvider;

import com.InnovationCenter.SetUp.BaseTest;




public class CommonDataProvider extends BaseTest {
	
	@DataProvider(name="data")
	public static Object[][] getData(Method m) {
		
		

		int rows = excel.getRowCount(Constants.test_sheet);
		
		System.out.println("total no.of rows in the sheet is  :" + rows);

		// to find the particular testCase

		String testName = m.getName();
		System.out.println("TestCase name is  :"+testName);

		int testCaseStartRowNum = 1; // Assume to start testCase at row 1 like counter

		for (testCaseStartRowNum = 1; testCaseStartRowNum <= rows; testCaseStartRowNum++) {

			if (excel.getCellData(Constants.test_sheet, 0, testCaseStartRowNum).equalsIgnoreCase(testName)) {
				break;

			}

		}
		System.out.println("TestCase starts at row no  :" + testCaseStartRowNum);

		// find the total no. of data sets in the testcase

		int dataStartRowNum = testCaseStartRowNum + 2;
		int testRows = 0;
		while (!excel.getCellData(Constants.test_sheet, 0, testRows + dataStartRowNum).equals("")) {

			testRows++;
		}

		System.out.println("Total no. of test Data set in the testCase is  :" + testRows);

		// find the total no.of columns in the testcase

		int colStartColNum = testCaseStartRowNum + 1;
		int testCols = 0;

		while (!excel.getCellData(Constants.test_sheet, testCols, colStartColNum).equals("")) {

			testCols++;

		}

		System.out.println("Total no. of columns in the testCase is :" + testCols);

		// Now read the data from the excel
		Object[][] data = new Object[testRows][1];

		int i = 0;
		for (int rNum = dataStartRowNum; rNum < (dataStartRowNum + testRows); rNum++) {

			Hashtable<String, String> table = new Hashtable<String, String>();

			for (int cNum = 0; cNum < testCols; cNum++) {

				/* System.out.println(excel.getCellData(Constants.sheet_name, cNum, rNum)); */

				String testdata = excel.getCellData(Constants.test_sheet, cNum, rNum);
				String testCol = excel.getCellData(Constants.test_sheet, cNum, colStartColNum);
				table.put(testCol, testdata);
			}

			data[i][0] = table;
			i++;
		}
		return data;

	}	

}
