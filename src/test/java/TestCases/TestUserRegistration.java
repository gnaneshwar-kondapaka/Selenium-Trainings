package TestCases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.testng.annotations.Test;
import AllPages.EmployeeDetails;
import AllPages.EmployeeRegistration;
import AllPages.HomePage;
import AllPages.LoginPage;
import BasePackage.BaseClass;
import ConstantsPackage.Constants;
import Utilities.ReadAndWriteXSSF;

public class TestUserRegistration extends BaseClass
{
	@Test
	public void testUserRegistration() throws IOException, InterruptedException
	{
		 LoginPage login = new LoginPage();
		 HomePage homepage = new HomePage();
		 EmployeeDetails empdetails = new EmployeeDetails();
		 EmployeeRegistration empregister = new EmployeeRegistration(); 
		 ReadAndWriteXSSF read = new ReadAndWriteXSSF(Constants.testDataFile, Constants.loginSheet);
		 
		 //Navigating to website
		 navigateToUrl(Constants.url, Constants.pageTitle);
		 
		 //Logging in as Admin
		 ArrayList<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();
		 list = read.getData(); 
		 login.testUserLogin(list.get(Constants.firstSet).get(Constants.userNameKey), list.get(Constants.firstSet).get(Constants.passwordKey).toString(), Constants.s_time);
		 homepage.navigateToEmployeeDetails(Constants.s_time);
		 
		 //Creating new Users
		 read = new ReadAndWriteXSSF(Constants.testDataFile, Constants.userSheet);
		 list = new ArrayList<HashMap<String,Object>>();
		 list = read.getData();
		 for(int row=0; row<list.size(); row++)
		 {
			 
			 empdetails.clickOnCreateNewUser();
			 empregister.enterUserName(list.get(row).get(Constants.userNameKey), Constants.s_time);
			 empregister.enterFirstName(list.get(row).get(Constants.firstNameKey), Constants.s_time);
			 empregister.enterLastName(list.get(row).get(Constants.lastNameKey), Constants.s_time);
			 empregister.enterPassword(list.get(row).get(Constants.passwordKey), Constants.s_time);
			 empregister.enterConfirmationPwd(list.get(row).get(Constants.confirmPasswordKey), Constants.s_time);
			 empregister.enterDateOfJoining(list.get(row).get(Constants.dateOfJoiningKey), Constants.s_time);
			 empregister.enterRatePerHr(list.get(row).get(Constants.ratePerHrKey), Constants.s_time);
			 empregister.enterMobileNO(list.get(row).get(Constants.mobileNoKey), Constants.s_time);
			 empregister.enterOfficeNO(list.get(row).get(Constants.officeNoKey), Constants.s_time);
			 empregister.enterEmailId(list.get(row).get(Constants.emailIdKey), Constants.s_time);
			 empregister.enterAddressOne(list.get(row).get(Constants.addressOneKey), Constants.s_time);
			 empregister.enterAddressTwo(list.get(row).get(Constants.addressTwokey), Constants.s_time);
			 empregister.enterCountry(list.get(row).get(Constants.countryKey), Constants.s_time);
			 empregister.enterAreaOfInterest(list.get(row).get(Constants.areaOfInterestKey), Constants.s_time );
			 
			 empregister.clickOnSaveDetails(Constants.s_time);
			 empregister.validateConfirmationText();
			 empregister.validateConfirmationTextColor();
			 
			 homepage.navigateToEmployeeDetails(Constants.s_time);
			 empdetails.employeePresent(list.get(row).get(Constants.userNameKey), Constants.s_time);
		 }
		 homepage.logOut(Constants.s_time);
		 
	}
 
 
}
