package com.shopping.base;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;

import com.shopping.page.java.LoginPage;
import com.shopping.utilities.java.TestUtil;






public class TestBase {
	
	public static Properties pro;
	public static WebDriver driver;
	public static LoginPage lp;

	
	public static WebDriver initialization() throws Exception
	{
		pro=new Properties();
		FileInputStream fis=new FileInputStream("./src/main/java/com/shopping/base/config.properties");
		
		pro.load(fis);
		
		String Browsername=pro.getProperty("chrome");
		
		if(Browsername.equals("chromedriver"))
		{
			System.setProperty("webdriver.chrome.driver","./Chrome/chromedriver.exe");
	       driver = new ChromeDriver();  
	      
			
		}
		
		else if(Browsername.equals("firefoxdriver"))
			{
			   System.setProperty("webdriver.firefox.driver","./Chrome/chromedriver.exe");
		       driver = new ChromeDriver();  
		       driver.manage().window().maximize(); 
				
			}
		driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICT_WAIT, TimeUnit.SECONDS);
	     driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.get(pro.getProperty("URL"));
		return driver;
	}
	
	public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destinationFile=System.getProperty("user.dir")+"\\Reports\\"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
		
		return destinationFile;
		
		
	}

	

}
