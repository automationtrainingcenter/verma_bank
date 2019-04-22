package in.srssprojects.keximbank;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BasicExecution extends TestExecution{
	
	@BeforeClass
	public void browserLaunch() {
		launchBrowser(readProperty("browser"), readProperty("url"));
	}
	
	@AfterClass
	public void tearDown() {
		closeBrowser();
	}
}
