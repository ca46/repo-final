package testscript;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.LogoutPage;
import utilities.ExcelUtility;

public class LogoutTest extends Base {

	@Test(retryAnalyzer = retry.Retry.class)
	public void isUserAbleToLogoutSuccessfully() throws IOException {

		String username = ExcelUtility.getStringData(1, 0, "loginpage");
		String password = ExcelUtility.getStringData(1, 1, "loginpage");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterTheUserName(username);
		loginPage.enterThePassword(password);
		loginPage.clickTheSignInButton();

		LogoutPage logoutPage = new LogoutPage(driver);
		logoutPage.clickProfileImage();
		logoutPage.clickLogoutLink();

		boolean isSignInDisplayed = logoutPage.isSignInPageDisplayed();
		Assert.assertTrue(isSignInDisplayed);
	}
}
