package com.tyss.framework_building.lib;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelLib 
{
public static String getData(String sheet,int row,int cell,String filePath)
{
	String val="";
	try {
		FileInputStream fin=new FileInputStream(filePath);
		Workbook wb=WorkbookFactory.create(fin);
		Cell c=wb.getSheet(sheet).getRow(row).getCell(cell);
		val=c.getStringCellValue();
		}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return val;
}
}

