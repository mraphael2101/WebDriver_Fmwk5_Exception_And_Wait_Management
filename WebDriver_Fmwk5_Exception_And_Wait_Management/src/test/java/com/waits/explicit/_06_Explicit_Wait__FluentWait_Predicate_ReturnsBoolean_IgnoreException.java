package com.waits.explicit;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import com.google.common.base.Predicate;
/* Predicates are similar to functions, but you only need to 
 * supply them with an input. The output of a predicate will 
 * always be a Boolean */

public class _06_Explicit_Wait__FluentWait_Predicate_ReturnsBoolean_IgnoreException
{
	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver = new FirefoxDriver();
		driver.get("http://toolsqa.wpengine.com/automation-practice-switch-windows/");

		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.pollingEvery(250,  TimeUnit.MILLISECONDS);
		wait.withTimeout(2, TimeUnit.MINUTES);
		wait.ignoring(NoSuchElementException.class); // ignore this exception

	
		Predicate<WebDriver> predicate = new Predicate<WebDriver>()
		{
			public boolean apply(WebDriver arg0) 
			{	
				WebElement element = arg0.findElement(By.id("colorVar"));
				String color = element.getCssValue("color");
				System.out.println("The colour of the button is " + color);
				
				if(color.equals("rgba(255, 0, 0, 1)")) { return true; } 
				
				return false;   
			}		
		};
		wait.until(predicate);
		driver.quit();
	}
}