package rs.ac.uns.testdevelopment.ssluzba;

import static org.testng.AssertJUnit.*;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test
public class AddStudentTest {
	private WebDriver browser;
	
	@BeforeMethod
	public void setupSelenium() {
		//instanciranje browsera
		browser = new FirefoxDriver();
		//implicitno vreme cekanja za pronalazenje elemenata
		browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//maximizuje prozor
		//browser.manage().window().maximize();
		//set custom window size
		browser.manage().window().setSize(new Dimension(1024, 768));
		//navigacija na zeljenu stranicu
		browser.navigate().to("localhost:9000/#/");
	}
	
	public void login() throws InterruptedException {
		//click to account menu 
		WebElement accountMenu = browser.findElement(By.id("account-menu"));
		accountMenu.click();
		WebElement signIn = accountMenu.findElement(By.xpath("//a [@ui-sref=\"login\"]"));
		AssertJUnit.assertEquals(true, signIn.isDisplayed());
		
		signIn.click(); //go to login page
		AssertJUnit.assertEquals("http://localhost:9000/#/login", browser.getCurrentUrl());
		WebElement username = browser.findElement(By.id("username"));
		WebElement password = browser.findElement(By.id("password"));
		WebElement btnSignIn = browser.findElement(By.xpath("//button[@translate='login.form.button']"));
		
		//check elements visibility
		AssertJUnit.assertEquals(username.isDisplayed(), true);
		AssertJUnit.assertEquals(password.isDisplayed(), true);
		AssertJUnit.assertEquals(btnSignIn.isDisplayed(), true);
		
		//set username value
		username.clear(); //delete current value
		username.sendKeys("admin"); //send new value
		
		//set password value
		password.clear();
		password.sendKeys("admin");
		
		//click signin button
		btnSignIn.click();
		
		//get login message
		String message = browser.findElement(By.xpath("//div [@translate=\"main.logged.message\"]")).getText();	
		String expectedMessage = "You are logged in as user \"admin\".";
		//check login message
		assertEquals(expectedMessage, message);
		
		browser.findElement(By.linkText("Entities")).click();
		browser.findElement(By.xpath("//a [@ui-sref=\"studenti\"]")).click();	
		WebElement createBtn = browser.findElement(By.xpath("//button [@ui-sref=\"studenti.new\"]"));
		assertTrue(createBtn.isDisplayed());
		createBtn.click();
		WebElement indeks = browser.findElement(By.name("indeks"));
		WebElement ime = browser.findElement(By.name("ime"));
		WebElement prezime = browser.findElement(By.name("prezime"));
		WebElement grad = browser.findElement(By.name("grad"));
		WebElement modal = browser.findElement(By.className("modal-footer"));
		WebElement saveBtn = modal.findElement(By.xpath("//button[@type='submit']"));
		WebElement cancelBtn = modal.findElement(By.xpath("//button[@data-dismiss='modal']"));
		indeks.clear();
		indeks.sendKeys("RA 43-2011");
		ime.clear();
		ime.sendKeys("Miroslav");
		prezime.clear();
		prezime.sendKeys("Kondic");
		grad.clear();
		grad.sendKeys("Novi Sad");
		saveBtn.click();
		Thread.sleep(2000);
		WebElement studentRow = browser.findElement(By.xpath("//*[contains(text(), 'RA 43-2011')]/../.."));
		WebElement deleteBtn = studentRow.findElement(By.className("btn-danger"));
		deleteBtn.click();
		WebElement modalDelete = browser.findElement(By.className("modal-dialog"));
		assertTrue(modalDelete.isDisplayed());
		WebElement confirmDeleteBtn = modalDelete.findElement(By.className("btn-danger"));
		confirmDeleteBtn.click();
		Thread.sleep(2000);
		
	}
	
	@AfterMethod
	public void closeSelenium() {
		// Shutdown the browser
		browser.quit();
	}
	
	
}
