package com.waits.explicit;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;

import com.google.common.base.Function;

public class _04_Explicit_Wait__FluentWait_Function_ReturnsWebElement_IgnoreException 
{
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://toolsqa.wpengine.com/automation-practice-switch-windows/");
 
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.pollingEvery(250, TimeUnit.MILLISECONDS);
		wait.withTimeout(2, TimeUnit.MINUTES);
		wait.ignoring(NoSuchElementException.class); 		// Make sure that this exception is ignored

	
		/* What we are saying is that we are going to create a Function 
		 * element named function. We are going to supply this. Function 
		 * with an object of WebDriver as the input and we will get an 
		 * object of WebElement returned to us as the output. All functions 
		 * need to have a single method called apply, which takes an input 
		 * (in this case, a WebDriver object) and returns an output (in this 
		 * case, a WebElement object) */

		Function<WebDriver, WebElement> function = new Function<WebDriver, WebElement>(){
			/* The advantage of using a Function element is that you can 
			 * pass in an object of any type as the input and return an 
			 * object of any type as the output. This gives you a huge amount 
			 * of flexibility with your waits as you can return all sorts of 
			 * useful objects when your waiting criteria has been met */

			public WebElement apply(WebDriver arg0)
			{
				System.out.println("Checking for the element!!");
				WebElement element = arg0.findElement(By.id("target"));
				
				if(element != null)
				{
					System.out.println("Target element found");
				}		
				return element;
			}
		};
		wait.until(function);
		driver.quit();
	}
}