package in.srssprojects.keximbank;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
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
	private RoleCreationPage roleCreationPage;

	@Test(priority = 0)
	public void login() {
		bankHomePage = new BankHomePage(driver);
		bankHomePage.setUserName(readProperty("username"));
		bankHomePage.setPassword(readProperty("password"));
		bankHomePage.clickLogin();
		adminHomePage = PageFactory.initElements(driver, AdminHomePage.class);
		Assert.assertTrue(adminHomePage.isAdminHomePageDispalyed());
	}

	@Test(priority = 1)
	public void branchCreationWithValidData() {
		branchDetailsPage = adminHomePage.clickBranches();
		branchCreationPage = branchDetailsPage.clickNewBranch();
		branchCreationPage.setBranchName(TestData.branchName);
		branchCreationPage.setAddress1(TestData.address1);
		branchCreationPage.setZipcode(TestData.zipcode);
		branchCreationPage.setCountry(TestData.country);
		branchCreationPage.setState(TestData.state);
		branchCreationPage.setCity(TestData.city);
		Alert alert = branchCreationPage.submitButton();
		alertText = alert.getText();
		Assert.assertTrue(alertText.contains("created Sucessfully"));
	}
	
	@Test(priority = 2)
	public void branchCreationWithDuplicateData() {
		branchDetailsPage = adminHomePage.clickBranches();
		branchCreationPage = branchDetailsPage.clickNewBranch();
		branchCreationPage.setBranchName(TestData.branchName);
		branchCreationPage.setAddress1(TestData.address1);
		branchCreationPage.setZipcode(TestData.zipcode);
		branchCreationPage.setCountry(TestData.country);
		branchCreationPage.setState(TestData.state);
		branchCreationPage.setCity(TestData.city);
		Alert alert = branchCreationPage.submitButton();
		alertText = alert.getText();
		Assert.assertTrue(alertText.contains("Branch name already Exist"));
	}
	
	@Test(priority = 3)
	public void branchCreationWithBlankData() {
		branchDetailsPage = adminHomePage.clickBranches();
		branchCreationPage = branchDetailsPage.clickNewBranch();
		Alert alert = branchCreationPage.submitButton();
		alertText = alert.getText();
		Assert.assertTrue(alertText.contains("fill in the following"));
	}
	
	@Test(priority = 4)
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
	
	@Test(priority = 5)
	public void branchCreationCancel() {
		branchDetailsPage = adminHomePage.clickBranches();
		branchCreationPage = branchDetailsPage.clickNewBranch();
		branchDetailsPage = branchCreationPage.cancelButton();
		Assert.assertTrue(branchDetailsPage.isNewBranchButtonDisplayed());
	}
	
	
	@Test(priority = 6)
	public void roleCreationWithValidDate() {
		roleDetailsPage = adminHomePage.clickRoles();
		roleCreationPage = roleDetailsPage.clickNewRole();
		roleCreationPage.setRoleName(TestData.roleName);
		roleCreationPage.selectRoleType(TestData.roleType);
		Alert alert = roleCreationPage.clickSubmit();
		Assert.assertTrue(alert.getText().toLowerCase().contains("created sucessfully"));
	}
	
	@Test(priority = 7)
	public void roleCreationWithDuplicateDate() {
		roleDetailsPage = adminHomePage.clickRoles();
		roleCreationPage = roleDetailsPage.clickNewRole();
		roleCreationPage.setRoleName(TestData.roleName);
		roleCreationPage.selectRoleType(TestData.roleType);
		Alert alert = roleCreationPage.clickSubmit();
		Assert.assertTrue(alert.getText().toLowerCase().contains("role already existed"));
	}
	
	@Test(priority = 8)
	public void roleCreationWithBlankDate() {
		roleDetailsPage = adminHomePage.clickRoles();
		roleCreationPage = roleDetailsPage.clickNewRole();
		Alert alert = roleCreationPage.clickSubmit();
		Assert.assertTrue(alert.getText().toLowerCase().contains("fill in the following"));
	}
	
	@Test(priority = 9)
	public void roleCreationReset() {
		roleDetailsPage = adminHomePage.clickRoles();
		roleCreationPage = roleDetailsPage.clickNewRole();
		roleCreationPage.setRoleName(TestData.roleName);
		roleCreationPage.selectRoleType(TestData.roleType);
		roleCreationPage.clickReset();
		Assert.assertTrue(roleCreationPage.isFormReset());
	}
	
	@Test(priority = 10)
	public void roleCreationCancel() {
		roleDetailsPage = adminHomePage.clickRoles();
		roleCreationPage = roleDetailsPage.clickNewRole();
		roleDetailsPage = roleCreationPage.clickCancel();
		Assert.assertTrue(roleDetailsPage.isNewRoleDisplayed());
	}

}
