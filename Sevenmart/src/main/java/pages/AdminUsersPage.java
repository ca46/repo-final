package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.PageUtility;

public class AdminUsersPage {

	public WebDriver driver;

	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement usernameField;
	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement passwordField;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement signInButton;
	@FindBy(xpath = "//a[text()=' New']")
	WebElement newAdminButton;
	@FindBy(xpath = "//input[@id='username']")
	WebElement inputUsername;
	@FindBy(xpath = "//input[@id='password']")
	WebElement inputPassword;
	@FindBy(xpath = "//select[@id='user_type']")
	WebElement userTypeDropdown;
	@FindBy(xpath = "//button[@name='Create']")
	WebElement createButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertmsg;
	@FindBy(xpath = "//a[contains(@href, '/admin/user/edit?edit=') and contains(@class, 'btn-primary')]")
	WebElement editAdminButton;
	@FindBy(xpath = "//button[@name='Update']")
	WebElement updateButton;
	@FindBy(xpath = "//h5[text()=' Alert!']")
	WebElement updateAlert;

	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	

	public AdminUsersPage clickAddNewAdmin() {
		newAdminButton.click();
		return this;
	}

	public AdminUsersPage typeAdminUsername(String user) {
		inputUsername.sendKeys(user);
		return this;
	}

	public AdminUsersPage typeAdminPassword(String pass) {
		inputPassword.sendKeys(pass);
		return this;
	}

	public AdminUsersPage chooseUserType() {
		PageUtility pageutility = new PageUtility();
		pageutility.selectByIndex(userTypeDropdown, 2);
		return this;
	}

	public AdminUsersPage clickCreateAdmin() {
		createButton.click();
		return this;
	}

	public boolean isSuccessAlertDisplayed() {
		return alertmsg.isDisplayed();
	}

	public AdminUsersPage clickEditAdmin() {
		editAdminButton.click();
		return this;
	}

	public AdminUsersPage clickUpdateAdmin() {
		updateButton.click();
		return this;
	}

	public boolean isUpdateAlertDisplayed() {
		return updateAlert.isDisplayed();
	}
}
