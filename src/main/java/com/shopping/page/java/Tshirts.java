package com.shopping.page.java;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.shopping.base.Logs;
import com.shopping.base.TestBase;

public class Tshirts extends TestBase 


{
	public JavascriptExecutor js;
	
	
	@FindBy(xpath="//a[@class='sf-with-ul'][contains(text(),'Women')]")
	WebElement Women;
	
	@FindBy(xpath="//ul[@class='submenu-container clearfix first-in-line-xs']//li//ul//a[contains(text(),'Blouses')]")
	WebElement tshirts;
	
	@FindBy(id="selectProductSort")
	WebElement Sort;
	
	@FindBy(xpath="//div[@class='product-image-container']")
	WebElement cart;
	@FindBy(xpath="//div[@class='button-container']//following::a//span[contains(text(),'Add to cart')]")
	WebElement Addtocart;
	   public Tshirts(WebDriver driver)
	    {
	
	    	PageFactory.initElements(driver, this);
	    	
	    }
	   
	   public void clickon_WomenTab() throws InterruptedException
	   {
		   
		   Actions a=new Actions(driver);
		   //Thread.sleep(2000);
		   a.moveToElement(Women).build().perform();
		  tshirts.click();
		  Logs.info("click on tshirt button");
		   
	   }
	   
	   public void clickon_Size() throws InterruptedException
	   {
		  String[] names= {"Cotton","Casual"};
		  
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
	   public void clickOn_Sortby()
	   {
		   
		   Select sort=new Select(Sort);
		   sort.selectByVisibleText("Price: Lowest first");
		   
	   }
	   
	   public void clickOn_AddtoCart()
	   {
		   
		   Actions a=new Actions(driver);
		   a.moveToElement(cart).build().perform();
		   Addtocart.click();
		   Logs.info("click on Add to cart");
	   }
	   
	   public void clickOn_proceedTocheckout() 
	   {
	     
		 WebElement Proceed= driver.findElement(By.xpath("//div[@class='clearfix']//following::div//span[contains(text(),'Proceed to checkout')]"));
		 Proceed.click();
		 Logs.info("click on Procedd to checkout");
		   
	   }
	   
	  public void clickOn_Quantity() throws InterruptedException
	   {
		
		   WebElement quantity=driver.findElement(By.xpath("//div[@class='cart_quantity_button clearfix']//a[2]//i[@class='icon-plus']"));
		 for(int count=1;count<=3;count++)
		 {
			 Thread.sleep(2000);
     	    quantity.click();
     	   
		 }
		   
		   Thread.sleep(2000);
		   js= (JavascriptExecutor)driver;  
		   js.executeScript("scroll(0,750)");
		 // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		   WebElement checkout=driver.findElement(By.xpath("//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]"));
		   checkout.click(); 
			 Logs.info("click on Procedd to checkout");
	   
	   }
	  
	  public void clickOn_editAddress() throws InterruptedException, IOException
	  {
//		  WebElement update=driver.findElement(By.xpath("//*[contains(@id,'address_delivery')]//span[contains(text(),'Update')]"));
//		  update.click();
		/* WebElement companyname= driver.findElement(By.id("company"));
		 companyname.sendKeys("xyz");
		 String name=companyname.getText();
		 String cname="";
		 if(name.equals(cname))
		 {   companyname.clear();
			 companyname.sendKeys("ABC");
		 }
		 else if(!name.contains(cname))
		 {
			 companyname.sendKeys("XYZ");
		 }
		  WebElement country=driver.findElement(By.id("id_state"));
		  Select state=new Select(country);
		  state.selectByIndex(5);
		  js=(JavascriptExecutor)driver;
		  js.executeScript("scroll(0,750)");
		  driver.findElement(By.xpath("//span[contains(text(),'Save')]")).click();*/
		  FileInputStream fis=new FileInputStream("./src/main/java/com/shopping/ReadData/java/ReadData.xlsx");
		  XSSFWorkbook workbook=new XSSFWorkbook(fis);
		  XSSFSheet sheet=workbook.getSheet("Sheet1");
		  int rowcount=sheet.getLastRowNum();
		  int colcount=sheet.getRow(0).getLastCellNum();
		  for(int i=1;i<=rowcount;i++)
		  {
			  WebElement update=driver.findElement(By.xpath("//*[contains(@id,'address_delivery')]//span[contains(text(),'Update')]"));
			  update.click();
			 XSSFRow currentrow=sheet.getRow(i); 
			 String FirstName=currentrow.getCell(0).toString();
			 String LastName=currentrow.getCell(1).toString();
			 String Comapny=currentrow.getCell(2).toString();
			 String Address=currentrow.getCell(3).toString();
			 String City=currentrow.getCell(4).toString();
			 String MobilePhone=currentrow.getCell(5).toString();
			 
			 WebElement Firstname=driver.findElement(By.id("firstname"));
			 Firstname.clear();
			 Firstname.sendKeys(FirstName);
			 
			 WebElement Lastname= driver.findElement(By.id("lastname"));
			 Lastname.clear();
			 Lastname.sendKeys(LastName);
			 WebElement companyname= driver.findElement(By.id("company"));
			 companyname.clear();
			 companyname.sendKeys(Comapny);
			 String name=companyname.getText();
			 String cname="";
			 if(name.equals(cname))
			 {   companyname.clear();
				 companyname.sendKeys("ABC");
			 }
			 else if(!name.contains(cname))
			 {
				 companyname.sendKeys("XYZ");
			 }
			 
			 WebElement city=driver.findElement(By.id("city"));
			 city.clear();
			 city.sendKeys(City);
			 
//			WebElement Mobile_No= driver.findElement(By.id("phone_mobile"));
//			Mobile_No.clear();
//			Mobile_No.sendKeys(MobilePhone);
			 js=(JavascriptExecutor)driver;
			  js.executeScript("scroll(0,750)");
			  driver.findElement(By.xpath("//span[contains(text(),'Save')]")).click();
			  
		  }
		  
		  Logs.info("click on save button");
		
		  js=(JavascriptExecutor)driver;
		  js.executeScript("scroll(0,350)");
		  driver.findElement(By.xpath("//button[@name='processAddress']//span[contains(text(),'Proceed to checkout')]")).click();
			 Logs.info("click on Procedd to checkout");
	  }
	  
	  public void ClickOn_TermsandProceedToCheck()
	  {
		  js=(JavascriptExecutor)driver;
		  js.executeScript("scroll(0,350)");
		  driver.findElement(By.xpath("//div[@id='uniform-cgv']//span")).click();
		  driver.findElement(By.xpath("//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]")).click();
		  driver.findElement(By.xpath("//p[@class='payment_module']//a[contains(text(),'Pay by bank wire')]")).click();
		  js=(JavascriptExecutor)driver;
		  js.executeScript("scroll(0,550)");
		  driver.findElement(By.xpath("//button[starts-with(@class,'button')]//span")).click();
		  
	  }
	  
	

}

