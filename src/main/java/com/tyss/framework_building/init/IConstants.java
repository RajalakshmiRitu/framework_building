package com.tyss.framework_building.init;

public interface IConstants 
{
	 String projDir=System.getProperty("User.Dir");
		String screenShotPath = projDir+"\\screenshots";
	    String dataExcelPath= projDir+"\\src\\test\\resources\\excel\\Book1.xlsx";
	    String propFilePath = projDir+"\\src\\main\\resources\\properties\\data.properties";
	     String ExpectedExcelData=  projDir+"\\src\\test\\resources\\excel\\testExpectedResults.xlsx";  

}
