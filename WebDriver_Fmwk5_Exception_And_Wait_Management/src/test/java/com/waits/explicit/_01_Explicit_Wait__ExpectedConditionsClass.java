package com.waits.explicit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/* The ExpectedConditions class can be used to model a condition 
 * that may be expected to eventually evaluate to something that 
 * is neither null nor false. Check the ExpectedConditions class 
 * web page from Selenium */

public class _01_Explicit_Wait__ExpectedConditionsClass 
{
	public static void main(String[] args) 
	{		
		final WebDriver driver = new FirefoxDriver(); 
		driver.get("http://www.google.com");

		// Explicit wait up to 5 seconds for the searchField to become clickable
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement searchField = wait.until(ExpectedConditions.elementToBeClickable(By.name("q")));

        searchField.sendKeys("Joe Colontonio");
        searchField.submit();

        // Explicit wait up to 10 seconds to locate the below element or return true
        new WebDriverWait(driver, 10).until(new ExpectedCondition<WebElement>()
        {
            public WebElement apply(WebDriver driverObject) 
            {
                return driver.findElement(By.id("lst-ib"));
            }
        });       

		driver.quit();
	}
}