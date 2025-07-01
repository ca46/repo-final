package testscript;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {

	@Test(retryAnalyzer = retry.Retry.class, groups = { "Regression" },description="LOGINWITHINCORRECTUSERNAMEANDPASSWORD")
	public void verifyTheUserIsAbleToLoginUsingValidCredential() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "loginpage");
		String password = ExcelUtility.getStringData(1, 1, "loginpage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUserName(username);
		loginpage.enterThePassword(password);
		loginpage.clickTheSignInButton();

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

	@Test(retryAnalyzer = retry.Retry.class,description="LOGINWITHINCORRECTUSERNAMEANDPASSWORD")
	public void incorrectUsernameAndIncorrectPassword() throws IOException {
		String username = ExcelUtility.getStringData(4, 0, "loginpage");
		String password = ExcelUtility.getStringData(4, 1, "loginpage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUserName(username);
		loginpage.enterThePassword(password);
		loginpage.clickTheSignInButton();

		boolean alert = loginpage.isAlertMessageDisplayed();
		Assert.assertTrue(alert,Constants.LOGINWITHINCORRECTUSERNAMEANDPASSWORD);
	}
}
