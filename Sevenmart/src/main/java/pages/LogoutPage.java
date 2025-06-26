package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {

	@FindBy(xpath="//input[@placeholder='Username']")WebElement uname;
	@FindBy(xpath="//input[@placeholder='Password']")WebElement pword;
	@FindBy(xpath="//button[@type='submit']")WebElement signin;
	@FindBy(xpath="//img[@src='https://groceryapp.uniqassosiates.com/public/assets/admin/dist/img/avatar5.png']")WebElement image;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/logout']//parent::div")WebElement logout;
	@FindBy(xpath="//button[text()='Sign In']")WebElement signinpage;
	
	public WebDriver driver;
	
	public LogoutPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void admin()
	{
		image.click();
	}
	public void userLogout()
	{
		logout.click();
	}
	
	public boolean signinPageDisplayed()
	{
		return signinpage.isDisplayed();
	}
}