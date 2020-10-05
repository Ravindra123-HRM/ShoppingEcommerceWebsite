package com.shopping.page.Test;

import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

import com.shopping.base.TestBase;
import com.shopping.page.java.LoginPage;

public class Sign_InTest extends TestBase{
	
	public LoginPage lp;
	
	@BeforeClass
	public void SetInitialization() throws Exception
	{
		   driver=initialization();
	       lp=new LoginPage(driver);
	}
	
	@Test(groups= "Smoke")
	public  void clickonSigninPage()
	{
	PropertyConfigurator.configure("log4j.properties");
	lp.clickonSign_In();
    lp.clickonEmail(pro.getProperty("Username"),pro.getProperty("password"));
    } 
	
	@AfterClass
	public void Teardown()
	{
		driver.close();
		
	}
	
	

}
