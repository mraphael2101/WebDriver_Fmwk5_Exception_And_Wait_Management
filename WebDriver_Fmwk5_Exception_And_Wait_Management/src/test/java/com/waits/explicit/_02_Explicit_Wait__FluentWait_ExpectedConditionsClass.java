package com.waits.explicit;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

/* Fluent waits are also called smart waits as they do not wait for the 
 * max timeout specified in .withTimeout(5000, TimeUnit.MILLISECONDS) 
 * Instead it waits for the time until the condition specified in 
 * .until(YourCondition) method becomes true */

public class _02_Explicit_Wait__FluentWait_ExpectedConditionsClass 
{
	public static void main(String[] args) 
	{
		WebDriver driver;
		
		driver = new FirefoxDriver();
        driver.get("http://jquery.com");
		
		/* Declare an object that references the FluentWait class
           Use the WebDriver object in the constructor */
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		
		// Set the wait timeout to 5 seconds
		wait.withTimeout(5000, TimeUnit.MILLISECONDS);
		
		// Set the polling time
		wait.pollingEvery(250, TimeUnit.MILLISECONDS);
		
		// Specify what exceptions to ignore
		wait.ignoring(NoSuchElementException.class);
 
		// This is how we specify the condition to wait on
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("s")));
			
		driver.quit();
	}
}
/* 1) In this step FluentWait captures the 'Wait Start Time' (withTimeout(5000))
   2) FluentWait checks the condition that is mentioned in the .until() method
   3) If the condition is not TRUE, thread sleep is invoked every 250 milliseconds
   4) After thread sleep expires, a comparison is made between start time and the current time 
      If the difference is less than the time specified in withTimeout(5000) then re-invoke .until method
   5) The above process repeats until either the timeout expires or the condition becomes true */