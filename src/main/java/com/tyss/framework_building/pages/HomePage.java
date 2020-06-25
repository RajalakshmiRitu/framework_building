package com.tyss.framework_building.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tyss.framework_building.lib.GenericLib;

public class HomePage
{
	WebDriver driver;
	@FindBy(xpath="//a[contains(.,'My Account')]") //declaration 
	private WebElement myAccountBtn; //creating a reference var of WebElement
	
	@FindBy(name="product")
	private WebElement searchBox;
	
	@FindBy(xpath="//button[@name='search']")
	private WebElement searchBtn;
	
	public HomePage(WebDriver driver)
	{
	    this.driver=driver;
		PageFactory.initElements(driver, this);//whatever the ele declared it finds and initialises
	}
    
	public void myAccountBtnClick()
	{
		//myAccountBtn.click();
		GenericLib.clickElement(driver,myAccountBtn,"Account Button");
		
	}
public void searchBoxEnterTextAndClick(String searchText) throws InterruptedException
{
	GenericLib.enterText1(driver,searchBox,searchText,"SearchBox");
	Thread.sleep(2000);
	GenericLib.clickElement(driver,searchBtn,"Search Btn");
}
}
