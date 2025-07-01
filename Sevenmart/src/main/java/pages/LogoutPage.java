package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {

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

	public WebDriver driver;

	public LogoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void openUserDropdown() {
		profileImage.click();
	}

	public void userLogout() {
		logoutButton.click();
	}

	public boolean isSignInPageDisplayed() {
		return signInPageButton.isDisplayed();
	}
}
