package testscript;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {

	@Test(retryAnalyzer = retry.Retry.class, groups = {"Regression"})
	public void verifyTheUserIsAbleToLoginUsingValidCredential() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "loginpage");
		String password = ExcelUtility.getStringData(1, 1, "loginpage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUsername(username);
		loginpage.enterThePassword(password);
		loginpage.clickSigninButton();

		boolean dashboardLoaded = loginpage.isDashboardDisplayed();
		Assert.assertTrue(dashboardLoaded, "Dashboard not displayed with valid credentials.");
	}

	@Test(retryAnalyzer = retry.Retry.class)
	public void invalidUsernameAndCorrectPassword() throws IOException {
		String username = ExcelUtility.getStringData(2, 0, "loginpage");
		String password = ExcelUtility.getStringData(2, 1, "loginpage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUsername(username);
		loginpage.enterThePassword(password);
		loginpage.clickSigninButton();

		boolean alert = loginpage.isAlertMessageDisplayed();
		Assert.assertTrue(alert, "Alert message not displayed for invalid username.");
	}

	@Test(retryAnalyzer = retry.Retry.class)
	public void correctUsernameAndIncorrectPassword() throws IOException {
		String username = ExcelUtility.getStringData(3, 0, "loginpage");
		String password = ExcelUtility.getStringData(3, 1, "loginpage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUsername(username);
		loginpage.enterThePassword(password);
		loginpage.clickSigninButton();

		boolean alert = loginpage.isAlertMessageDisplayed();
		Assert.assertTrue(alert, "Alert message not displayed for incorrect password.");
	}

	@Test(retryAnalyzer = retry.Retry.class)
	public void incorrectUsernameAndIncorrectPassword() throws IOException {
		String username = ExcelUtility.getStringData(4, 0, "loginpage");
		String password = ExcelUtility.getStringData(4, 1, "loginpage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUsername(username);
		loginpage.enterThePassword(password);
		loginpage.clickSigninButton();

		boolean alert = loginpage.isAlertMessageDisplayed();
		Assert.assertTrue(alert, "Alert message not displayed for invalid credentials.");
	}
}
