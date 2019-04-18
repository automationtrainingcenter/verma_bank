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
	@FindBy(how = How.ID, using = "txtBnameU")
	private WebElement empName;

	// Login Password
	@FindBy(how = How.ID, using = "txtPwdU")
	private WebElement logPass;

	// role
	@FindBy(how = How.ID, using = "lstrolesU")
	private WebElement role;

	// branch
	@FindBy(how = How.ID, using = "lstBidU")
	private WebElement branch;

	// update button
	@FindBy(how = How.ID, using = "BtnUpdate")
	private WebElement updateButton;

	// CancelButton
	@FindBy(how = How.ID, using = "btncancelU")
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
	
	//click cancel Button
	public EmployeeDetailsPage cancelButton() {
		this.cancelButton.click();
		return PageFactory.initElements(driver, EmployeeDetailsPage.class);

	}

}
