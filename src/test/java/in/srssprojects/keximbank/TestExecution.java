package in.srssprojects.keximbank;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import resources.TestData;
import utilities.BrowserHelper;

public class TestExecution extends BrowserHelper {
	String alertText;
	BankHomePage bankHomePage;
	AdminHomePage adminHomePage;
	BranchDetailsPage branchDetailsPage;
	BranchCreationPage branchCreationPage;
	RoleDetailsPage roleDetailsPage;
	RoleCreationPage roleCreationPage;
	EmployeeDetailsPage employeeDetailsPage;
	EmployeeCreaionPage employeeCreaionPage;
	Alert alert;

	@Test(priority = 0, enabled = true, groups = { "branch", "create", "role", "employee", "blank", "reset", "cancel" })
	public void login() {
		bankHomePage = new BankHomePage(driver);
		bankHomePage.setUserName(readProperty("username"));
		bankHomePage.setPassword(readProperty("password"));
		bankHomePage.clickLogin();
		adminHomePage = PageFactory.initElements(driver, AdminHomePage.class);
		Assert.assertTrue(adminHomePage.isAdminHomePageDispalyed());
	}

	@Test(priority = 1, groups = { "branch", "create" })
	public void branchCreationWithValidData() {
		branchDetailsPage = adminHomePage.clickBranches();
		branchCreationPage = branchDetailsPage.clickNewBranch();
		branchCreationPage.setBranchName(TestData.branchName);
		branchCreationPage.setAddress1(TestData.address1);
		branchCreationPage.setZipcode(TestData.zipcode);
		branchCreationPage.setCountry(TestData.country);
		branchCreationPage.setState(TestData.state);
		branchCreationPage.setCity(TestData.city);
		alert = branchCreationPage.submitButton();
		alertText = alert.getText();
		alert.accept();
		Assert.assertTrue(alertText.contains("created Sucessfully"));
	}

	@Test(priority = 2, dependsOnMethods = { "branchCreationWithValidData" }, groups = { "branch", "create" })
	public void branchCreationWithDuplicateData() {
		branchDetailsPage = adminHomePage.clickBranches();
		branchCreationPage = branchDetailsPage.clickNewBranch();
		branchCreationPage.setBranchName(TestData.branchName);
		branchCreationPage.setAddress1(TestData.address1);
		branchCreationPage.setZipcode(TestData.zipcode);
		branchCreationPage.setCountry(TestData.country);
		branchCreationPage.setState(TestData.state);
		branchCreationPage.setCity(TestData.city);
		alert = branchCreationPage.submitButton();
		alertText = alert.getText();
		alert.accept();
		Assert.assertTrue(alertText.contains("Branch name already Exist"));
	}

	@Test(priority = 3, groups = { "branch", "blank" })
	public void branchCreationWithBlankData() {
		branchDetailsPage = adminHomePage.clickBranches();
		branchCreationPage = branchDetailsPage.clickNewBranch();
		alert = branchCreationPage.submitButton();
		alertText = alert.getText();
		Reporter.log("alert came "+alertText);
		alert.accept();
		Assert.assertTrue(alertText.contains("fill in the following"));
	}

	@Test(priority = 4, groups = { "branch", "reset" })
	public void branchCreationReset() {
		branchDetailsPage = adminHomePage.clickBranches();
		branchCreationPage = branchDetailsPage.clickNewBranch();
		branchCreationPage.setBranchName(TestData.branchName);
		branchCreationPage.setAddress1(TestData.address1);
		branchCreationPage.setZipcode(TestData.zipcode);
		branchCreationPage.setCountry(TestData.country);
		branchCreationPage.setState(TestData.state);
		branchCreationPage.setCity(TestData.city);
		branchCreationPage.resetButton();
		Assert.assertTrue(branchCreationPage.isFormReset());
	}

	@Test(priority = 5, groups = { "branch", "cancel" })
	public void branchCreationCancel() {
		branchDetailsPage = adminHomePage.clickBranches();
		branchCreationPage = branchDetailsPage.clickNewBranch();
		branchDetailsPage = branchCreationPage.cancelButton();
		Assert.assertTrue(branchDetailsPage.isNewBranchButtonDisplayed());
	}

	@Test(priority = 6, groups = { "role", "create" })
	public void roleCreationWithValidDate() {
		roleDetailsPage = adminHomePage.clickRoles();
		roleCreationPage = roleDetailsPage.clickNewRole();
		roleCreationPage.setRoleName(TestData.roleName);
		roleCreationPage.selectRoleType(TestData.roleType);
		alert = roleCreationPage.clickSubmit();
		alertText = alert.getText();
		alert.accept();
		Assert.assertTrue(alertText.toLowerCase().contains("created sucessfully"));
	}

