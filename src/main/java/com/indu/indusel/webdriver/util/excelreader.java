package com.indu.indusel.webdriver.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.log4j.Logger;
import org.eclipse.jetty.util.log.Log;

import org.testng.annotations.DataProvider;

public class excelreader {

	 @DataProvider(name="test")
     public static Object[][] createdata1( )throws Exception
     {
         Object[][] retobj =  ReadExcelDemo();//{ { 'a','b' }, {'c','d'} };//
         return retobj;

     }
 

	     public static Object[][] ReadExcelDemo () throws Exception
	     {
	    	 {System.out.println("inside excel dataprovider");
	    	    Object [][]a = new Object [1][8];
	      
	             FileInputStream file = new FileInputStream(new File("D://Git//src//main//resources//DataExcel.xlsx"));
	  
	             //Create Workbook instance holding reference to .xlsx file
	             XSSFWorkbook workbook = new XSSFWorkbook(file);
	  
	             //Get first/desired sheet from the workbook
	             XSSFSheet sheet = workbook.getSheetAt(0);
	  
	             //Iterate through each rows one by one
	             Iterator<Row> rowIterator = sheet.iterator();
	             
	             int i=0, j=0;
	             while (rowIterator.hasNext()) 
	             {System.out.println("inside while of row iterator");
	                 Row row = rowIterator.next();
	                 //For each row, iterate through all the columns
	                 Iterator<Cell> cellIterator = row.cellIterator();
	                  j=0;
	                 while (cellIterator.hasNext()) 
	                 { 
	                	 System.out.println("inside while of iterator");
	                     Cell cell = cellIterator.next();
	                     //Check the cell type and format accordingly
	                     switch (cell.getCellType()) 
	                     {
	                         case Cell.CELL_TYPE_NUMERIC:
	                             System.out.print(cell.getNumericCellValue() + "t");
	                             a[i][j]=(int)cell.getNumericCellValue();
	                             break;
	                         case Cell.CELL_TYPE_STRING:
	                             System.out.print(cell.getStringCellValue() + "t" +i +j +"lll");
	                             a[i][j]= cell.getStringCellValue();
	                             System.out.println("inside case");
	                             break;
	                     }
	                     j++;
	                 }
	                     i++;
	                 
	                 
	             }
	           
	             file.close();
	        
	         System.out.println("printing a");
	         /*for (int i= 0; i<3; i++)
	         {for (int j=0; j<2;j++)
	        	 System.out.println(a[i][j]);
	         }*/
	         return a;
	     
	 
	    	 }
	    }
	     
	    
		    	 
  

}
