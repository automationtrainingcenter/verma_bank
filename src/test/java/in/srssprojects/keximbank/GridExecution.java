package in.srssprojects.keximbank;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class GridExecution extends TestExecution {

	@BeforeClass(groups = { "branch", "create", "role", "employee", "blank", "reset", "cancel" })
	@Parameters({"brName", "url", "nodeURL"})
	public void browserLaunch(String browserName, String u, String nodeUrl) {
		launchBrowser(browserName, u, nodeUrl);
	}

	@AfterClass(groups = { "branch", "create", "role", "employee", "blank", "reset", "cancel" })
	public void tearDown() {
		closeBrowser();
	}
}
