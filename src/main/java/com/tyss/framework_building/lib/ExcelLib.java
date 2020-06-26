package com.tyss.framework_building.lib;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.IllegalFormatException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
//import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelLib 
{
	public static String getData(String sheet,int row,int cell,String filePath) throws EncryptedDocumentException, IllegalFormatException, IOException, InvalidFormatException
	{
		String val="";
		FileInputStream fis=new FileInputStream(filePath);
		Workbook wb=WorkbookFactory.create(fis);
		org.apache.poi.ss.usermodel.Cell c=wb.getSheet(sheet).getRow(row).getCell(cell);	
		val=c.getStringCellValue();
		
		return val;
	}
}

