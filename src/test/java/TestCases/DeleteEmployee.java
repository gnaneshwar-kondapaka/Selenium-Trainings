package TestCases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import AllPages.EmployeeDetails;
import AllPages.EmployeeRegistration;
import AllPages.HomePage;
import AllPages.LoginPage;
import BasePackage.BaseClass; 
import ConstantsPackage.Constants;
import Utilities.Hightlight;
import Utilities.ReadAndWriteXSSF;
import junit.framework.Assert;

public class DeleteEmployee extends BaseClass
{

	@Test
	public void deleteEmployee() throws IOException, InterruptedException
	{
		
		LoginPage login = new LoginPage();
		HomePage home = new HomePage();
		EmployeeDetails empdetails = new EmployeeDetails();
		ReadAndWriteXSSF read = new ReadAndWriteXSSF(Constants.testDataFile, Constants.loginSheet);
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String,Object>>();
		list = read.getData();
		
		//Navigating to website
		navigateToUrl(Constants.url, Constants.pageTitle);
		
		//Logging in as Admin
		login.testUserLogin(list.get(Constants.firstSet).get(Constants.userNameKey), list.get(Constants.firstSet).get(Constants.passwordKey), Constants.s_time);
		
		//Peforming delete operation on random employee
		home.navigateToEmployeeDetails(Constants.vs_time);
		empdetails.deleteRandomEmployee(Constants.vs_time);
		empdetails.verifyEmployedDeletion();
		
		//Loging out from the application
		home.logOut(Constants.s_time);
		
		
		
		
	}
 
	
}
