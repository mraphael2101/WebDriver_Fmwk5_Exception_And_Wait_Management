package com.waits.implicit.builtintoselenium;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;

/* the amount of time Selenium will wait to execute a bit of Javascript */

public class _02_Implicit_Wait__ExecuteAsynchronusScript_Timeout 
{
	public static void main(String[] args)
	{
		WebDriver driver; 

		driver = new FirefoxDriver(); 
		driver.get("http://google.com");

		/* SetScriptTimeout()
		 * Sets the amount of time to wait for an asynchronous script to 
		 * finish execution before throwing an error. If the timeout is 
		 * negative, then the script will be allowed to run indefinitely */
		driver.manage().timeouts().setScriptTimeout(100, TimeUnit.SECONDS);

		/*  Perform a sleep in the browser under test */
		((JavascriptExecutor) driver).executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 500);");

		long start = System.currentTimeMillis();
		System.out.println("Elapsed time: " + (System.currentTimeMillis() - start));

		driver.quit();
	}
}