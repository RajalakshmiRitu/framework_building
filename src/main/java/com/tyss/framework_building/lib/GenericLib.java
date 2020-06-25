package com.tyss.framework_building.lib;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.tyss.framework_building.init.IConstants;

public class GenericLib 
{
	public static String getPropData(String key)
	{
		String data="";
		try
		{
			FileInputStream fin=new FileInputStream(IConstants.propFilePath);
			Properties prop=new Properties();
			prop.load(fin);
			data=prop.getProperty(key);
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}
	public static void clickElement(WebDriver driver,WebElement ele,String eleName)
	{
		WebDriverWait wait=new WebDriverWait(driver,10);
		try {
			wait.until(ExpectedConditions.visibilityOf(ele)).click();
			Reporter.log("Clicked On"+eleName);
		}
		catch(TimeoutException e)
		{
			Reporter.log(eleName+"Is not Displayed");
			Assert.fail();
		}
	}
	public static void enterText(WebDriver driver,WebElement ele,String eleName, String string)
	{
		WebDriverWait wait=new WebDriverWait(driver,10);
		try {
			String text="";
			wait.until(ExpectedConditions.visibilityOf(ele)).sendKeys(text);
			Reporter.log("Entered Text\""+text+"\"In the"+eleName);
			
		}
		catch(TimeoutException e)
		{
			Reporter.log(eleName+"Is not Displayed");
			Assert.fail();
		}
	}
	
}
