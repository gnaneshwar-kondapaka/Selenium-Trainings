package AllPages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import BasePackage.BaseClass; 
import ConstantsPackage.Constants;
import Utilities.Hightlight; 

public class EmployeeDetails  extends BaseClass
{ 
	
	public static By createNewUser = By.xpath("//a[text()='Create New User']");
	public static String createNewUserTxt = "Create New User";
	public By deleteUserLocator = By.xpath("//img[@src='img/delete.jpg']");
	public String  confirmationAlertMessage = "Are you sure want to delete this Employee?";
	public By confirmationMessage = By.xpath("//font[text()='Deleted']");
	public String confirmationMessageTxt = "Deleted";
	public String confirmationMessageRGB = "rgb(0, 128, 0)";
	public By allUserNames = By.xpath("/html/body/table/tbody/tr[2]/td/table/tbody/tr[2]/td/table/tbody/tr[*]/td[1]");
	
	public void clickOnCreateNewUser() throws InterruptedException
	{
		clickElement(createNewUser, Constants.s_time," Create NewUser option"); 
		validateText(EmployeeRegistration.formHeading, EmployeeRegistration.formHeadingMessage, " Navigate to Employee Registration");
	}
	
	public void deleteRandomEmployee(int waitInSecs) throws InterruptedException
	{
		WebElement deleteUser =driver.findElement(deleteUserLocator);
		Hightlight hightlight = new Hightlight();
		hightlight.hightlightElement(deleteUser, driver);
		clickElement(deleteUserLocator, waitInSecs,"Delete Employee button");
		handleAlerts(confirmationAlertMessage, "Employee Deletion");
	
	}
	
	
	public void employeePresent(Object UserName, int waitInSecs)
	{
		
		List<WebElement> list  = new ArrayList<WebElement>();
		list = driver.findElements(allUserNames);
		String[] allUserNames = new String[list.size()-1];
		String userName = UserName.toString();
		Boolean flag = false;
		for(int i=0; i<list.size()-1; i++)
		{
			allUserNames[i] = driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/table/tbody/tr[2]/td/table/tbody/tr["+(i+1) +"]/td[1]")).getText();
			if(userName.equals(allUserNames[i]))
			{
				flag = true;
			}
		}
		if(flag==true)
		{
			test.pass(MarkupHelper.createLabel("Employee with given UserName : "+userName+ " present in employee's table", ExtentColor.GREEN));
		}
		else
		{
			test.fail(MarkupHelper.createLabel("Employee with given UserName : "+userName+" doesn't exist in employee's table", ExtentColor.RED));
			Assert.fail("Employee doesn't Exist");
		}
		
	}
	
	public void verifyEmployedDeletion()
	{
		validateText(confirmationMessage, confirmationMessageTxt, "User Deletion");
		validateTextColor(confirmationMessage, confirmationMessageRGB ," Confimation Message");
	}
	
	
	
}
