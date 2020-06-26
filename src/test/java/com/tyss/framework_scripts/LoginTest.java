package com.tyss.framework_scripts;

//import java.io.FileInputStream;
import java.io.IOException;
import java.util.IllegalFormatException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tyss.framework_building.init.IConstants;
import com.tyss.framework_building.lib.BaseLib;
import com.tyss.framework_building.lib.ExcelLib;
import com.tyss.framework_building.lib.GenericLib;
import com.tyss.framework_building.pages.BookListPage;
//import com.tyss.framework_building.pages.BookListPage;
import com.tyss.framework_building.pages.HomePage;
import com.tyss.framework_building.pages.MyCartPage;
import com.tyss.framework_building.pages.SignInPage;

public class LoginTest extends BaseLib
{
	
	@Test
	public void tc_02() throws InterruptedException, EncryptedDocumentException, IllegalFormatException, InvalidFormatException, IOException {
		HomePage hp=new HomePage(driver);
		//Assert.assertEquals(hp.getHomePageTitle(), ExelLib.getData("Sheet1",1,2,IConstants.ExpectedExcelData));
		hp.myAccountBtnClick();
		SignInPage sip=new SignInPage(driver);
		String un=ExcelLib.getData("Sheet1", 1, 1, IConstants.dataExcelPath);
		String pw=ExcelLib.getData("Sheet1", 1, 2, IConstants.dataExcelPath);
		sip.doLogin(un,pw);	
		MyCartPage mcp=new MyCartPage(driver);
		Assert.assertTrue(mcp.getWelcomeName().contains(ExcelLib.getData("Sheet1", 1, 3, IConstants.ExpectedExcelData)));
		Thread.sleep(3000);	
        System.out.println(driver.findElement(By.xpath("//img[@class='img-responsive']")).isDisplayed());
		
		BookListPage blp=new BookListPage();
		blp.booksBtnClick();
		Thread.sleep(3000);
		Alert alt=driver.switchTo().alert();
		alt.accept();
		Thread.sleep(3000);

		GenericLib.scrollBy(driver, 2, 250);
		
	    WebElement y=driver.findElement(By.xpath("//button[contains(text(),'PROCCED TO CHEKOUT')]"));
	
		blp.booksCheckbxClick();
		Thread.sleep(3000);		
		
		blp.proceedChkOut();
		Thread.sleep(3000);		

		GenericLib.scrollBy(driver, 0, 250);
		
		
		
	}


	}
	
