package primeri23;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import rs.ac.uns.testdevelopment.ssluzba.pages.MenuPage;

public class LogoutTest extends BaseTest{
	private MenuPage menuPage;
	@BeforeMethod
	public void setupSelenium() {		
		menuPage = new MenuPage(browser);
	}
	@Test
	public void logout() throws InterruptedException {
		menuPage.getAccountMenu().click();
		menuPage.getLogOut().click();
	}

}
