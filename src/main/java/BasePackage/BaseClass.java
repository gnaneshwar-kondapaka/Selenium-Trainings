package BasePackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.apache.commons.math3.analysis.function.Constant;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.beust.jcommander.Parameter;

import AllPages.EmployeeRegistration;
import AllPages.LoginPage;
import bsh.org.objectweb.asm.Constants;
import ConstantsPackage.*;

 

public class BaseClass 
{
	
	public static WebDriver driver = null;
	public static WebDriverWait wait = null;
	public static ExtentReports extent = null;
	public static ExtentSparkReporter report = null;
	public static ExtentTest test = null;
	public static Alert alert = null;
	public ConstantsPackage.Constants c = null;
	@BeforeSuite
	public void lauchBrowser() throws IOException
	{ 
		String browser = ConstantsPackage.Constants.browser;
		 
		if(browser.equals("chrome"))
		{ 
			System.setProperty("webdriver.chrome.driver", ConstantsPackage.Constants.userDirectory+ ConstantsPackage.Constants.chromeDriverPath);
			driver = new ChromeDriver(); 
		}
		else if(browser.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", ConstantsPackage.Constants.userDirectory+ConstantsPackage.Constants.firefoxDriverPath);
			driver = new FirefoxDriver();
		}
		else if(browser.equals("internetexplorer"))
		{
			System.setProperty("webdriver.ie.driver", ConstantsPackage.Constants.userDirectory+ConstantsPackage.Constants.internetExplorerDriverPath);
			driver = new InternetExplorerDriver();
		}
		else
		{
			 Assert.fail();
		}
		
		//Configuring Extent Reports
		driver.manage().timeouts().implicitlyWait(c.s_time, TimeUnit.SECONDS);
		extentReportConfiguration();
		driver.manage().timeouts().implicitlyWait(ConstantsPackage.Constants.s_time, TimeUnit.SECONDS);
		
	}
 
	
	public void extentReportConfiguration()
	{
		extent = new ExtentReports();
		report =  new ExtentSparkReporter( ConstantsPackage.Constants.userDirectory+ConstantsPackage.Constants.extentReportPath);
		extent.attachReporter(report);
		extent.setSystemInfo(ConstantsPackage.Constants.resourceType, ConstantsPackage.Constants.resourceName);
		extent.setSystemInfo(ConstantsPackage.Constants.org, ConstantsPackage.Constants.orgName); 
	}
	
	
	 public void navigateToUrl(String url, String Title)
	{
		 driver.get(url);
		 Assert.assertEquals(driver.getTitle(), Title,"Navigated to Incorrect Page");
		 test.pass(" Navigated Successfully to webpage"+" Page Title : "+Title);
	}
	 
	public void clickElement(By by, int timeInSecs)
	{
		try
		{
			wait = new WebDriverWait(driver, timeInSecs);
			wait.until(ExpectedConditions.elementToBeClickable(by));
			driver.findElement(by).click();  
		}catch(Exception e)
		{
			test.fail(MarkupHelper.createLabel("Unable to click on element", ExtentColor.RED));
			Assert.fail();
		}
		
	}
	
	public void clickElement(By by, int timeInSecs, String Comments)
	{
		
		try
		{
			wait = new WebDriverWait(driver, timeInSecs);
			wait.until(ExpectedConditions.elementToBeClickable(by));
			driver.findElement(by).click();  
			test.info("Clicked on "+ Comments); 
		}catch(Exception e)
		{
			test.fail(MarkupHelper.createLabel("Unable to click on element"+by, ExtentColor.RED));
			Assert.fail();
		}
		
		
	}
	
	public void sendKeys(By by, String value , int timeInSecs,String Description)
	{
		
		try 
		{
			wait = new WebDriverWait(driver, timeInSecs);
			wait.until(ExpectedConditions.elementToBeClickable(by));
			driver.findElement(by).sendKeys(value); 
			test.info("Entered Value : \""+value+"\" in "+Description + " field");
		}catch(Exception e)
		{
			test.fail(MarkupHelper.createLabel("Unable to Enter Value : "+value+" in Field "+Description, ExtentColor.RED));
			Assert.fail();
		}
		
		 
	}
	 
	
	
	public void dropDown(By by, String visibleText , int timeInSecs,String Description)
	{
		try
		{
			wait = new WebDriverWait(driver, timeInSecs);
			wait.until(ExpectedConditions.elementToBeClickable(by));
			WebElement element = driver.findElement(by); 
			Select s = new Select(element);
			s.selectByVisibleText(visibleText);
			test.info("Selected  \""+visibleText+"\" from the dropdown for "+Description + " field");
		}catch(Exception e)
		{
			test.fail(MarkupHelper.createLabel("Unable to Select Value : "+visibleText+" from dropdown "+Description, ExtentColor.RED));
			Assert.fail();
		}
		
		 
	}
	
	
	public void changeWindowFocus(int count)
	{
		try 
		{
			Set<String> windows = driver.getWindowHandles();
			Iterator<String> itr = windows.iterator();
			
			for(int i = 0; i<count-1; i++)
			{
				itr.next();
			}
			driver.switchTo().window(itr.next());
		}
		catch (Exception e)
		{
			test.fail(MarkupHelper.createLabel("Unable to Switch Window focus " , ExtentColor.RED));
			Assert.fail();
		}
		
	}
	
	
	public boolean findElementPresence(By by, int timeInSecs)
	{
		wait = new WebDriverWait(driver, timeInSecs);
		wait.until(ExpectedConditions.elementToBeClickable(by));
		
		try
		{
			driver.findElement(by);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	
	public void handleAlerts(String Message, String comments)
	{
		try 
		{  
			 alert = driver.switchTo().alert();
			 if(alert.getText().equals(Message))
			 {
				 alert.accept();
				 test.pass(comments + " Successful !!");
			 }
			 else
			 {
				 alert.dismiss();
				 test.fail("Alert Message Not Matching");
				 Assert.fail("Alert Message Not Matching");
			 }
			
		}catch(Exception e)
		{
			Assert.fail("Error occured : "+e);
		}
		
			
		 
		
	}

	
	public void validateText(By by,  String ExpectedMessage, String comments)
	{
		try 
		{
			String acutalMesage = driver.findElement(by).getText();
			Assert.assertEquals(acutalMesage, ExpectedMessage, comments +" Failed ");
			test.pass(MarkupHelper.createLabel(comments+" completed Successfully !", ExtentColor.GREEN));
		}
		catch(Exception e)
		{
			test.fail(MarkupHelper.createLabel(comments+" Failed", ExtentColor.RED));
			Assert.fail("Text not Matching");
		}
		
	}
	
	public void  validateTextColor(By by, String exptecteColorRGB, String comments)
	{
		try
		{
			String borderColor = driver.findElement(by).getCssValue("color");
			Assert.assertEquals(Color.fromString(borderColor).asHex(), Color.fromString(exptecteColorRGB).asHex(), comments +" is not as excepted");
			test.pass(comments+" is as expected");
			
		}catch(Exception e)
		{
			test.fail(MarkupHelper.createLabel(comments+" Color Not Matched", ExtentColor.RED));
			Assert.fail("Color Not Matching");
		}
		
	}
	
	 
	
	@AfterSuite
	public void tearUP() throws InterruptedException
	{
		extent.flush();
		driver.quit();
	}

	 

}
