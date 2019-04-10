package in.srssprojects.keximbank;
/*
 * This class implementing in PageFactory
 * PageFactory is a inbuilt class in Selenium to implement page object model
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AdminHomePage {
	private WebDriver driver;

	// home
	@FindBy(css = "a[href='adminflow.aspx']")
	private WebElement home;

	// logout
	@FindBy(how = How.CSS, using = "a[href='home.aspx']")
	private WebElement logout;

	// branches
	@FindBy(how = How.CSS, using = "a[href='admin_banker_master.aspx']")
	private WebElement branches;

	// roles
	@FindBy(how = How.CSS, using = "a[href='Admin_Roles_details.aspx']")
	private WebElement roles;

	// employee
	@FindBy(how = How.CSS, using = "a[href='Admin_Emp_details.aspx']")
	private WebElement employee;

	public AdminHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// click on home
	public AdminHomePage clickHome() {
		this.home.click();
		return PageFactory.initElements(driver, AdminHomePage.class);
	}

	// click on branches
	public BranchDetailsPage clickBranches() {
		this.branches.click();
		return PageFactory.initElements(driver, BranchDetailsPage.class);
	}

	// click on roles
	public RoleDetailsPage clickRoles() {
		this.roles.click();
		return PageFactory.initElements(driver, RoleDetailsPage.class);
	}

	// click on employee
	public EmployeeDetailsPage clickEmployee() {
		this.employee.click();
		return PageFactory.initElements(driver, EmployeeDetailsPage.class);
	}

	// click on logout
	public BankHomePage clickLogout() {
		this.logout.click();
		return PageFactory.initElements(driver, BankHomePage.class);
	}

}
