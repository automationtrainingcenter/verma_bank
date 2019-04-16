package in.srssprojects.keximbank;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/*
 * 
 * @author -- Manikanta
 */

public class BranchCreationPage {

	private WebDriver driver;

	// Branhc name
	@FindBy(how = How.ID, using = "txtbName")
	private WebElement branchName;

	// Address1
	@FindBy(how = How.ID, using = "txtAdd1")
	private WebElement address1;

	// Address2
	@FindBy(how = How.ID, using = "txtAdd3")
	private WebElement address2;

	// Address3
	@FindBy(how = How.ID, using = "txtAdd2")
	private WebElement address3;

	// area
	@FindBy(how = How.ID, using = "txtArea")
	private WebElement area;

	// zipcode
	@FindBy(how = How.ID, using = "txtZip")
	private WebElement zipcode;

	// Country
	@FindBy(how = How.ID, using = "lst_counrtyU")
	private WebElement country;

	// State
	@FindBy(how = How.ID, using = "lst_stateI")
	private WebElement state;

	// City
	@FindBy(how = How.ID, using = "lst_cityI")
	private WebElement city;

	// submit Button
	@FindBy(how = How.ID, using = "btn_insert")
	private WebElement submit;

	// reset Button
	@FindBy(how = How.ID, using = "Btn_Reset")
	private WebElement reset;

	// cancel Button
	@FindBy(how = How.ID, using = "Btn_cancel")
	private WebElement cancel;

	// Constructor
	public BranchCreationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// fill Branch name
	public void setBranchName(String branchName) {
		this.branchName.sendKeys(branchName);
	}

	// fill address1
	public void setAddress1(String address1) {
		this.address1.sendKeys(address1);
	}

	// fill address2
	public void setAddress2(String address2) {
		this.address2.sendKeys(address2);
	}

	// fill address3
	public void setAddress3(String address3) {
		this.address3.sendKeys(address3);
	}

	// fill area
	public void setArea(String area) {
		this.area.sendKeys(area);
	}

	// fill zipcode
	public void setZipcode(String zipcode) {
		this.zipcode.sendKeys(zipcode);
	}

	// select Country
	public void setCountry(String countryName) {
		new Select(this.country).selectByVisibleText(countryName);
	}

	// select State
	public void setState(String stateName) {
		new Select(this.state).selectByVisibleText(stateName);
	}

	// select City
	public void setCity(String cityName) {
		new Select(this.city).selectByVisibleText(cityName);
	}

	// click submit Button
	public Alert submitButton() {
		this.submit.click();
		return driver.switchTo().alert();
	}
	
	//reset button 
	public void resetButton() {
		this.reset.click();
	}

	// click cancel Button
	public BranchDetailsPage cancelButton() {
		this.cancel.click();
		return PageFactory.initElements(driver, BranchDetailsPage.class);

	}
	
	

}
