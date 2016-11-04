package com.application.core.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {
	
	private static Workbook wb=null;
	static String file="testData.xlsx";
	
	public static String getExcelData(String strSheetName,int rowNum, int cellNum){
		String retValue=null;
		try{
			FileInputStream in = new FileInputStream("src/main/resources/testdata/"+file);
			wb=WorkbookFactory.create(in);
			Sheet sh=wb.getSheet(strSheetName);
			Row row=sh.getRow(rowNum);
			Cell cell=row.getCell(cellNum);
			retValue=cell.toString();
		} catch(FileNotFoundException | InvalidFormatException | EncryptedDocumentException e){
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		}		
		return retValue;
	}
}
