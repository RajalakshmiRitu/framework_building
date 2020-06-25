package com.tyss.listeners;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.tyss.framework_building.lib.GenericLib;

public class MyListener implements ITestListener
{

public void onTestStart(ITestResult result) {
		
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd-MM-yyyy hh-mm-ss");
		String startTime=LocalDateTime.now().format(dtf);
		Reporter.log("The Test Case: "+result.getName()+" Started At :"+startTime);
		
	}

	public void onTestSuccess(ITestResult result) {
	   
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd-MM-yyyy hh-mm-ss");
	    String endTime=LocalDateTime.now().format(dtf);
	    Reporter.log("The Test Case: "+result.getName()+" Completed At  :"+endTime);    
	
	}

   public void onTestFailure(ITestResult result) {


		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd-MM-yyyy hh-mm-ss");
	    String endTime=LocalDateTime.now().format(dtf);
	    Reporter.log("The Test Case: "+result.getName()+" Failed At  :"+endTime);  
        WebDriver driver=(WebDriver) result.getTestContext().getAttribute("driver");
         GenericLib.saveScreenShot(driver,result.getName());   
    }
   
   public void onTestSkipped(ITestResult result) {
   
   
     }
   
   
   public void onStart(ITestContext context) {
   
	   DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd-MM-yyyy hh-mm-ss");
	    String startTime=LocalDateTime.now().format(dtf);
	    Reporter.log("The Test Suite started at :" +startTime);  

}
   
   
   public void onFinish(ITestContext context) {
   
	   DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd-MM-yyyy hh-mm-ss");
	    String onFinishtime=LocalDateTime.now().format(dtf);
	    Reporter.log("The Test Case Suite completed At  :" +onFinishtime);  
   
  }



}