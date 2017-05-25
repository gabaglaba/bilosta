package primeri;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Primer4 {
	public static void main(String[] args) throws InterruptedException {
		// Instanciramo pretraživač
		// u ovom slučaju to je Firefox
//		System.setProperty("webdriver.gecko.driver", "geckodriver");
		WebDriver driver = new FirefoxDriver();
		// Podešavanje Implicit wait da čeka 10 sekundi
		// pre nego što baci izuzetak
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("http://www.calculator.net/mortgage-calculator.html");
		driver.manage().window().maximize();
		// Klik na checkbox
		driver.findElement(By.id("caddoptional")).click();
		System.out.println("The Output of the IsSelected " + driver.findElement(By.id("caddoptional")).isSelected());
		System.out.println("The Output of the IsEnabled " + driver.findElement(By.id("caddoptional")).isEnabled());
		System.out.println("The Output of the IsDisplayed " + driver.findElement(By.id("caddoptional")).isDisplayed());
		driver.quit();
	}
}
