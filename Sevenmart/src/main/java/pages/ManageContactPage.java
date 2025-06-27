package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.PageUtility;

public class ManageContactPage {

    @FindBy(xpath = "//input[@placeholder='Username']")WebElement usernameField;
    @FindBy(xpath = "//input[@placeholder='Password']")WebElement passwordField;
    @FindBy(xpath = "//button[@type='submit']")WebElement signInButton;
    @FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact']//parent::li/a") WebElement contactMoreInfoLink;
    @FindBy(xpath = "//i[@class='fas fa-edit']//parent::a/i")WebElement editContactIcon;
    @FindBy(xpath = "//input[@id='phone']")WebElement phoneInput;
    @FindBy(xpath = "//input[@id='email']")WebElement emailInput;
    @FindBy(xpath = "//textarea[@id='content']//parent::div/textarea[1]")WebElement addressInput;
    @FindBy(xpath = "//button[@name='Update']")WebElement updateButton;
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")WebElement successAlert;

    public WebDriver driver;

    public ManageContactPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickContactMoreInfo() {
        contactMoreInfoLink.click();
    }

    public void clickEditContactIcon() {
        editContactIcon.click();
    }

    public void updatePhoneNumber(String phoneNumber) {
        phoneInput.clear();
        phoneInput.sendKeys(phoneNumber);
    }

    public void updateEmail(String email) {
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void updateAddress(String address) {
        addressInput.clear();
        addressInput.sendKeys(address);
    }

    public void clickUpdateButton() {
        PageUtility pageutility = new PageUtility();
        pageutility.javaSriptClick(driver, updateButton);
    }

    public boolean isSuccessAlertDisplayed() {
        return successAlert.isDisplayed();
    }
}
