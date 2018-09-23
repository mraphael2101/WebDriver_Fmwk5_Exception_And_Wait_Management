package com.waits.explicit;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import com.google.common.base.Function;

public class _05_Explicit_Wait__FluentWait_Function_ReturnsBoolean 
{	
	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver = new FirefoxDriver();
		driver.get("http://toolsqa.wpengine.com/automation-practice-switch-windows/");

		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.pollingEvery(250, TimeUnit.MILLISECONDS);
		wait.withTimeout(2, TimeUnit.MINUTES);
		wait.ignoring(NoSuchElementException.class); //make sure that this exception is ignored
		/* The below function accepts a WebDriver object and 
		 * returns a Boolean primitive value */

		Function<WebDriver, Boolean> function = new Function<WebDriver, Boolean>()
		{
			/* We MUST implement the apply method ourselves. The 
			 * method accepts a WebDriver object as an argument 
			 * and will return a Boolean value */

			/* This is because of the way that we have defined the 
			 * Function (Function). First argument mentioned will 
			 * be the input argument and the second will be the 
			 * return value of the apply method */

			public Boolean apply(WebDriver arg0)
			{
				WebElement element = arg0.findElement(By.id("colorVar"));
				String color = element.getCssValue("color");
				System.out.println("The colour of the button is " + color);

				if(color.equals("rgba(255, 0, 0, 1)"))
				{
					return true;
				} 
				return false;   
			}		
		};
		wait.until(function);
		driver.quit();
	}
}