package testscript;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	
    public HomePage homepage;
    
	@Test(retryAnalyzer = retry.Retry.class, groups = { "Regression" },description="LOGINWITHINCORRECTUSERNAMEANDPASSWORD")
	public void verifyTheUserIsAbleToLoginUsingValidCredential() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "loginpage");
		String password = ExcelUtility.getStringData(1, 1, "loginpage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUserName(username).enterThePassword(password);
		homepage=loginpage.clickTheSignInButton();
		/*loginpage.enterTheUserName(username);
		loginpage.enterThePassword(password);
		loginpage.clickTheSignInButton();*/

		boolean dashboardLoaded = loginpage.isDashBoardDisplayed();
		Assert.assertTrue(dashboardLoaded,Constants.LOGINWITHVALIDCREDITIONAL);
	}

	@Test(retryAnalyzer = retry.Retry.class,description="LOGINWITHINCORRECTUSERNAMEANDPASSWORD")
	public void invalidUsernameAndCorrectPassword() throws IOException {
		String username = ExcelUtility.getStringData(2, 0, "loginpage");
		String password = ExcelUtility.getStringData(2, 1, "loginpage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUserName(username);
		loginpage.enterThePassword(password);
		loginpage.clickTheSignInButton();

		boolean alert = loginpage.isAlertMessageDisplayed();
		Assert.assertTrue(alert,Constants.LOGINWITHINVALIDUSERNAMEANDPASSWORD);
	}

	@Test(retryAnalyzer = retry.Retry.class,description="LOGINWITHINCORRECTUSERNAMEANDPASSWORD")
	public void correctUsernameAndIncorrectPassword() throws IOException {
		String username = ExcelUtility.getStringData(3, 0, "loginpage");
		String password = ExcelUtility.getStringData(3, 1, "loginpage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUserName(username);
		loginpage.enterThePassword(password);
		loginpage.clickTheSignInButton();

		boolean alert = loginpage.isAlertMessageDisplayed();
		Assert.assertTrue(alert,Constants.LOGINWITHCORRECTUSERNAMEANDINVALID);
	}

	@Test(dataProvider="logindataprovider",retryAnalyzer = retry.Retry.class,description="LOGINWITHINCORRECTUSERNAMEANDPASSWORD")
	public void incorrectUsernameAndIncorrectPassword(String username,String password) throws IOException {
		//String username = ExcelUtility.getStringData(4, 0, "loginpage");
		//String password = ExcelUtility.getStringData(4, 1, "loginpage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUserName(username);
		loginpage.enterThePassword(password);
		loginpage.clickTheSignInButton();

		boolean alert = loginpage.isAlertMessageDisplayed();
		Assert.assertTrue(alert,Constants.LOGINWITHINCORRECTUSERNAMEANDPASSWORD);
	}
	@DataProvider(name= "logindataprovider")
	public Object[][] dpmethod()
	{
		return new Object[][] 
		{
			{"carol","Renin"},{"manu","wer"},{"sad","dfd"}
		};
	}
	}

