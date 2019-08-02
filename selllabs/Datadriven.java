package com.selllabs;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Datadriven {
	
	@Test(dataProvider="TestDrive")
	public void add(String val1,String val2,String val3) {
		
		int a=Integer.parseInt(val1);
		int b=Integer.parseInt(val2);
		int c=Integer.parseInt(val3);
		
		System.out.println("Values are "+a+" "+b+" "+c);
	}
	
	@DataProvider(name="TestDrive")
	public Object[][] read() throws Exception, IOException {
		File f=new File("C:\\Selenium\\Java\\workspace\\test.xls");
		Workbook wb=Workbook.getWorkbook(f);
		Sheet sh=wb.getSheet(0);
		int row=sh.getRows();
		int col=sh.getColumns()-1;
		String [][] str =new String[row][col];
		
		for (int j=0;j<col;j++) {
			
			for(int i=0;i<row;i++) {
				
				Cell c=sh.getCell(j+1, i);
				str[j][i]=c.getContents();
				//System.out.println(str[j][i]);
			}
		}
		
		return str;
		
	}

}
