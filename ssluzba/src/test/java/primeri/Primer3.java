package primeri;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Primer3 {
	public static void main(String[] args) throws InterruptedException {
		// Instanciramo pretraživač
		// u ovom slučaju to je Firefox
//		System.setProperty("webdriver.gecko.driver", "geckodriver");
		WebDriver driver = new FirefoxDriver();
		// Podešavanje Implicit wait da čeka 10 sekundi
		// pre nego što baci izuzetak
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("http://www.calculator.net/mortgage-payoff-calculator.html");
		driver.manage().window().maximize();
		// Klik na Radio Button
//		driver.findElement(By.id("cpayoff1")).click();
		// Stampamo informacije o Radio Button-u
		System.out.println("The Output of the IsSelected " + driver.findElement(By.id("cpayoff1")).isSelected());
		System.out.println("The Output of the IsEnabled " + driver.findElement(By.id("cpayoff1")).isEnabled());
		System.out.println("The Output of the IsDisplayed " + driver.findElement(By.id("cpayoff1")).isDisplayed());
		driver.quit();
	}
}
