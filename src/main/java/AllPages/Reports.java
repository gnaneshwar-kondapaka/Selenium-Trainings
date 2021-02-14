package AllPages;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import BasePackage.BaseClass; 
import bsh.org.objectweb.asm.Constants;

public class Reports extends BaseClass
{

	public By StartDatecalenderOption = By.xpath("(//*[@id=\"anchor1\"]/img)[1]");
	public By EndDatecalenderOption = By.xpath("(//*[@id=\"anchor1\"]/img)[2]");
	public By startDate = By.xpath("//input[@name='startDate']");
	public By endDate = By.xpath("//input[@name='endDate']");
	public By previousMonth = By.xpath("/html/body/center/table[1]/tbody/tr/td[1]/a");
	public By nextMonth = By.xpath("/html/body/center/table[1]/tbody/tr/td[3]/a");
	public By viewReportBtn = By.xpath("//input[@value='View Report']");
	
	public By nextPageOption = By.xpath("//a[text()='[Next]']");

	public String currentFullDate =null;
	public int currentMonth ;
	public int currentYear ;
	
	public String expectedFullDate = null;
	public int expectedMonth ;
	public int expectedYear ;
	public int expectedDate;
	
	
	

	public void selectEndDate(Object YYYY_MM_DD , int waitInSecs) throws InterruptedException  
	{ 
		
		currentFullDate = driver.findElement(endDate).getAttribute("value");
		expectedFullDate = YYYY_MM_DD.toString();
		
		String[] currdate = new String[3];
		currdate = currentFullDate.split("-");
		currentYear = Integer.parseInt(currdate[0]);
		currentMonth = Integer.parseInt(currdate[1]);
		
		
		String[] expectedDatearray = new String[3];
		expectedDatearray =  expectedFullDate.split("-");
		expectedYear = Integer.parseInt(expectedDatearray[0]);
		expectedMonth = Integer.parseInt(expectedDatearray[1]);
		expectedDate = Integer.parseInt(expectedDatearray[2]);
		
		selectDate(EndDatecalenderOption, expectedFullDate,expectedDate, waitInSecs, "End Date calender option");
		
	}
	
	
	public void selectStartDate(Object YYYY_MM_DD, int waitInSecs ) throws InterruptedException  
	{ 
		
		currentFullDate = driver.findElement(startDate).getAttribute("value");
		expectedFullDate = YYYY_MM_DD.toString();
		
		String[] currdate = new String[3];
		currdate = currentFullDate.split("-");
		currentYear = Integer.parseInt(currdate[0]);
		currentMonth = Integer.parseInt(currdate[1]);
		
		
		String[] expectedDatearray = new String[3];
		expectedDatearray =  expectedFullDate.split("-");
		expectedYear = Integer.parseInt(expectedDatearray[0]);
		expectedMonth = Integer.parseInt(expectedDatearray[1]);
		expectedDate = Integer.parseInt(expectedDatearray[2]);
		
		selectDate(StartDatecalenderOption, expectedFullDate, expectedDate, waitInSecs, " Start Date calender option");
		
	}
	
	
	public void selectDate(By calender,String fullDate, int expectedDate, int waitInSecs, String Comments) throws InterruptedException
	{
 
		clickElement(calender, waitInSecs , Comments);
		
		int noOfMonths = ((12-currentMonth)-(12-expectedMonth)+((currentYear-expectedYear)*-12));
		changeWindowFocus(2);
		if(noOfMonths<0)
		{
			noOfMonths = noOfMonths*-1;
			for(int i=0; i< noOfMonths; i++)
			{
				clickElement(previousMonth, waitInSecs);
			}
		}
		else
		{
			for(int i=0; i< noOfMonths; i++)
			{
				clickElement(nextMonth, waitInSecs);
			}
		}  
		
		clickElement(By.xpath("//a[text()='"+expectedDate+"']"), waitInSecs, "Date : "+fullDate);
		changeWindowFocus(1); 
	}
	
	public void viewReport(int timeInSecs,String comments)
	{
		clickElement(viewReportBtn, timeInSecs, comments);
	}
	
	
	public void validateAllDates(int timeInSecs) throws ParseException
	{
		
		String startDateValue = driver.findElement(startDate).getAttribute("value");
		String endDateValue = driver.findElement(endDate).getAttribute("value");
		
		
		int count =0 ;
		List<Date> list = new ArrayList<Date>();
		  
		for(int i=2; i<5000; i++)
		{
			try 
			{
				String text = driver.findElement(By.xpath("//table[@class='stylized']/tbody/tr["+i+"]/td[4]")).getText();
				SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
				list.add(sd.parse(text));
				count++;
			}
			catch(Exception e)
			{
				try 
				{
					driver.findElement(nextPageOption).click();
					i = 1;
				}
				catch(Exception ie)
				{
					break;
				}
			}
			
		} 
		 
		 
		if(list.size()==count && count>0)
		{
			SimpleDateFormat sdd = new SimpleDateFormat("yyyy-MM-dd");
			Date endD = sdd.parse(endDateValue.toString());
			Date startD= sdd.parse(startDateValue.toString());
			Date maxD= Collections.max(list);
			Date minD = Collections.min(list);


			if(endD.compareTo(maxD)>=0 && startD.compareTo(minD)<=0)
			{
				test.pass(MarkupHelper.createLabel("All Dates are in given range", ExtentColor.GREEN));
			}
			else
			{ 
				test.fail(MarkupHelper.createLabel("Dates are not in range", ExtentColor.RED));
				Assert.fail();
			}
			
		}  
		else if (count ==0) 
		{
			test.pass("No Records Found");
		}
		else
		{
			test.fail("All Dates are Not Retreived");
			Assert.fail("All Dates are Not Retreived");
		}
		
	}
	
	
}

 