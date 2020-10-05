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

import com.shopping.base.Logs;
import com.shopping.base.TestBase;

public class EveningDress extends TestBase {
	
	
	public JavascriptExecutor js;

	
	@FindBy(xpath="//a[@class='sf-with-ul'][contains(text(),'Women')]")
	WebElement Women;
	
	
	
	@FindBy(xpath="//ul[@class='submenu-container clearfix first-in-line-xs']//li//ul//a[contains(text(),'Evening Dresses')]")
	WebElement EveningDress;
		
	@FindBy(xpath="//ul[@id='homefeatured']//li[starts-with(@class,'ajax_block')]")
	WebElement Hovermouse;
	
	@FindBy(xpath="//a[@class='product_img_link']//img[@itemprop='image']")
	WebElement image;
	@FindBy(xpath="//div[@class='button-container']//following::a//span[contains(text(),'Add to cart')]")
	WebElement Addtocart;

	
	public EveningDress(WebDriver driver)
    {
   	 
   	 PageFactory.initElements(driver, this);
    }
    
	 public void clickon_WomenTab() throws InterruptedException
	   {
		   
		   Actions a=new Actions(driver);
		   //Thread.sleep(2000);
		   a.moveToElement(Women).build().perform();
		   EveningDress.click();
		  Logs.info("click on EveningDress button");
		   
	   }

     
     
     public void clickon_checkbox() throws InterruptedException
     {
      
    	
    	 String[] names= {"S","Pink","Viscose","Dressy","Short Dress","In stock"};
    	 List<WebElement> Size= driver.findElements(By.xpath("//ul[@class='col-lg-12 layered_filter_ul']//following::li//a"));
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
		    	if(j==names.length)
		    	{
		    	break;
		    	}
		    	
		    		}
		    	 
		     }
		   
    	}
     
     
     
     public void clickOn_continueshopping() 
	   {
	     
		 WebElement Continebtn= driver.findElement(By.xpath("//div[@class='button-container']//span[starts-with(@class,'continue btn')]"));
		 Continebtn.click();
		 Logs.info("click on continue shopping Evening dress");
		   
	   }
     
     public void Hoveron_Cart()
    	 
     {
    	 JavascriptExecutor js = (JavascriptExecutor) driver;
    	 js.executeScript("arguments[0].scrollIntoView();", driver.findElement( By.xpath("//div[@class='shopping_cart']//a[@title='View my shopping cart']")));
    	 Actions a=new Actions(driver);
		   //Thread.sleep(2000);
		   a.moveToElement(driver.findElement(By.xpath("//div[@class='shopping_cart']//a[@title='View my shopping cart']"))).build().perform();
         driver.findElement(By.cssSelector("a[id='button_order_cart']")).click();
     
     }
     
     }
     
     

