package moj.paket;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	private WebDriver driver;
	
	public LoginPage (WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getUsername() {
		return driver.findElement(By.id("username"));
	}
	
	public void setUsername(String username) {
		WebElement usernameInput = getUsername();
		usernameInput.clear();
		usernameInput.sendKeys(username);
	}
	
	public WebElement getPassword() {
		return driver.findElement(By.id("password"));
	}
	
	public WebElement getSignInBtn() {
		return driver.findElement(By.xpath("//button[@translate='login.form.button']"));
	}
	
	public void setPassword(String password) {
		WebElement passwordInput = getPassword();
		passwordInput.clear();
		passwordInput.sendKeys(password);
	}
	
	public void navigateToPage(){
		driver.navigate().to("localhost:9000/#/login");
	}
	
	public void login(String username, String password) {
		setUsername(username);
		setPassword(password);
		getSignInBtn().click();
	}
	
	public String getLoginMessage() {
		return driver.findElement(By.xpath("//div[@transalte='login.messages.error.authentication']")).getText();
		
	}
	
}

