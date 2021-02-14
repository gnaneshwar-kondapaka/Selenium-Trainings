package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.collections4.map.EntrySetToMapIteratorAdapter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadAndWriteXSSF {

	static XSSFSheet sheet ;
	static XSSFWorkbook workbook;
	static XSSFRow row ; 
	static XSSFRow firstRow;
	static XSSFCell cell;
	static FileInputStream fi ;
	static FileOutputStream fo ;
	
	static String oPath ;
	static String sName;
	public String value ; 
	
	public  ReadAndWriteXSSF(String path, String  sheetname) throws FileNotFoundException, IOException
	{
	 
			fi = new FileInputStream(path);
			workbook = new XSSFWorkbook(fi);
			sheet = workbook.getSheet(sheetname);
			firstRow = sheet.getRow(0);
			
			
			oPath =path;
			sName =sheetname;
		
	}
	

	public int getTotalRows()
	{
		int rows = sheet.getPhysicalNumberOfRows();
		return rows;
	}
	
	public int getTotalCells()
	{
		int cols = row.getPhysicalNumberOfCells();
		return cols;
	}
	
	public String readCell(int rowno,int cellno)
	{
		
		row = sheet.getRow(rowno);
		XSSFCell col = row.getCell(cellno);
		
		return col.toString();     
	}
	
	public void writeCell(int rowNo, int colNo, String value) throws IOException
	{
		 
		row = sheet.createRow(rowNo);
		cell = row.createCell(colNo);
		cell.setCellValue(value);
		
		fo = new FileOutputStream(oPath);
		workbook.write(fo); 
		sheet = workbook.getSheet(sName);
	}
	
	
	public ArrayList<HashMap<String, Object>> getData()
	{
		
		int rows = sheet.getPhysicalNumberOfRows();
		int cols = firstRow.getPhysicalNumberOfCells();
		ArrayList<HashMap<String, Object>> list = new  ArrayList<HashMap<String,Object>>();
		HashMap<String, Object> map = null;
		
		for(int i =1; i<=rows-1; i++)
		{
			map = new HashMap<String, Object>();
			XSSFRow dataRow = sheet.getRow(i);
			for(int j=0; j<firstRow.getPhysicalNumberOfCells(); j++)
			{
				map.put(firstRow.getCell(j).toString(), dataRow.getCell(j).toString());
			}
			list.add( map);
		}
		return list;
	}
	

}
