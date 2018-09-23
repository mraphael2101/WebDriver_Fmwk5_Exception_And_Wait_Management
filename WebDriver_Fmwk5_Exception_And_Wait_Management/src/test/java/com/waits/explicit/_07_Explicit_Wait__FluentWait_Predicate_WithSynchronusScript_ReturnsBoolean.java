package com.waits.explicit;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import com.google.common.base.Predicate;

public class _07_Explicit_Wait__FluentWait_Predicate_WithSynchronusScript_ReturnsBoolean
{
	public static void main(String[] args)
	{

		final WebDriver driver = new FirefoxDriver();
		driver.get("http://toolsqa.wpengine.com/automation-practice-switch-windows/");
 
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.pollingEvery(250, TimeUnit.MILLISECONDS);
		wait.withTimeout(2, TimeUnit.MINUTES);	
		
		Predicate<WebDriver> predicate = new Predicate<WebDriver>()
		{
			// 1 indicates AJAX is still active on the page, and 0 indicates that AJAX is inactive
			public boolean apply(WebDriver arg0) 
			{
				Boolean isJqueryCallDone = (Boolean)((JavascriptExecutor) driver).executeScript("return jQuery.active==0");
				System.out.println("JQuery inactive: " + isJqueryCallDone);
				
				if (!isJqueryCallDone)
				{
					System.out.println("JQuery active: " + isJqueryCallDone);
					return false;
				}
				return true;
			}
			
		};
		wait.until(predicate);
		driver.quit(); 
	}
}