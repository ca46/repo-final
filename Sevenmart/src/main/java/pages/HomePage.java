package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement usernameField;
	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement passwordField;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement signInButton;
	@FindBy(xpath = "//div/nav/ul[2]/li/a")
	WebElement profileImage;
	@FindBy(xpath = "//div/nav/ul[2]/li/div/a[2]")
	WebElement logoutButton;
	@FindBy(xpath = "//button[text()='Sign In']")
	WebElement signInPageButton;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']//parent::div/a")
	WebElement adminMoreInfoLink;
	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public AdminUsersPage clickAdminMoreInfo() 
	{
		adminMoreInfoLink.click();
		return new AdminUsersPage(driver);
		
	}

	public HomePage openUserDropdown() {
		profileImage.click();
		return this;
	}

	public HomePage userLogout() {
		logoutButton.click();
		return this;
	}

	public boolean isSignInPageDisplayed() {
		return signInPageButton.isDisplayed();
	}
}
