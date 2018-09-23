package com.waits.implicit.builtintoselenium;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

/* TimeOutException is thrown because the page does 
 * not load within a second */

public class _01_Implicit_Wait__PageLoad_Timeout 
{

	public static void main(String[] args) 
	{
		WebDriver driver; 
		
		driver = new FirefoxDriver(); 
		
		// Defines the amount of time Selenium will wait for the page to load
		driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.SECONDS);
		
		driver.get("http://www.google.com"); 
	}

}
