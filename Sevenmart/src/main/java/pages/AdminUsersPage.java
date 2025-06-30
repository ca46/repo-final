package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.PageUtility;

public class AdminUsersPage {

	public WebDriver driver;

	@FindBy(xpath = "//input[@placeholder='Username']")WebElement usernameField;
	@FindBy(xpath = "//input[@placeholder='Password']")WebElement passwordField;
	@FindBy(xpath = "//button[@type='submit']")WebElement signInButton;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']//parent::div/a")WebElement adminMoreInfoLink;
	@FindBy(xpath = "//a[text()=' New']")WebElement newAdminButton;
	@FindBy(xpath = "//input[@id='username']")WebElement inputUsername;
	@FindBy(xpath = "//input[@id='password']")WebElement inputPassword;
	@FindBy(xpath = "//select[@id='user_type']")WebElement userTypeDropdown;
	@FindBy(xpath = "//button[@name='Create']")WebElement createButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alertmsg;
	@FindBy(xpath = "//a[contains(@href, '/admin/user/edit?edit=') and contains(@class, 'btn-primary')]")WebElement editAdminButton;
    @FindBy(xpath = "//button[@name='Update']")WebElement updateButton;
	@FindBy(xpath = "//h5[text()=' Alert!']")WebElement updateAlert;

	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickAdminMoreInfo() {
		adminMoreInfoLink.click();
	}

	public void clickAddNewAdmin() {
		newAdminButton.click();
	}

	public void typeAdminUsername(String user) {
		inputUsername.sendKeys(user);
	}

	public void typeAdminPassword(String pass) {
		inputPassword.sendKeys(pass);
	}

	public void chooseUserType() {
		PageUtility pageutility = new PageUtility();
		pageutility.selectByIndex(userTypeDropdown, 2);
	}

	public void clickCreateAdmin() {
		createButton.click();
	}

	public boolean isSuccessAlertDisplayed() {
		return alertmsg.isDisplayed();
	}

	public void clickEditAdmin() {
		editAdminButton.click();
	}

	public void clickUpdateAdmin() {
		updateButton.click();
	}

	public boolean isUpdateAlertDisplayed() {
		return updateAlert.isDisplayed();
	}
}
