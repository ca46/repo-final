package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(xpath=" //input[@placeholder='Username']") WebElement uname;
	@FindBy(xpath=" //input[@placeholder='Password']") WebElement pswd;
	@FindBy(xpath=" //button[@type='submit']") WebElement signin;
	@FindBy(xpath=" //p[text()='Dashboard']") WebElement dashboard;
	@FindBy(xpath=" //div[@class='alert alert-danger alert-dismissible']") WebElement alertmsg;
   
	 public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);//page factory class---initelements methods---used to initializing web elemnts 
		
	}
	public void enterTheUsername(String usname)
	{
		uname.sendKeys(usname);
	}
	public void enterThePassword(String pword)
	{
		pswd.sendKeys(pword);
	}
	
	public void clickSigninButton()
	{
		
		signin.click();
	}
	
	public boolean isdashboardDisplayed()
	{
		return dashboard.isDisplayed();
		
	}
	
	public boolean isAlertMessageDisplayed()
	{
		return alertmsg.isDisplayed();
	}
}

