package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.relevantcodes.extentreports.LogStatus;

public class EventListener extends BrowserHelper implements WebDriverEventListener {
	@Override
	public void afterAlertAccept(WebDriver arg0) {
		test.log(LogStatus.INFO, "alert accepted");
	}

	@Override
	public void afterAlertDismiss(WebDriver arg0) {
		test.log(LogStatus.INFO, "alert dismissed");
	}

	@Override
	public void afterChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		test.log(LogStatus.INFO, "element value changed to " + JavaScriptHelper.getTextFieldValue(arg1, arg0));
	}

	@Override
	public void afterClickOn(WebElement arg0, WebDriver arg1) {
		test.log(LogStatus.INFO, "clicked on the element");
	}

	@Override
	public void afterFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		test.log(LogStatus.INFO, "element located successfully");
	}

	@Override
	public <X> void afterGetScreenshotAs(OutputType<X> arg0, X arg1) {

	}

	@Override
	public void afterGetText(WebElement arg0, WebDriver arg1, String arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterNavigateBack(WebDriver arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterNavigateForward(WebDriver arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterNavigateTo(String arg0, WebDriver arg1) {
//		test.log(LogStatus.INFO, "navigated to " + arg0);
	}

	@Override
	public void afterScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterSwitchToWindow(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeAlertAccept(WebDriver arg0) {
		test.log(LogStatus.INFO, "alert came with text " + arg0.switchTo().alert().getText());
	}

	@Override
	public void beforeAlertDismiss(WebDriver arg0) {
		test.log(LogStatus.INFO, "alert came with text " + arg0.switchTo().alert().getText());
	}

	@Override
	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		test.log(LogStatus.INFO, "changing element value to " + arg2.toString());
	}

	@Override
	public void beforeClickOn(WebElement arg0, WebDriver arg1) {
		test.log(LogStatus.INFO, "clicking on the element");
	}

	@Override
	public void beforeFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		test.log(LogStatus.INFO, "locating element using " + arg0);
	}

	@Override
	public <X> void beforeGetScreenshotAs(OutputType<X> arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeGetText(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeNavigateBack(WebDriver arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeNavigateForward(WebDriver arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeNavigateTo(String arg0, WebDriver arg1) {
//		test.log(LogStatus.INFO, "navigating to " + arg0);
	}

	@Override
	public void beforeScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeSwitchToWindow(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onException(Throwable arg0, WebDriver arg1) {
		// TODO Auto-generated method stub

	}
}
