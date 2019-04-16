package in.srssprojects.keximbank;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/*
 * @author -- Manikanta
 */
public class BranchUpdationPage {

	private WebDriver driver;

	// Branch ID
	public WebElement branchID() {
		return driver.findElement(By.id("txtUbranchid"));
	}

	// Branch Name
	public WebElement branchName() {
		return driver.findElement(By.id("txtbnameU"));
	}

	// address1
	public WebElement address1() {
		return driver.findElement(By.id("txtadd1u"));
	}

	// address2
	public WebElement address2() {
		return driver.findElement(By.id("txtadd2u"));
	}

	// address3
	public WebElement address3() {
		return driver.findElement(By.id("txtadd3U"));
	}

	// area
	public WebElement area() {
		return driver.findElement(By.id("txtzipu"));
	}

	// zipcode
	public WebElement zipCode() {
		return driver.findElement(By.id("txtbnameU"));
	}

	// country
	public WebElement country() {
		return driver.findElement(By.name("drlst_countryU"));
	}
	// TODO -- Write methods for Country , State , City

	// update
	public WebElement updtae() {
		return driver.findElement(By.name("btnupdate"));
	}

	// cancel
	public WebElement cancel() {
		return driver.findElement(By.name("Btncancel"));
	}

	public BranchUpdationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	// fill Branch name
	public void setBranchName(String branchName) {
		this.branchName().sendKeys(branchName);
	}

	// fill address1
	public void setAddress1(String address1) {
		this.address1().sendKeys(address1);
	}

	// fill address2
	public void setAddress2(String address2) {
		this.address1().sendKeys(address2);
	}

	// fill address3
	public void setAddress3(String address3) {
		this.address1().sendKeys(address3);
	}

	// fill area
	public void setArea(String area) {
		this.address1().sendKeys(area);
	}

	// fill zipcode
	public void setZipcode(String zipcode) {
		this.address1().sendKeys(zipcode);
	}

	// choose country from the drop down list
	public void setCOuntry(String contryName) throws Exception {
		// WebElement country = driver.findElement(By.name("drlst_countryU"));
		Select selectCountry = new Select(this.country());
		selectCountry.selectByValue(contryName);
		Thread.sleep(3000);
	}

	// choose state from drop down list
	public void setState(String stateName) throws Exception {
		WebElement state = driver.findElement(By.name("lst_stateU"));
		Select selectState = new Select(state);
		selectState.selectByVisibleText(stateName);
		Thread.sleep(3000);
	}

	// choose city from the drop down list
	public void setCity(String cityName) throws Exception {
		WebElement city = driver.findElement(By.name("LST_cityU"));
		Select selectCity = new Select(city);
		selectCity.selectByVisibleText(cityName);
		Thread.sleep(3000);
	}

	// click update button
	public Alert clickUpdate() {
		this.updtae().click();
		return driver.switchTo().alert();
	}

	// click cancel button
	public BranchDetailsPage clickCancel() {
		this.cancel().click();
		return PageFactory.initElements(driver, BranchDetailsPage.class);
	}

}
