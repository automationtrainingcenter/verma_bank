package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptHelper{
	
	// get text field contents
	public static String getTextFieldValue(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript("return arguments[0].value", element).toString();
	}
	
	//bring an element into view
	public static void bringElementToView(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
	}
	
	//scroll page in upward or downward directions
	public static void scrollPageBy(WebDriver driver, long x, long y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.documentElement.scrollBy(arguments[0], arguments[1])", x, y);
	}
	
	//execute JavaScript code
//	public static Object executeScript(WebDriver driver, String script, Object arg) {
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		return js.executeScript(script, arg);
//	}

}
