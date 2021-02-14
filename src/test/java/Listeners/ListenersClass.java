package Listeners;
 
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import BasePackage.BaseClass;
import Utilities.CaptureImage; 

public class ListenersClass extends BaseClass implements ITestListener 
{

	public void onTestStart(ITestResult result)
	{
		test = extent.createTest(result.getMethod().getMethodName() ); 
		test.info(MarkupHelper.createLabel(result.getMethod().getMethodName() + " Test Started", ExtentColor.BLUE));
	}
	
	public void onTestFailure(ITestResult result)
	{
		
		CaptureImage img = new CaptureImage();
		try 
		{
			img.CaptureScreenShot(driver, "error.jpg");
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		 
		
		test.log(Status.FAIL, "Test case failed, Screenshot attatched to report.  "+test.addScreenCaptureFromPath(System.getProperty("user.dir")+"\\ScreenShots\\"+"error.jpg"));
		test.fail(MarkupHelper.createLabel(result.getMethod().getMethodName() +"Case Failed", ExtentColor.RED));
		test.fail(result.getThrowable());
	

	}
	
	
	public void onTestSuccess(ITestResult result)
	{
		 
		test.pass(MarkupHelper.createLabel(result.getMethod().getMethodName() +"Test Passed", ExtentColor.GREEN));
	}
	
	 
	
}
