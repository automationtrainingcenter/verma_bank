package in.srssprojects.keximbank;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/*
 * @author -- Manikanta
 */

public class UserCreationPage {

	private WebDriver driver;

	// Role
	@FindBy(how = How.ID, using = "lst_Roles")
	private WebElement role;

	// branch
	@FindBy(how = How.ID, using = "lst_Branch")
	private WebElement branch;

	// customer ID
	@FindBy(how = How.ID, using = "DrCName")
	private WebElement custId;

	// customer Name
	@FindBy(how = How.ID, using = "Lbc_name")
	private WebElement custName;

	// User Name
	@FindBy(how = How.ID, using = "txtUname")
	private WebElement userName;

	// Login Password
	@FindBy(how = How.ID, using = "txtLpwd")
	private WebElement loginPass;

	// Transaction password
	@FindBy(how = How.ID, using = "txtTpwd")
	private WebElement txnPass;

	// submit Button
	@FindBy(how = How.ID, using = "BtnSubmit")
	private WebElement submit;

	// reset Button
	@FindBy(how = How.ID, using = "btnreset")
	private WebElement reset;

	// cancel Button
	@FindBy(how = How.ID, using = "btnCancel")
	private WebElement cancel;

	// Constructor
	public void UserUpdationPage(WebDriver driver) {
		this.driver = driver;
	}

	// select role
	public void setRole(String roleName) {
		new Select(this.role).selectByVisibleText(roleName);
	}

	// select Branch
	public void setBranch(String branchName) {
		new Select(this.branch).selectByVisibleText(branchName);
	}

	// select Customer ID
	public void setCustomerID(String custID) {
		new Select(this.custId).selectByVisibleText(custID);
	}

	// Fill customer name
	public void setCustName(String customerName) {
		this.custName.sendKeys(customerName);
	}

	// fill User Name
	public void setUserName(String userName) {
		this.userName.sendKeys(userName);
	}

	// fill Login passowrd
	public void setLoginPass(String loginPass) {
		this.loginPass.sendKeys(loginPass);
	}

	// fill transaction password
	public void setTxnPass(String txnPass) {
		this.txnPass.sendKeys(txnPass);
	}

	// click submit Button
	public Alert submitButton() {
		this.submit.click();
		return driver.switchTo().alert();
	}

	// reset button
	public void resetButton() {
		this.reset.click();
	}

	// click cancel Button
	public UserDetailPage cancelButton() {
		this.cancel.click();
		return PageFactory.initElements(driver, UserDetailPage.class);

	}

}
