package moj.test.paket;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import moj.paket.HomePage;
import moj.paket.LoginPage;

public class LoginTest {
	
	private WebDriver driver;
	private HomePage homePage;
	private LoginPage loginPage;
	
		
		@BeforeMethod
		public void setupSelenium() {
			
			loginPage = new LoginPage(driver);
			homePage = new HomePage(driver);
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.navigate().to("localhost:8080/#/");
		}
		
		@Test
		public void testLoginWrongUsername() {
			
			
			assertTrue(homePage.getMessage().isDisplayed());
			homePage.getAccount().click();
			homePage.getSignIn().click();
			
			assertTrue(loginPage.getUsername().isDisplayed());
			assertTrue(loginPage.getPassword().isDisplayed());
			assertTrue(loginPage.getSignInBtn().isEnabled());
			
			loginPage.getUsername().clear();
			loginPage.getUsername().sendKeys("pera");
			loginPage.getPassword().clear();
			loginPage.getPassword().sendKeys("admin");
			loginPage.getSignInBtn().click();
			
			assertTrue(loginPage.getLoginMessage().equals("Failed to sign in!"));
			
			
			
		}

		@AfterMethod
		public void closeSelenium() {
			// Shutdown the browser
			driver.quit();
		}
}
