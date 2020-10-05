package com.shopping.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentReportNG {
	static ExtentReports extent;
	static ExtentSparkReporter htmlReporter;
	public static ExtentReports extentReportGenerator() {
	
	String path=System.getProperty("user.dir")+"\\Reports\\index.html";
	
	ExtentSparkReporter htmlReporter=new ExtentSparkReporter(path);
	
	htmlReporter.config().setDocumentTitle("Automation Practise");
	htmlReporter.config().setReportName("Online Shopping");
	htmlReporter.config().setTheme(Theme.STANDARD);
	extent=new ExtentReports();
	extent.attachReporter(htmlReporter);
	extent.setSystemInfo("Hostname", "LocalHost");
	extent.setSystemInfo("OS", "Windows10");
	extent.setSystemInfo("TesterName", "Ravindra Chavan");
	extent.setSystemInfo("Browser","chrome_Browser");
	
	return extent;
	}
	
	
}
