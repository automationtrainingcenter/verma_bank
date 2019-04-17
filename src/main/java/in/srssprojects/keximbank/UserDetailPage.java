package in.srssprojects.keximbank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class UserDetailPage {

	WebDriver driver;

	// new Employee
	@FindBy(how = How.ID, using = "Btnuser")
	private WebElement newUser;

	// Constructor
	public UserDetailPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// click New User
	public UserCreationPage clickNewUser(String user) {
		this.newUser.click();
		return PageFactory.initElements(driver, UserCreationPage.class);
	}
}
