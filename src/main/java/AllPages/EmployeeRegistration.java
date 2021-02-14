package AllPages;

import org.openqa.selenium.By;

import BasePackage.BaseClass; 

public class EmployeeRegistration   extends BaseClass
{
	public static By formHeading = By.xpath("//td[contains(text(),'New')]");
	public static String formHeadingMessage = "New Employee Registration Form";
	
	public By username = By.xpath("//*[@id=\"employee_id\"]");
	public By employeeType = By.xpath("//*[@id=\"employee_type\"]");
	public By firstName = By.xpath("//input[@name='first_name']");
	public By lastName = By.xpath("//input[@name='last_name']");
	public By company = By.xpath("//input[@value='QualityPointTech']");
	public By password = By.xpath("//input[@name='password']");
	public By confirmPassword = By.xpath("//input[@name='confirmpassword']");
	public By dateOfJoining = By.xpath("//input[@name='date']");
	public By ratePerHour = By.xpath("//input[@name='rateperhour']");
	public By offNo = By.xpath("//input[@name='offno']");
	public By mobNo = By.xpath("//input[@name='mobno']");
	public By emailID = By.xpath("//input[@name='emailid']");
	public By addressOne = By.xpath("//textarea[@name='address1']");
	public By addressTwo = By.xpath("//textarea[@name='address2']");
	public By country = By.xpath("//select[@id='country']");
	public By areaOfInterest = By.xpath("//textarea[@name='interest']");
	public By saveDetails = By.xpath("//input[@value='Save Details']");
	public By clear = By.xpath("//input[@value='Clear']");
	
	public String confirmationMessagetxt = "Employee Details saved sucessfully"; 
	public By confirmationMessage = By.xpath("//font[text()='Employee Details saved sucessfully']");
	public String confrmationMessageRGBValue = "rgb(0, 128, 0)";
	
	

	
	public void enterUserName(Object Username, int waitInSecs)
	{
		sendKeys(username, Username.toString(), waitInSecs , "Employee UserName");
	}
	
	public void enterFirstName(Object FirstName, int WaitInSecs)
	{
		sendKeys(firstName, FirstName.toString(), WaitInSecs, "First Name");
	}
	
	public void enterLastName(Object LastName, int WaitInSecs)
	{
		sendKeys(lastName, LastName.toString(), WaitInSecs, "Last Name");
	}
	

	public void enterPassword(Object Password, int WaitInSecs)
	{
		sendKeys(password, Password.toString(), WaitInSecs, "Password");
	}
	

	public void enterConfirmationPwd(Object ConfirmationPassword, int WaitInSecs)
	{
		sendKeys(confirmPassword, ConfirmationPassword.toString(), WaitInSecs, "Confirm Password");
	}
	

	public void enterDateOfJoining(Object DateOfJoining, int WaitInSecs)
	{
		sendKeys(dateOfJoining, DateOfJoining.toString(), WaitInSecs, "Date of Joining");
	}
	

	public void enterRatePerHr(Object ratePerHr, int WaitInSecs)
	{
		sendKeys(ratePerHour, ratePerHr.toString(), WaitInSecs, "Rate per Hour");
	}
	
	public void enterOfficeNO(Object ofcNo, int WaitInSecs)
	{
		sendKeys(offNo, ofcNo.toString(), WaitInSecs, "Office Number");
	}
	
	public void enterMobileNO(Object mobilNO, int WaitInSecs)
	{
		sendKeys(mobNo, mobilNO.toString(), WaitInSecs, "Mobile NO");
	}
	
	public void enterEmailId(Object email, int WaitInSecs)
	{
		sendKeys(emailID, email.toString(), WaitInSecs, "Email Id");
	}
	
	public void enterAddressOne(Object AddressOne, int WaitInSecs)
	{
		sendKeys(addressOne, AddressOne.toString(), WaitInSecs, "Address 1");
	}
	
	public void enterAddressTwo(Object AddressTwo, int WaitInSecs)
	{
		sendKeys(addressTwo, AddressTwo.toString(), WaitInSecs, "Address 2");
	}
	
	public void enterCountry(Object Country, int WaitInSecs)
	{
		dropDown(country, Country.toString(), WaitInSecs, "Country");
	}
	
	public void enterAreaOfInterest(Object areaOfInt, int WaitInSecs)
	{
		sendKeys(areaOfInterest, areaOfInt.toString(), WaitInSecs, "Area of Interest");
	}
	
	public void clickOnSaveDetails(int WaitInSecs)
	{
		clickElement(saveDetails, WaitInSecs,"Save Details button");
	}
	
	public void validateConfirmationText()
	{
		validateText(confirmationMessage, confirmationMessagetxt, "Employee Registration");
	}
	
	public void validateConfirmationTextColor()
	{
		validateTextColor(confirmationMessage, confrmationMessageRGBValue," Confimation Message");
	}
	
	

}
