package com.SauceDemo.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {

	public static FileInputStream fis;
	public static XSSFWorkbook wb;
	public static XSSFSheet sh;
	public static XSSFRow row;
	public static XSSFCell cell;

	public static int getRowCount(String excelPath,String sheetName) throws IOException
	{
		fis=new FileInputStream(excelPath);
		wb=new XSSFWorkbook(fis);
		sh=wb.getSheet(sheetName);
		int rowCount=sh.getLastRowNum();
		return rowCount;
	}

	public static int getCellCount(String excelPath,String sheetName,int rownum) throws IOException
	{
		fis=new FileInputStream(excelPath);
		wb=new XSSFWorkbook(fis);
		sh=wb.getSheet(sheetName);
		row=sh.getRow(0);
		int cellCount=row.getLastCellNum();
		return cellCount;

	}

	public static String getCellData(String excelPath,String sheetName,int rownum,int cellnum) throws IOException
	{
		fis=new FileInputStream(excelPath);
		wb=new XSSFWorkbook(fis);
		sh=wb.getSheet(sheetName);
		row=sh.getRow(rownum);
		cell=row.getCell(cellnum);
		String data;

		try 
		{
			DataFormatter formatter = new DataFormatter();
			String cellData = formatter.formatCellValue(cell);
			return cellData;
		}
		catch (Exception e) 
		{
			data="";
		}
		wb.close();
		fis.close();
		return data;
	}

}






