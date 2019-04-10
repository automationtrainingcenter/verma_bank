package in.srssprojects.keximbank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BankHomePage {
	WebDriver driver;

	// username it will locate username field in bank home page
	public WebElement username() {
		return driver.findElement(By.id("txtuId"));
	}

	// password
	public WebElement password() {
		return driver.findElement(By.id("txtPword"));
	}

	// login
	public WebElement login() {
		return driver.findElement(By.id("login"));
	}

	public BankHomePage(WebDriver driver) {
		this.driver = driver;
	}

	// fill username
	public void setUserName(String username) {
		this.username().sendKeys(username);
	}

	// fill password
	public void setPassword(String password) {
		this.password().sendKeys(password);
	}

	// click login button
	public void clickLogin() {
		this.login().click();
	}

}
