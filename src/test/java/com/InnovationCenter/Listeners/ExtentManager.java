package com.InnovationCenter.Listeners;



import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	
	private static ExtentReports extent;
	
	
	

    public static ExtentReports createInstance(String fileName) {
    	
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
       
        
       // html reporter configuration
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle(fileName);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName(fileName);
        
        // system Info setUP and merge with the html reporter
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Automation Tester", "Neelmani Singh");
        extent.setSystemInfo("Organization", "InnovationCenter");
        extent.setSystemInfo("Build no", "IC-v1.2");
        
        
        return extent;
    }

    
    public static String screenshotPath;
	public static String screenshotName;
	
	

	
	}




