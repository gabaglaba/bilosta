package primeri;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Primer2 {
	public static void main(String[] args) throws InterruptedException {
		// Instanciramo pretraživač
		// u ovom slučaju to je Firefox
		//System.setProperty("webdriver.gecko.driver", "geckodriver");
		WebDriver driver = new FirefoxDriver();
		// Podešavanje Implicit wait da čeka 10 sekundi
		// pre nego što baci izuzetak
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// otvorimo web sajt
		driver.navigate().to("http://www.calculator.net/");
		// maximizujemo pretaživač
		driver.manage().window().maximize();
		// Click na Percent Calculators
		driver.findElement(By.xpath("//*[@id=\"hl3\"]/li[3]/a")).click();
		// Unosimo vrednost 10 u prvo input polje
		driver.findElement(By.id("cpar1")).sendKeys("10");
		Thread.sleep(5000);
		// Pokupimo vrednost value atributa input elementa
		String result = driver.findElement(By.id("cpar1")).getAttribute("value");
		// Stampamo vrednost atributa
		System.out.println(" The Result is " + result);
		// Gasimio pretrazivac
		driver.quit();
	}
}
