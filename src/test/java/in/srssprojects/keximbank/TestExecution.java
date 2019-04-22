package in.srssprojects.keximbank;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.BrowserHelper;

public class TestExecution extends BrowserHelper {
	BankHomePage bankHomePage;
	AdminHomePage adminHomePage;

	@Test(priority = 0)
	public void login() {
		bankHomePage = new BankHomePage(driver);
		bankHomePage.setUserName(readProperty("username"));
		bankHomePage.setPassword(readProperty("password"));
		bankHomePage.clickLogin();
		adminHomePage = PageFactory.initElements(driver, AdminHomePage.class);
		Assert.assertTrue(adminHomePage.isAdminHomePageDispalyed());
	}

}
