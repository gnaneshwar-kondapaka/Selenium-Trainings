package Utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
 

public class CaptureImage {

	 
	public void CaptureScreenShot(WebDriver driver,String FileName) throws IOException
	{
		TakesScreenshot scrShot = ((TakesScreenshot)driver);
		File f = scrShot.getScreenshotAs(OutputType.FILE);
		Date d = new Date();
		String dat = d.toString().substring(4, 19).replace(" ", "_").replace(":", "_");
		FileUtils.copyFile(f, new File(System.getProperty("user.dir")+"\\ScreenShots\\"+FileName));
		 
	  
	}
		

}
