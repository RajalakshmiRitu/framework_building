package com.tyss.framework_building.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//import com.tyss.framework_building.lib.GenericLib;

public class HomePage
{WebDriver driver;

@FindBy(xpath="//a[contains(.,'My Account')]")
private WebElement myAccountBtn;


@FindBy(name="product")
private WebElement searchBox;


@FindBy(name="serach")
private WebElement searchBtn;

@FindBy(xpath="//ul[@class='nav navbar-nav']//li[@class='dropdown yamm'][1]")
private WebElement booksBtn;

public HomePage(WebDriver driver) {
	
	this.driver=driver;
	PageFactory.initElements(driver, this);
	
}

public void myAccountBtnClick() {
	
	myAccountBtn.click();
	
}

public void BooksClick() {
 booksBtn.click();


}

}