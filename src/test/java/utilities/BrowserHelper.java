package utilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BrowserHelper extends GenericHelper {

	public WebDriver driver;
	protected ExtentReports reports;
	static protected ExtentTest test;
	static EventFiringWebDriver edriver;
	
	public void launchBrowser(String broserName, String url) {
		if (broserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else {
			System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		//to generate the log report
		edriver = new EventFiringWebDriver(driver);
		EventListener listener = new EventListener();
		edriver.register(listener);
		driver = edriver;
		driver.get(url);
//		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void launchBrowser(String browserName, String url, String nodeUrl) {
		DesiredCapabilities caps = new DesiredCapabilities();
		if (browserName.equalsIgnoreCase("chrome")) {
//			caps.setBrowserName(BrowserType.CHROME);
			caps = DesiredCapabilities.chrome();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			caps = DesiredCapabilities.firefox();
		} else {
			caps = DesiredCapabilities.edge();
		}
		caps.setPlatform(Platform.WINDOWS);
		try {
			driver = new RemoteWebDriver(new URL(nodeUrl), caps);
			//to generate the log report
			EventFiringWebDriver edriver = new EventFiringWebDriver(driver);
			EventListener listener = new EventListener();
			edriver.register(listener);
			driver = edriver;
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

	}

	public void closeBrowser() {
		if (driver.getWindowHandles().size() > 1) {
			driver.quit();
		} else {
			driver.close();
		}
	}

}
