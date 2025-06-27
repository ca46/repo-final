package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {

	public WebDriver driver;

	@FindBy(xpath = "//input[@placeholder='Username']")WebElement usernameField;
	@FindBy(xpath = "//input[@placeholder='Password']")WebElement passwordField;
	@FindBy(xpath = "//button[@type='submit']")WebElement signInButton;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news']//parent::li")WebElement newsMoreInfoLink;
	@FindBy(xpath = "//a[text()=' New']")WebElement addNewsButton;
	@FindBy(xpath = "//textarea[@id='news']")WebElement newsTextArea;
	@FindBy(xpath = "//button[@name='create']")WebElement createNewsButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")WebElement successAlert;
	@FindBy(xpath = "//i[contains(@class, 'fa-edit')]")WebElement editNewsIcon;
	@FindBy(xpath = "//button[@name='update']")WebElement updateNewsButton;
	@FindBy(xpath = "//h5[text()=' Alert!']")WebElement alertHeader;

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickNewsMoreInfo() {
		newsMoreInfoLink.click();
	}

	public void clickAddNewsButton() {
		addNewsButton.click();
	}

	public void typeNewsContent(String news) {
		newsTextArea.sendKeys(news);
	}

	public void clickCreateNews() {
		createNewsButton.click();
	}

	public boolean isSuccessAlertDisplayed() {
		return successAlert.isDisplayed();
	}

	public void clickEditNewsIcon() {
		editNewsIcon.click();
	}

	public void clickUpdateNewsButton() {
		updateNewsButton.click();
	}

	public boolean isUpdateAlertDisplayed() {
		return alertHeader.isDisplayed();
	}
}


