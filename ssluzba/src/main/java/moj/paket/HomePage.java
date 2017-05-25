package moj.paket;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	private WebDriver driver;
	
	public HomePage (WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getHome() {
		return driver.findElement(By.xpath("//a[@ui-sref='home']"));
	}
	
	public WebElement getAccount() {
		return driver.findElement(By.id("account-menu"));
	}
	
	public WebElement getSignIn() {
		return driver.findElement(By.xpath("//a[@ui-sref='login']"));
	}
	
	public WebElement getMessage() {
		return driver.findElement(By.xpath("//div [@translate = 'global.messages.info.authenticated']"));
	}

}
