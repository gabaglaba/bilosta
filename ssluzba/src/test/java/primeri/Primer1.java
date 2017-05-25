package primeri;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

/*
 * Primer 1 
 * Java kod primera CalculatorTest dobijen
 * pomocu SeleniumIDE plugin-a
 * 
 * Klasa Primer1 sadrzi main metodu tako da moze zasebno da se pokrene
 */
public class Primer1 {
	public static void main(String[] args) {
		// Instanciramo pretraživač
		// u ovom slučaju to je Firefox
		// Od verzije 3.0.0 Selenium webDriver zahteva putanju do
		// Mozilla Firefox geckodrivera
		// 2.53 vezija ne radi sa novijim verzijama Firefox-a
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
		// Unosimo vrednost 50 u drugo input polje
		driver.findElement(By.id("cpar2")).sendKeys("50");
		// Kliknemo na Calculate Button
		driver.findElement(By.xpath(".//*[@id='content']/table[1]/tbody/tr[2]/td/input[2]")).click();
		// Pokupimo rezultat pomocu css selektora
		String result = driver.findElement(By.cssSelector("#content > p.verybigtext > font > b")).getText();
		// Štampamo rezultat u Java konzoli
		System.out.println(" The Result is " + result);
		// Gasimo browser
		driver.quit();
	}
}