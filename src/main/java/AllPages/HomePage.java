package AllPages;

import java.sql.Driver;
import org.apache.commons.math3.analysis.function.Constant;
import org.openqa.selenium.By;
import BasePackage.BaseClass;
 
public class HomePage   extends BaseClass
{
	
	public static By welcomeMessage = By.xpath("//td/b[text()='Welcome ']");
	public static String welcomeMessageTxt = "Welcome";
	public By employeeDetails = By.xpath("//li/a[text()='Employee Details']");
	public By logOut = By.xpath("//a[text()='Logout']");
	public By reportTab = By.xpath("//a[text()='Report']");
	
	

	public void navigateToEmployeeDetails(int waitInSecs)
	{
		clickElement(employeeDetails, waitInSecs," Employee Details button");
		validateText(EmployeeDetails.createNewUser, EmployeeDetails.createNewUserTxt, "Navigate to Employee Tab");
	}
	

	public void navigateToReports(int timeInSecs, String comments)
	{
		clickElement(reportTab, timeInSecs , comments);
	}
	
	public void logOut(int waitInSecs)
	{
		clickElement(logOut, waitInSecs , " Log Out");
		validateText(LoginPage.logOutMsg, LoginPage.loggedOutMsgTxt, "Logout"); 
	}
	
	
	
}
