package in.srssprojects.keximbank;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class ParameterExecution extends TestExecution {

	@BeforeClass(groups = { "branch", "create", "role", "employee", "blank", "reset", "cancel" })
	@Parameters({"brName", "url"})
	public void browserLaunch(String browserName, String u) {
		launchBrowser(browserName, u);
	}

	@AfterClass(groups = { "branch", "create", "role", "employee", "blank", "reset", "cancel" })
	public void tearDown() {
		closeBrowser();
	}
}
