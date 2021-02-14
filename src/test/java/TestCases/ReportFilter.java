package TestCases;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;

import org.testng.annotations.Test;

import AllPages.HomePage;
import AllPages.LoginPage;
import AllPages.Reports;
import BasePackage.BaseClass; 
import ConstantsPackage.Constants;
import Utilities.ReadAndWriteXSSF;

public class ReportFilter extends BaseClass
{
	
	@Test
	public void testReportFilter() throws InterruptedException, IOException, ParseException
	{
		LoginPage login = new  LoginPage();
		Reports report = new Reports();
		HomePage home = new HomePage();
		ReadAndWriteXSSF read = new ReadAndWriteXSSF(Constants.testDataFile, Constants.loginSheet);

		
		//Navigate to URL
		navigateToUrl(Constants.url, Constants.pageTitle);
		
		//Logging in as Admin
		ArrayList<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();
		list = read.getData();
		login.testUserLogin(list.get(Constants.firstSet).get(Constants.userNameKey), list.get(Constants.firstSet).get(Constants.passwordKey), Constants.s_time);
		
		
		//Generating and Validating Report
		read = new ReadAndWriteXSSF(Constants.testDataFile, Constants.timeSheet);
		list = read.getData();
		home.navigateToReports(Constants.s_time, "Reports Page");
		report.selectStartDate(list.get(Constants.firstSet).get(Constants.startDateKey), Constants.s_time);
		report.selectEndDate(list.get(Constants.firstSet).get(Constants.endDateKey), Constants.s_time);
		report.viewReport(Constants.s_time, "View Reports");
		report.validateAllDates(Constants.s_time);
	}
	
	
}
