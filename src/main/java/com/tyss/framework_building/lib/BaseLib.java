package com.tyss.framework_building.lib;

import java.util.concurrent.TimeUnit;

import javax.naming.Context;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

//import com.google.inject.internal.cglib.proxy..CallbackGenerator.Context;

public class BaseLib 
{
	static
	{
		System.setProperty(GenericLib.getPropData("browseKey"), GenericLib.getPropData("browserValue"));
	}
	public WebDriver driver;
	@BeforeMethod
	public void setUp(ITestContext context)
	{
		if(GenericLib.getPropData("browserName").equalsIgnoreCase("chrome"))
				{
			      ChromeOptions options=new ChromeOptions();
			      options.addArguments("--disable-notifications");
			      driver=new ChromeDriver(options);
				}
		else if(GenericLib.getPropData("browserName").equalsIgnoreCase("firefox"))
		{
			FirefoxOptions options=new FirefoxOptions();
			options.addPreference("dom.webnotifications.enabled",false);
			//driver=new FirefoxDriver(options);
		}
		else
		{
		   Assert.fail("Browser Name not valid");	
		}
		//Context.setAttribute("driver",driver);
		Reporter.log("Browser launch successfully");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(GenericLib.getPropData("url"));
		Reporter.log("Browser loaded successfully");
		
		
	}
	@AfterMethod

	public void tearDown()
	{
		
		driver.close();
	}
	}
	


