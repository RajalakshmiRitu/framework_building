package com.tyss.framework_scripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.IllegalFormatException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tyss.framework_building.init.IConstants;
import com.tyss.framework_building.lib.BaseLib;
import com.tyss.framework_building.lib.ExcelLib;
import com.tyss.framework_building.pages.HomePage;
import com.tyss.framework_building.pages.MyCartPage;
import com.tyss.framework_building.pages.SignInPage;

public class LoginTest extends BaseLib
{
	
	/*@Test
	public void tc_01() 
	{
		driver.findElement(By.xpath("//a[contains(.,'My Account')]")).click();
		FileInputStream fin=new FileInputStream(IConstants.dataExcelPath);
		Workbook workbook=WorkbookFactory.create(fin);
		Sheet sheet=workbook.getSheet("Sheet1");
		String username=workbook=sheet.getRow(1).getCell(1).getStringCellValue();
		String password=workbook=sheet.getRow(1).getCell(2).getStringCellValue();
		driver.findElement(By.id("exampleInputEmail1")).sendKeys(username);
		driver.findElement(By.id("exampleInputPassword1")).sendKeys(password);
		Thread.sleep(3000);
		driver.findElement(By.name("login")).click();
		Thread.sleep(3000);
		
		
	}*/
	@Test
	public void tc_02() throws InterruptedException, EncryptedDocumentException, IllegalFormatException, IOException, TimeoutException, InvalidFormatException 
	{
		HomePage hp=new HomePage(driver);
		hp.myAccountBtnClick();
		SignInPage sip=new SignInPage(driver);
		String un=ExcelLib.getData("Sheet1", 1, 1, IConstants.dataExcelPath);
		String pw=ExcelLib.getData("Sheet1", 1, 2, IConstants.dataExcelPath);
		sip.doLogi(un,pw);	
		MyCartPage mcp=new MyCartPage(driver);
		

		Assert.assertTrue(mcp.getWelcomeName().contains(ExcelLib.getData("Sheet1", 1, 3, IConstants.ExpectedExcelData)));
		Thread.sleep(2000);
		
	}
}	