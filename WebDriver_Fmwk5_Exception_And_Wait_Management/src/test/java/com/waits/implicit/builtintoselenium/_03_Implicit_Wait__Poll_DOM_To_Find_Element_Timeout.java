package com.waits.implicit.builtintoselenium;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/* Selenium will wait for 5 seconds before throwing an
 * exception that it cannot find the element on the page. 
 * Note that implicit waits will be in place for the entire 
 * time that the browser is open */

public class _03_Implicit_Wait__Poll_DOM_To_Find_Element_Timeout
{
	public static void main(String[] args) 
	{
		WebDriver driver; 
		
		driver = new FirefoxDriver(); 
		driver.get("http://jquery.com");
		
		/* in this case, Selenium will wait upto 15 seconds for an 
		 * element to appear in the DOM when trying to find it */
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		WebElement myDynamicElement = driver.findElement(By.id("logo-events"));
		
		System.out.println("Element found in '" + myDynamicElement.getTagName() + "' tag " 
		+ " and its text is '" + myDynamicElement.getText() + "'");
		
		driver.quit();
	}
}
