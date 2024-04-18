package com.fujitsu.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.fujitsu.Model.OptionSTRModel;
import com.fujitsu.Model.Option_RGST_GRPModel;
import com.fujitsu.frame.ButtonScreen;

public class CreateExcelFile {
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	


	public CreateExcelFile() throws IOException {
		
			workbook = new XSSFWorkbook();
		

	}

	public void createNewWorksheet(String worksheetName) {
		// invoking creatSheet() method and passing the name of the sheet to be created
		sheet = workbook.createSheet(worksheetName);
	}

	public XSSFWorkbook generateExcelFileForOption_STR(List<OptionSTRModel> data, String worksheetName) throws SQLException,IOException {
	
		createNewWorksheet(worksheetName);
				XSSFRow rowhead = sheet.createRow((short)0);  
				//creating cell by using the createCell() method and setting the values to the cell by using the setCellValue() method  
				  
				rowhead.createCell(0).setCellValue("OPT_ID");  
				rowhead.createCell(1).setCellValue("OPT_VALUE1"); 
				rowhead.createCell(2).setCellValue("OPT_VALUE2");  
				rowhead.createCell(3).setCellValue("Result");  ;
				 int i=1;
				for (OptionSTRModel model : data) {
					
					XSSFRow row = sheet.createRow((short)i); 
					row.createCell(0).setCellValue(model.getOPT_ID());  
					row.createCell(1).setCellValue(model.getOPT_VALUE1());  
					row.createCell(2).setCellValue(model.getOPT_VALUE2());  
					row.createCell(3).setCellValue(model.getResult());  
					i++;
			
				}
				writeIntoExcelFile("OPTIONS_STR_"+GetDate()+".xlsx");
			
			return workbook;
			
			
           

	}
	
   public void writeIntoExcelFile(String filename1) throws IOException
   {
	   FileOutputStream  fos = new FileOutputStream(filename1);
		
		workbook.write(fos);
		// closing the Stream
		fos.close();
		// closing the workbook
		//workbook.close();
	//	
		// prints the message on the console
		System.out.println("Excel file has been generated successfully.");
	
	 
   }

public XSSFWorkbook generateExcelFileForOPTION_RGST_GRP(List<Option_RGST_GRPModel> list, String worksheetName) throws IOException {
	createNewWorksheet(worksheetName);
	// creating the 0th row using the createRow() method
	
	XSSFRow rowhead = sheet.createRow((short) 0);
	// creating cell by using the createCell() method and setting the values to the
	// cell by using the setCellValue() method
	rowhead.createCell(0).setCellValue("RGST_GRP_ID");
	rowhead.createCell(1).setCellValue("OPT_ID");
	rowhead.createCell(2).setCellValue("OPT_VALUE1");
	rowhead.createCell(3).setCellValue("OPT_VALUE2");
	rowhead.createCell(4).setCellValue("Result");
	int i = 1;
	for (Option_RGST_GRPModel model : list) {

		XSSFRow row = sheet.createRow((short) i);
		row.createCell(0).setCellValue(model.getRGST_GRP_ID());
		row.createCell(1).setCellValue(model.getOPT_ID());
		row.createCell(2).setCellValue(model.getOPT_VALUE1());
		row.createCell(3).setCellValue(model.getOPT_VALUE2());
		row.createCell(4).setCellValue(model.getResult());
		i++;

	
}
	writeIntoExcelFile("OPTIONS_RGST_GRP_"+GetDate()+".xlsx");
	return workbook;
}

public static  String GetDate() {
	
    LocalDate dateObj = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYYMMdd");
    String date = dateObj.format(formatter);
	return date;
}
}
