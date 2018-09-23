package com.waits.explicit;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.By;
import com.google.common.base.Function;

/* FluentWait instance defines the maximum amount of time to wait 
 * for a condition, as well as the frequency with which to check 
 * the condition. Furthermore, the user may configure the wait 
 * to ignore specific types of exceptions whilst waiting, such 
 * as NoSuchElementExceptions when searching for an element on 
 * the page */

public class _03_Explicit_Wait__FluentWait_Function_ReturnsWebElement 
{
	public static void main(String[] args)
	{
		WebDriver driver; 
		driver = new FirefoxDriver(); 
		driver.get("http://jquery.com");

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)

				.withTimeout(10, TimeUnit.SECONDS)

				.pollingEvery(5, TimeUnit.SECONDS)

				.ignoring(NoSuchElementException.class);

		
		WebElement wE = (WebElement) wait.until(new Function<WebDriver, WebElement>() 
		{
			public WebElement apply(WebDriver driver) 
			{
				return driver.findElement(By.id("logo-events"));
			}
		});

		
		System.out.println(wE.getTagName() + " " + wE.getText()); 
		
		driver.quit();
		
	}
}
