package primeri23;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import rs.ac.uns.testdevelopment.ssluzba.pages.HomePage;
import rs.ac.uns.testdevelopment.ssluzba.pages.LoginPage;
import rs.ac.uns.testdevelopment.ssluzba.pages.MenuPage;

public class LoginTestPage extends BaseTest {
	//private WebDriver browser;
	private LoginPage loginPage;
	private MenuPage menuPage;
	private HomePage homePage;
	
	@BeforeSuite
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
		browser.navigate().to("localhost:8080/#/");
		loginPage = new LoginPage(browser);
		menuPage = new MenuPage(browser);
		homePage = new HomePage(browser);
	}
	
	@Test
	public void login() throws InterruptedException {
		//click to account menu 
		menuPage.getAccountMenu().click();
		WebElement signIn = menuPage.getSignUp();
		assertTrue(signIn.isDisplayed());
		
		signIn.click(); //go to login page
		//assertEquals("http://localhost:8080/#/login", browser.getCurrentUrl());
		
		//check elements visibility
		assertEquals(loginPage.getUsername().isDisplayed(), true);
		assertEquals(loginPage.getUsername().isDisplayed(), true);
		assertEquals(loginPage.getSignInBtn().isDisplayed(), true);
		
		loginPage.login("admin", "admin");
		
		//get login message
		String expectedMessage = "You are logged in as user \"admin\".";
		//check login message
		assertEquals(expectedMessage, homePage.getLoginConfirmationText());
		
	}
	
	@AfterSuite
	public void closeSelenium() {
		// Shutdown the browser
		browser.quit();
	}
	
	
}
