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

public class RoleUpdationPage {

	private WebDriver driver;

	// roleName
	@FindBy(how = How.ID, using = "txtrNameU")
	private WebElement roleName;

	// role description
	@FindBy(how = How.ID, using = "txtrdescU")
	private WebElement roleDesc;

	// role type
	@FindBy(how = How.ID, using = "lstRtype")
	private WebElement roleType;

	// update button
	@FindBy(how = How.ID, using = "btnupdate")
	private WebElement update;

	// cancel button
	@FindBy(how = How.ID, using = "Btncancel")
	private WebElement cancel;

	public RoleUpdationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// fill roleName
	public void setRoleName(String roleName) {
		this.roleName.sendKeys(roleName);
	}

	// fill role description
	public void setRoleDesc(String roleDesc) {
		this.roleDesc.sendKeys(roleDesc);
	}

	// select roleType
	public void selectRoleType(String roleType) {
		new Select(this.roleType).selectByVisibleText(roleType);
	}

	// click update button
	public Alert clickUpdate() {
		this.update.click();
		return driver.switchTo().alert();
	}

	// click cancel button
	public RoleDetailsPage clickCancel() {
		this.cancel.click();
		return PageFactory.initElements(driver, RoleDetailsPage.class);
	}
}
