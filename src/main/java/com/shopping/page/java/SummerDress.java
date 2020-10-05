package com.shopping.page.java;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.shopping.base.Logs;
import com.shopping.base.TestBase;

public class SummerDress extends TestBase {
	
	
	public JavascriptExecutor js;

	
	@FindBy(xpath="//a[@class='sf-with-ul'][contains(text(),'Women')]")
	WebElement Women;
	
	@FindBy(id="selectProductSort")
	WebElement Sort;
	
	@FindBy(xpath="//ul[@class='submenu-container clearfix first-in-line-xs']//li//ul//a[contains(text(),'Summer Dresses')]")
	WebElement SummerDress;
	@FindBy(xpath="//a[contains(text(),'Printed Chiffon Dress')]")
	WebElement cart;
	
	@FindBy(xpath="//a[contains(text(),'Printed Chiffon Dress')]//following::a//span[contains(text(),'Add to cart')]")
	WebElement Addtocart;
	
	@FindBy(xpath="//a[starts-with(@class,'btn btn-default')]//span[contains(text(),'Home')]")
	WebElement home;
	
	 public SummerDress(WebDriver driver)
     {
    	 
    	 PageFactory.initElements(driver, this);
     }
	 public void clickon_WomenTab() throws InterruptedException
	   {
		   
		   Actions a=new Actions(driver);
		   //Thread.sleep(2000);
		   a.moveToElement(Women).build().perform();
		   SummerDress.click();
		  Logs.info("click on Summerer Dress button");
		   
	   }

    
     
    
     public void clickon_checkbox() throws InterruptedException
     {
      
    	
    	 String[] names= {"S","Blue","Girly","Polyester"};//div[@class='block_content']//following::label//a
    	 List<WebElement> Size= driver.findElements(By.xpath("//div[@class='block_content']//following::label//a"));
		  int j=0;
		 
		 // WebElement Name=driver.findElement(By.xpath("//label[@for='layered_id_attribute_group_1']//a[contains(text(),'S')]"));
		  
		    for(int i=0;i<Size.size();i++)
		    {
		    		String[] check=Size.get(i).getText().split(" ");
		    		String formattedName=check[0].trim();
		   
		    		List checkboxlist=Arrays.asList(names);
		    		if(checkboxlist.contains(formattedName))
		    		{
		    			j++;
		    			
		    	driver.findElements(By.xpath("//ul[@class='col-lg-12 layered_filter_ul']//li//div")).get(i).click();
		    	if(j==names.length)//ul[@class='col-lg-12 layered_filter_ul']//li//div
		    	{
		    	break;
		    	}
		    	
		    		}
		    	 
		     }
		   
    	}
     public void clickOn_Sortby()
	   {
		   
		   Select sort=new Select(Sort);
		   sort.selectByVisibleText("Price: Lowest first");
		   Logs.info("Click on price drop down");
		   
	   }
	   
	   public void clickOn_AddtoCart() throws InterruptedException
	   {
		   
		   Actions a=new Actions(driver);
		   a.moveToElement(cart).build().perform();
		   Thread.sleep(2000);
		   Addtocart.click();
		   Logs.info("click on Add to cart");
	   }
     
     public void clickOn_proceedTocheckout() 
	   {
	     
		 WebElement Continebtn= driver.findElement(By.xpath("//div[@class='button-container']//span[starts-with(@class,'continue btn')]"));
		 Continebtn.click();
		   Logs.info("click on Continue to shopping");
	   }
    	 
     }
     
     

