package primeri;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Primer5 {
	public static void main(String[] args) throws InterruptedException {
		// Instanciramo pretraživač
		// u ovom slučaju to je Firefox
//		System.setProperty("webdriver.gecko.driver", "geckodriver");
		WebDriver driver = new FirefoxDriver();
		// Podešavanje Implicit wait da čeka 10 sekundi
		// pre nego što baci izuzetak
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("http://www.calculator.net/interest-calculator.html");
		driver.manage().window().maximize();
		// Selekcija elementa iz Drop Down liste
		WebElement test = driver.findElement(By.id("ccompound"));
		test.findElement(By.xpath("./option[@value=\"daily\"]")).click();
		Thread.sleep(2000);
//		Select dropdown = new Select(test);
//		dropdown.selectByValue("daily");
		// you can also use dropdown.selectByIndex(1) to
		// select second element as index starts with 0.
		// You can also use dropdown.selectByValue("annually");
		System.out.println("The Output of the IsSelected " + driver.findElement(By.id("ccompound")).isSelected());
		System.out.println("The Output of the IsEnabled " + driver.findElement(By.id("ccompound")).isEnabled());
		System.out.println("The Output of the IsDisplayed " + driver.findElement(By.id("ccompound")).isDisplayed());
		driver.quit();
	}
}
