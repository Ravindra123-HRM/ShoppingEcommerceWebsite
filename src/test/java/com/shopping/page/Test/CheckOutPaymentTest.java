package com.shopping.page.Test;

import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.shopping.base.TestBase;
import com.shopping.page.java.LoginPage;
import com.shopping.page.java.SummerDress;
import com.shopping.page.java.Tshirts;
import com.shopping.page.java.CasualDress;
import com.shopping.page.java.EveningDress;

public class CheckOutPaymentTest extends TestBase{
	
	public LoginPage lp;
	public CasualDress cd;
	public EveningDress ED;
	public Tshirts ts;
	public SummerDress sd;
	
	@BeforeClass
	public void setup() throws Exception
	{
		driver=initialization();
		lp=new LoginPage(driver);
		cd=new CasualDress(driver);
		ED=new EveningDress(driver);
		ts=new Tshirts(driver);
		sd=new SummerDress(driver);
		
	}
	
	@Test(groups="Regression")
	public void ClickOn_MultipleDress() throws Exception
	{  
		PropertyConfigurator.configure("log4j.properties");
		lp.clickonSign_In();
		lp.clickonEmail(pro.getProperty("Username"), pro.getProperty("password"));
		// Casual Dress obect is created to call method from Casual class.
		cd.clickon_WomenTab();
		
	}
	@Test(groups= {"Regression"},dependsOnMethods= {"ClickOn_MultipleDress"})
	public void Online_clickon_Size() throws InterruptedException
	{
		cd.clickon_Size();
	}
	
	@Test(groups= {"Regression"},dependsOnMethods= {"Online_clickon_Size"})
	public void Online_clickOn_Sortby() throws InterruptedException
	{
		cd.clickOn_Sortby();
		
	}
	
	@Test(groups= {"Regression"},dependsOnMethods= {"Online_clickOn_Sortby"})
	public void Online_clickOn_AddtoCart() throws InterruptedException
	{
		cd.clickOn_AddtoCart();
		
	}
	@Test(groups= {"Regression"},dependsOnMethods= {"Online_clickOn_AddtoCart"})
	public void Online_clickOn_ContinueShopping() throws InterruptedException
	{
	cd.clickOn_ContinueShopping();
		
	}
		// Evening Dress obect is created to call method from Evening class.
	@Test(groups= {"Regression"},dependsOnMethods= {"Online_clickOn_ContinueShopping"})
	public void Online_clickOn_clickon_WomenTab() throws InterruptedException
	{
		ED.clickon_WomenTab();
	}
	@Test(groups= {"Regression"},dependsOnMethods= {"Online_clickOn_clickon_WomenTab"})
	public void Online_clickOn_clickon_checkbox() throws InterruptedException
	{
		ED.clickon_checkbox(); 
		
	}
	
	@Test(groups= {"Regression"},dependsOnMethods= {"Online_clickOn_clickon_checkbox"})
	public void Online_clickOn_clickOn_Sortby() throws InterruptedException
	{
        ts.clickOn_Sortby();
	}
	@Test(groups= {"Regression"},dependsOnMethods= {"Online_clickOn_clickOn_Sortby"})
	public void Online_clickOn_clickOn_AddtoCart() throws InterruptedException
	{
        ts.clickOn_AddtoCart();
	}
	
	@Test(groups= {"Regression"},dependsOnMethods= {"Online_clickOn_clickOn_AddtoCart"})
	public void Online_clickOn_clickOn_proceedTocheckout() throws InterruptedException
         {
      ED.clickOn_continueshopping();
	  }
		
     // Summer Dress obect is created to call method from Summer class.
	@Test(groups= {"Regression"},dependsOnMethods= {"Online_clickOn_clickOn_proceedTocheckout"})
	public void Online_clickOn_clickon_WomenTab1() throws InterruptedException
	{
        sd.clickon_WomenTab();
	}
	@Test(groups= {"Regression"},dependsOnMethods= {"Online_clickOn_clickon_WomenTab1"})
	public void Online_clickOn_clickon_checkbox1() throws InterruptedException
	{
        sd.clickon_checkbox(); 
	}
	
	@Test(groups= {"Regression"},dependsOnMethods= {"Online_clickOn_clickon_checkbox1"})
	public void Online_clickOn_clickOn_Sortby1() throws InterruptedException
	{
        sd.clickOn_Sortby();
	}
	
	@Test(groups= {"Regression"},dependsOnMethods= {"Online_clickOn_clickOn_Sortby1"})
	public void Online_clickOn_clickOn_AddtoCart1() throws InterruptedException
	{
        sd.clickOn_AddtoCart();
        
	}
	@Test(groups= {"Regression"},dependsOnMethods= {"Online_clickOn_clickOn_AddtoCart1"})
	public void Online_clickOn_clickOn_proceedTocheckout1() throws InterruptedException
	{
       sd.clickOn_proceedTocheckout();
	}
		// To checkout Payment for which are selected in cart
	@Test(groups= {"Regression"},dependsOnMethods= {"Online_clickOn_clickOn_proceedTocheckout1"})
	public void Online_clickOn_Hoveron_Cart() throws InterruptedException
	{
        ED.Hoveron_Cart();
	}
	@Test(groups= {"Regression"},dependsOnMethods= {"Online_clickOn_Hoveron_Cart"})
	public void Online_clickOn_Quantity() throws InterruptedException
	{
        ts.clickOn_Quantity();
	}
	
	@Test(groups= {"Regression"},dependsOnMethods= {"Online_clickOn_Quantity"})
	public void Online_clickOn_editAddress() throws InterruptedException, IOException
	{
        ts.clickOn_editAddress();
	}
	
	@Test(groups= {"Regression"},dependsOnMethods= {"Online_clickOn_editAddress"})
	public void Online_ClickOn_TermsandProceedToCheck() throws InterruptedException
	{
        ts.ClickOn_TermsandProceedToCheck();
	}
        
        @AfterTest
        public void TearDown()
        {
        	driver.quit();
        	
        }
		
	}


