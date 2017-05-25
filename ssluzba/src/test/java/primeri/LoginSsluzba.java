package primeri;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class LoginSsluzba {
	
	public Boolean isPresent(WebDriver driver, By lokator) {
		try {
			driver.findElement(lokator);
			
		} catch(NoSuchElementException e){
			return false;
		}
		
		return true;
		
		
	}

	public static void main(String[] args) throws InterruptedException {
		LoginSsluzba objekat = new LoginSsluzba();
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("http://localhost:8080/#/");
		driver.findElement(By.id("account-menu")).click();
		driver.findElement(By.partialLinkText("Sign in")).click();
		
		WebElement username = driver.findElement(By.id("username"));
		System.out.println("isPresent username: " + objekat.isPresent(driver, By.id("usersdasdname")));
		WebElement password = driver.findElement(By.id("password"));
		WebElement btnSignIn = driver.findElement(By.xpath("//button[@translate='login.form.button']"));
		//set username value
		username.clear(); //delete current value
		username.sendKeys("admin"); //send new value
		//set password value
		password.clear();
		password.sendKeys("admin");
		//click signin button
		btnSignIn.click();
		//get login message
		String message = driver.findElement(By.xpath("//div [@translate=\"main.logged.message\"]")).getText();	
		String expectedMessage = "You are logged in as user \"admin\".";
		System.out.println("Welcome message is: " + message);
		//check login message
		Thread.sleep(3000);
		driver.quit();

	}

}