	@Test(priority = 7, groups = { "role", "create" })
	public void roleCreationWithDuplicateDate() {
		roleDetailsPage = adminHomePage.clickRoles();
		roleCreationPage = roleDetailsPage.clickNewRole();
		roleCreationPage.setRoleName(TestData.roleName);
		roleCreationPage.selectRoleType(TestData.roleType);
		alert = roleCreationPage.clickSubmit();
		alertText = alert.getText();
		alert.accept();
		Assert.assertTrue(alertText.toLowerCase().contains("role already existed"));
	}

	@Test(priority = 8, groups = { "role", "blank" })
	public void roleCreationWithBlankDate() {
		roleDetailsPage = adminHomePage.clickRoles();
		roleCreationPage = roleDetailsPage.clickNewRole();
		alert = roleCreationPage.clickSubmit();
		alertText = alert.getText();
		alert.accept();
		Assert.assertTrue(alertText.toLowerCase().contains("fill in the following"));
	}

	@Test(priority = 9, groups = { "role", "reset" })
	public void roleCreationReset() {
		roleDetailsPage = adminHomePage.clickRoles();
		roleCreationPage = roleDetailsPage.clickNewRole();
		roleCreationPage.setRoleName(TestData.roleName);
		roleCreationPage.selectRoleType(TestData.roleType);
		roleCreationPage.clickReset();
		Assert.assertTrue(roleCreationPage.isFormReset());
	}

	@Test(priority = 10, groups = { "role", "cancel" })
	public void roleCreationCancel() {
		roleDetailsPage = adminHomePage.clickRoles();
		roleCreationPage = roleDetailsPage.clickNewRole();
		roleDetailsPage = roleCreationPage.clickCancel();
		Assert.assertTrue(roleDetailsPage.isNewRoleDisplayed());
	}

	@Test(priority = 11, groups = { "employee", "create" })
	public void employeeCreationWithValidData() {
		employeeDetailsPage = adminHomePage.clickEmployee();
		employeeCreaionPage = employeeDetailsPage.clickNewEmployee();
		employeeCreaionPage.setEmployeeName(TestData.empName);
		employeeCreaionPage.setPasswd(TestData.passwd);
		employeeCreaionPage.setBranch(TestData.branchName);
		employeeCreaionPage.setRole(TestData.roleType);
		alert = employeeCreaionPage.clickSubmit();
		alertText = alert.getText();
		alert.accept();
		Assert.assertTrue(alertText.toLowerCase().contains("New Employer Created"));
	}

	@Test(priority = 12, groups = { "employee", "create" })
	public void employeeCreationWIthDuplicateData() {
		employeeDetailsPage = adminHomePage.clickEmployee();
		employeeCreaionPage = employeeDetailsPage.clickNewEmployee();
		employeeCreaionPage.setEmployeeName(TestData.empName);
		employeeCreaionPage.setPasswd(TestData.passwd);
		employeeCreaionPage.setBranch(TestData.branchName);
		employeeCreaionPage.setRole(TestData.roleType);
		alert = employeeCreaionPage.clickSubmit();
		alertText = alert.getText();
		alert.accept();
		Assert.assertTrue(alertText.contains("Employee already existed"));
	}

	@Test(priority = 13, groups = { "employee", "blank" })
	public void employeeCreationWithBlandkData() {
		employeeDetailsPage = adminHomePage.clickEmployee();
		employeeCreaionPage = employeeDetailsPage.clickNewEmployee();
		alert = employeeCreaionPage.clickSubmit();
		alertText = alert.getText();
		alert.accept();
		Assert.assertTrue(alertText.toLowerCase().contains("fill in the following"));
	}

	@Test(priority = 14, groups = { "employee", "reset" })
	public void employeeCreationReset() {
		employeeDetailsPage = adminHomePage.clickEmployee();
		employeeCreaionPage = employeeDetailsPage.clickNewEmployee();
		employeeCreaionPage.setEmployeeName(TestData.empName);
		employeeCreaionPage.setPasswd(TestData.passwd);
		employeeCreaionPage.setBranch(TestData.branchName);
		employeeCreaionPage.clickReset();
		Assert.assertTrue(employeeCreaionPage.isEmployeeReset());
	}

	@Test(priority = 15, groups = { "employee", "cancel" })
	public void employeCreationCancel() {
		employeeDetailsPage = adminHomePage.clickEmployee();
		employeeCreaionPage = employeeDetailsPage.clickNewEmployee();
		employeeDetailsPage = employeeCreaionPage.clickCancel();
		Assert.assertTrue(employeeDetailsPage.isNewEmployeeDisplayed());
	}
}
