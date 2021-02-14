package Utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Hightlight 
{
	public void hightlightElement(WebElement ele, WebDriver driver) throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;   
		js.executeScript("arguments[0].setAttribute('style','background: yello; border: 2px solid blue;');", ele); 
	}

}
