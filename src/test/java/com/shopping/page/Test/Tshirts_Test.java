package com.shopping.page.Test;

import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.shopping.base.TestBase;
import com.shopping.page.java.LoginPage;
import com.shopping.page.java.Tshirts;

public class Tshirts_Test extends TestBase {
	public LoginPage lp;
	public Tshirts pd;
	public WebDriver driver;
	
	@BeforeClass
	public void SetInitiatization() throws Exception
	{
		driver=initialization();
		lp=new LoginPage(driver);
		pd=new Tshirts(driver);
	}
	
	@Test(groups="Regression")
	public void Online_clickon_Purchase() throws InterruptedException
	{
		
		PropertyConfigurator.configure("log4j.properties");
		
		lp.clickonSign_In();
		lp.clickonEmail(pro.getProperty("Username"), pro.getProperty("password"));
		pd.clickon_WomenTab(); 
	}
	
	@Test(groups= {"Regression"},dependsOnMethods= {"Online_clickon_Purchase"})
	public void Online_clickon_Size() throws InterruptedException
	{
		pd.clickon_Size();
	}
	
	@Test(groups= {"Regression"},dependsOnMethods= {"Online_clickon_Size"})
	public void Online_clickOn_Sortby() throws InterruptedException
	{
		pd.clickOn_Sortby();
	}
	@Test(groups= {"Regression"},dependsOnMethods= {"Online_clickOn_Sortby"})
	public void Online_clickOn_AddtoCart() throws InterruptedException
	{
		pd.clickOn_AddtoCart();
	}
	
	@Test(groups= {"Regression"},dependsOnMethods= {"Online_clickOn_AddtoCart"})
	public void Online_clickOn_proceedTocheckout() throws InterruptedException
	{
		pd.clickOn_proceedTocheckout();
		
	}
	
	@Test(groups= {"Regression"},dependsOnMethods= {"Online_clickOn_proceedTocheckout"})
	public void Online_clickOn_Quantity() throws InterruptedException
	{
		pd.clickOn_Quantity(); 
	}
	
	@Test(groups= {"Regression"},dependsOnMethods= {"Online_clickOn_Quantity"})
	public void Online_clickOn_editAddress() throws InterruptedException, IOException
	{
		pd.clickOn_editAddress();
		
	}
	
	@Test(groups= {"Regression"},dependsOnMethods= {"Online_clickOn_editAddress"})
	public void Online_ClickOn_TermsandProceedToCheck() throws InterruptedException
	{
		pd.ClickOn_TermsandProceedToCheck();
	}
		
	@AfterTest
	public void Teardown()
	{
		
		driver.quit();
	}
		
		
	}
	


