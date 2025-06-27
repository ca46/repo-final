package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {

	@FindBy(xpath = "//input[@placeholder='Username']")WebElement usernameInput;
	@FindBy(xpath = "//input[@placeholder='Password']")WebElement passwordInput;
	@FindBy(xpath = "//button[@type='submit']")WebElement signInButton;
	@FindBy(xpath = "//img[@src='https://groceryapp.uniqassosiates.com/public/assets/admin/dist/img/avatar5.png']")WebElement profileImage;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/logout']//parent::div")WebElement logoutLink;
	@FindBy(xpath = "//button[text()='Sign In']")WebElement signInPageButton;
	
	public WebDriver driver;

	public LogoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickProfileImage() {
		profileImage.click();
	}

	public void clickLogoutLink() {
		logoutLink.click();
	}

	public boolean isSignInPageDisplayed() {
		return signInPageButton.isDisplayed();
	}
}
