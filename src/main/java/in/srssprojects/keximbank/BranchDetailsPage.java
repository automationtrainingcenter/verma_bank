package in.srssprojects.keximbank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

//srikanth
public class BranchDetailsPage {
	WebDriver driver;

	// Country
	@FindBy(how = How.ID, using = "lst_countryS")
	private WebElement country;

	// State
	@FindBy(how = How.ID, using = "lst_stateS")
	private WebElement state;

	// City
	@FindBy(how = How.ID, using = "lst_cityS")
	private WebElement city;

	// Search
	@FindBy(how = How.ID, using = "btn_search")
	private WebElement search;

	// Clear
	@FindBy(how = How.ID, using = "btn_clsearch")
	private WebElement clear;

	// New Branch
	@FindBy(how = How.ID, using = "BtnNewBR")
	private WebElement newBranch;

	// Construcor
	public BranchDetailsPage(WebDriver driver) {
		this.driver = driver;
	}

	// Select Country from Drop Down list
	public void setCountry(String countryName) {
		new Select(this.country).selectByVisibleText(countryName);
	}

	// Select State from Drop down list
	public void setState(String stateName) {
		new Select(this.state).selectByVisibleText(stateName);
	}

	// Select City from drop down list
	public void setCity(String cityName) {
		new Select(this.city).selectByVisibleText(cityName);
	}

	// click search Button
	public BranchDetailsPage clickSearch(String searcButton) {
		this.search.click();
		return PageFactory.initElements(driver, BranchDetailsPage.class);
	}

	// click clear Button
	public BranchDetailsPage clickClear(String searcButton) {
		this.clear.click();
		return PageFactory.initElements(driver, BranchDetailsPage.class);
	}

	// click New Branch Button
	public BranchCreationPage clickNewBranch(String searcButton) {
		this.newBranch.click();
		return PageFactory.initElements(driver, BranchCreationPage.class);
	}

}
