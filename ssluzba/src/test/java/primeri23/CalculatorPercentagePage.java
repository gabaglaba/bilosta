package primeri23;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CalculatorPercentagePage {
	private WebDriver driver;

	public CalculatorPercentagePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getFirstNumber(){
		return driver.findElement(By.id("cpar1"));
	}
	public void setFirstNumber(String value) {
		WebElement first = this.getFirstNumber();
		first.clear();
		first.sendKeys(value);
	}
	
	public WebElement getSecondNumber(){
		return driver.findElement(By.id("cpar2"));
	}
	public void setSecondNumber(String value) {
		WebElement second = this.getSecondNumber();
		second.clear();
		second.sendKeys(value);
	}
	public WebElement getCalculateButton(){
		return driver.findElement(By.xpath(".//*[@id='content']/table[1]/tbody/tr[2]/td/input[2]"));
	}
	
	public String getResultText() {
		return driver.findElement(By.cssSelector("#content > p.verybigtext > font > b")).getText();
	}
	
	public void calculate(String first, String second){
		setFirstNumber(first);
		setSecondNumber(second);
		getCalculateButton().click();
	}

}
