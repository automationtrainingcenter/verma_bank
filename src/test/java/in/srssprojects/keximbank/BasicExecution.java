package in.srssprojects.keximbank;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BasicExecution extends TestExecution {

	@BeforeClass(groups = { "branch", "create", "role", "employee", "blank", "reset", "cancel" })
	public void browserLaunch() {
		launchBrowser(readProperty("browser"), readProperty("url"));
	}

	@AfterClass(groups = { "branch", "create", "role", "employee", "blank", "reset", "cancel" })
	public void tearDown() {
		closeBrowser();
	}
}
