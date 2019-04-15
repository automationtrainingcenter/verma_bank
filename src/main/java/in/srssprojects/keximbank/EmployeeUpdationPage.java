package in.srssprojects.keximbank;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/*
 * 
 * @author -- Manikanta
 */
public class EmployeeUpdationPage {
	private WebDriver driver;

	// Employee Name
	@FindBy(how = How.ID, using = "")
	private WebElement empName;

	// Login Password
	@FindBy(how = How.ID, using = "")
	private WebElement logPass;

	// role
	@FindBy(how = How.ID, using = "")
	private WebElement role;

	// branch
	@FindBy(how = How.ID, using = "")
	private WebElement branch;

	// update button
	@FindBy(how = How.ID, using = "")
	private WebElement updateButton;

	// CancelButton
	@FindBy(how = How.ID, using = "")
	private WebElement cancelButton;

	public EmployeeUpdationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// fill Employee Name
	public void setEmpName(String empName) {
		this.empName.sendKeys(empName);
	}

	// fill login Password
	public void setPassword(String passwd) {
		this.logPass.sendKeys(passwd);
	}

	// select role
	public void setRole(String role) {
		new Select(this.role).selectByVisibleText(role);
	}

	// select branch
	public void setBranch(String branch) {
		new Select(this.branch).selectByVisibleText(branch);
	}

	// click update Button
	public Alert updateButton() {
		this.updateButton.click();
		return driver.switchTo().alert();
	}

	public EmployeeDetailsPage cancelButton() {
		this.cancelButton.click();
		return PageFactory.initElements(driver, EmployeeDetailsPage.class);

	}

}
