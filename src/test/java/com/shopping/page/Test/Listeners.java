package com.shopping.page.Test;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.shopping.base.ExtentReportNG;
import com.shopping.base.Logs;
import com.shopping.base.TestBase;

public class Listeners extends TestBase implements ITestListener {
	

	ExtentReports extent = ExtentReportNG.extentReportGenerator();
	 ExtentTest test;
		
	 ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();

	public void onFinish(ITestContext result) {
		// TODO Auto-generated method stub
		Logs.info("................On Finish  Testcases..... ...."+result.getName());
		extent.flush();
	}

	public void onStart(ITestContext result) {
		// TODO Auto-generated method stub
		Logs.info("................On start  Testcases..... ...."+result.getName());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	
	public void onTestFailure(ITestResult result) {
		
		// TODO Auto-generated method stub
		Logs.info("Failure  because of ...."+result.getThrowable());
		
		extentTest.get().fail(result.getThrowable());
		WebDriver driver=null;
		String testCaseName=result.getMethod().getMethodName();
	  Object testobject= result.getInstance();
	Class clazz=result.getTestClass().getRealClass();
	
		try {
			driver=(WebDriver)clazz.getDeclaredField("driver").get(testobject);
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
	
	
	
		try {
			extentTest.get().addScreenCaptureFromPath(getScreenShotPath(testCaseName, driver), result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		/*extentTest.get().fail(result.getThrowable());
		WebDriver driver =null;
		String testMethodName =result.getMethod().getMethodName();
		
		try {
			driver =(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch(Exception e)
		{
			
		}
		try {
			extentTest.get().addScreenCaptureFromPath(getScreenShotPath(testMethodName,driver), result.getMethod().getMethodName());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
		
		
	

	
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		Logs.info("Skipped because of ...."+result.getThrowable());
	}

	
	public void onTestStart(ITestResult result) {
	
		 test=extent.createTest(result.getMethod().getMethodName());
		   Logs.info(result.getMethod().getDescription());
	
		 extentTest.set(test);
		
	}
	
	 


	public  void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
	 extentTest.get().log(Status.PASS, "Test Passed");
	
		Logs.info(result.getMethod().getMethodName()+ " Passed ");
	
		
	
		
	}
	
	
}