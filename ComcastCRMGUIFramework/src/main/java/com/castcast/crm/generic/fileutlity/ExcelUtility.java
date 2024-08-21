package com.castcast.crm.generic.fileutlity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public String getDataFromExcel(String SheetName, int row, int cell) throws EncryptedDocumentException, IOException {

		String path = "./test_config/apachetestdata.xlsx";

		FileInputStream fis = new FileInputStream(new File(path));

		Workbook workbook = WorkbookFactory.create(fis);

		Sheet sheet = workbook.getSheet(SheetName);
		String data = sheet.getRow(row).getCell(cell).toString();
		
		workbook.close();

		return data;
	}

	public int getRowCount(String SheetName) throws EncryptedDocumentException, IOException {
		String path = "./test_config/apachetestdata.xlsx";

		FileInputStream fis = new FileInputStream(new File(path));

		Workbook workbook = WorkbookFactory.create(fis);

		Sheet sheet = workbook.getSheet(SheetName);

		int data = sheet.getLastRowNum();
		
		workbook.close();

		return data;
	}

	public void setDataToExcel(String sheetName, int row, int cell, String data) throws EncryptedDocumentException, IOException {
		String path = "./test_config/apachetestdata.xlsx";

		FileInputStream fis = new FileInputStream(new File(path));

		Workbook workbook = WorkbookFactory.create(fis);

		Sheet sheet = workbook.getSheet(sheetName);
		
		sheet.getRow(row).createCell(cell);
		
		FileOutputStream fos=new FileOutputStream(path);
		workbook.write(fos);
		workbook.close();

	}
}
