package AllPages;

import java.io.IOException;
import org.openqa.selenium.By;
import BasePackage.BaseClass;
 

public class LoginPage   extends BaseClass
{
	public By username =   By.xpath("//input[@id='username']");
	public By password = 	By.xpath("//input[@type='password']");
	public By submit = By.xpath("//input[@type='submit']");
	public static By logOutMsg = By.xpath("//*[@id=\"logoutstatus\"]");
	public static String loggedOutMsgTxt = "You have been logged out. Thank you for using Timesheet.";
	
	

	public void testUserLogin(Object uname, Object pwd, int waitInSecs) throws IOException
	{
		sendKeys( username, uname.toString(), waitInSecs ,  "Username");
		sendKeys( password, pwd.toString(), waitInSecs,	"Password");
		clickElement( submit, waitInSecs , " Submit Button");
		validateText(HomePage.welcomeMessage, HomePage.welcomeMessageTxt, " User Login");
		
	}
	
	
}
