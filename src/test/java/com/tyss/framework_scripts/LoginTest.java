package com.tyss.framework_scripts;

import java.io.FileInputStream;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.tyss.framework_building.init.IConstants;
import com.tyss.framework_building.lib.BaseLib;
import com.tyss.framework_building.lib.ExcelLib;
import com.tyss.framework_building.pages.HomePage;

public class LoginTest extends BaseLib
{
	@Test
	public void tc_01() 
	{
		driver.findElement(By.xpath("//a[contains(.,'My Account')]")).click();
		FileInputStream fin=new FileInputStream(IConstants.dataExcelPath);
		Workbook workbook=WorkbookFactory.create(fin);
		Sheet sheet=workbook.getSheet("Sheet1");
		String username=workbook=sheet.getRow(1).getCell(1).getStringCellValue();
		String password=workbook=sheet.getRow(1).getCell(2).getStringCellValue();
		driver.findElement(By.id("exampleInputEmail1")).sendkeys(username);
		driver.findElement(By.id("exampleInputPassword1")).sendkeys(password);
		Thread.sleep(3000);
		driver.findElement(By.name("login")).click();
		Thread.sleep(3000);
		
		
	}
	@Test
	public void tc_02() throws InterruptedException
	{
		HomePage hp=new HomePage(driver);
		hp.myAccountBtnClick();
		SignInPage sip=new SignInPage(driver);
		String un=ExcelLib.getData("Sheet1", 1, 1, IConstants.dataExcelPath);
		String pw=ExcelLib.getData("Sheet1", 1, 2, IConstants.dataExcelPath);
		sip.doLogin(un,pw);
		Thread.sleep(2000);
	}
	@Test
	public void tc_03() throws InterruptedException
	{
		HomePage hp=new HomePage(driver);
		hp.searchBoxEnterTextAndClick("TV");
		//hp.myAccountBtnClick();
		Thread.sleep(2000);
	}


}
