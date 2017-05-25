package primeri23;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Primer1 {
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		CalculatorPercentagePage percentagePage = new CalculatorPercentagePage(driver);
		// Puts an Implicit wait, Will wait for 10 seconds
		// before throwing exception
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Launch website
		driver.navigate().to("http://www.calculator.net/percent-calculator.html");
		// Maximize the browser
		driver.manage().window().maximize();		
		// Enter value 10 in the first number of the percent Calculator
		//driver.findElement(By.id("cpar1")).sendKeys("10");
		percentagePage.setFirstNumber("10");
		// Enter value 50 in the second number of the percent Calculator
		//driver.findElement(By.id("cpar2")).sendKeys("50");
		percentagePage.setSecondNumber("50");
		// Click Calculate Button
		//driver.findElement(By.xpath(".//*[@id='content']/table[1]/tbody/tr[2]/td/input[2]")).click();
		percentagePage.getCalculateButton().click();
		// Get the Result Text based on its xpath
		//String result = driver.findElement(By.cssSelector("#content > p.verybigtext > font > b")).getText();
		String result = percentagePage.getResultText();
		// Print a Log In message to the screen
		System.out.println(" The Result is " + result);
		// Close the Browser.
		driver.close();
	}
}