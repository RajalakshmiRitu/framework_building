package com.tyss.framework_building.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tyss.framework_building.lib.GenericLib;


public class BookListPage 
{
	
		
	WebDriver driver;
	GenericLib gl;
	
	@FindBy(xpath="//a[contains(text(),'The Wimpy Kid Do -It- Yourself Book')]/../../..//li[@class='add-cart-button btn-group']//button[contains(text(),'Add to cart')]")
    private WebElement addToCartbtn;
	
	
	@FindBy(xpath="//input[@type='checkbox']")
	private WebElement booksCheckbox;
	
	
	@FindBy(xpath="//button[contains(text(),'PROCCED TO CHEKOUT')]")
	private WebElement proceedChkOut;
	
	public void BooksListPage(WebDriver driver) {
		
		   this.driver=driver;
		   PageFactory.initElements(driver, this);
		   
		}
	
	public void booksBtnClick() throws InterruptedException {
	
	
		addToCartbtn.click();
		
	}
	
	
	
	public void booksCheckbxClick() throws InterruptedException {
	
		booksCheckbox.click();
		//GenericLib.scrollBy(driver, 0, 250);


	}
	
	public void proceedChkOut() {
	
		proceedChkOut.click();
	
	}
	
	
}