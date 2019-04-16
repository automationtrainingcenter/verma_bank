package in.srssprojects.keximbank;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/*
 * 
 * @author -- Manikanta
 */
public class UserUpdationPage {
	private WebDriver driver;

	// User Name
	@FindBy(how = How.ID, using = "txtUname")
	private WebElement userName;

	// LPass
	@FindBy(how = How.ID, using = "txtLPwd")
	private WebElement loginPass;

	// TPass
	@FindBy(how = How.ID, using = "txtTPwd")
	private WebElement txnPass;

	// Update Button
	@FindBy(how = How.ID, using = "btn_edit")
	private WebElement update;

	// Cancel Button
	@FindBy(how = How.ID, using = "Btncancel")
	private WebElement cancel;

	// Construcor
	public UserUpdationPage(WebDriver driver) {
		this.driver = driver;
	}

	// fill User Name
	public void setEmpName(String empName) {
		this.userName.sendKeys(empName);
	}

	// fill login Password
	public void setLoginPassword(String passwd) {
		this.loginPass.sendKeys(passwd);
	}

	// fill transaction Password
	public void setTxnPassword(String passwd) {
		this.txnPass.sendKeys(passwd);
	}

	// click update Button
	public Alert updateButton() {
		this.update.click();
		return driver.switchTo().alert();
	}

	// click cancel Button
	public UserDetailPage cancelButton() {
		this.cancel.click();
		return PageFactory.initElements(driver, UserDetailPage.class);

	}
}
