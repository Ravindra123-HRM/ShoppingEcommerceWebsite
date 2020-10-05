package com.shopping.page.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.shopping.base.Logs;



public class LoginPage  {


	@FindBy(xpath="//*[contains(text(),'Sign in')]")
	WebElement Sigin;
	
	@FindBy(xpath="//*[@title='My Store']")
	WebElement title;
	@FindBy(id="email")
	WebElement Email;
	
	@FindBy(id="passwd")
	WebElement Password;
	
	@FindBy(css="button#SubmitLogin")
	WebElement Button;
	
   @FindBy(css="img[class='img-responsive']")
   WebElement image;
   
  @FindBy(xpath="//div[@class='header_user_info']//a[contains(text(),'Sign out')]")
  WebElement signout;
	
	   public LoginPage(WebDriver driver)
	    {
	
	    	PageFactory.initElements(driver, this);
	    	
	    }
	   
	   public void clickonSign_In()
	   {  
		   Sigin.click(); 
		   Logs.info("Click on sign button");
		   
		   
		   
	   }
	   public void clickonEmail(String Username,String password)
	   {
		   Email.sendKeys(Username);
		   Logs.info("Enter Username");
		   Password.sendKeys(password);
		   Logs.info("Enter Password");
		   Button.click();
		   Logs.info("click on sign button");
		   //Logs.info(image.isDisplayed());
		  
		  // Logs.info(signout.isSelected());
		   
		   
	   }
	
}
