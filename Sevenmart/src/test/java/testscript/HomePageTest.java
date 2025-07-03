package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.LoginPage;
import pages.HomePage;
import utilities.ExcelUtility;

public class HomePageTest extends Base {
	public HomePage homepage;

	@Test(retryAnalyzer = retry.Retry.class,description="LOGOUT")
	public void verifyUserIsAbleToLogout() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "loginpage");
		String password = ExcelUtility.getStringData(1, 1, "loginpage");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterTheUserName(username).enterThePassword(password);
		homepage=loginPage.clickTheSignInButton();
		homepage.openUserDropdown().userLogout();
		/*loginPage.enterTheUserName(username);
		loginPage.enterThePassword(password);
		loginPage.clickTheSignInButton();

		HomePage homePage = new HomePage(driver);
		homePage.openUserDropdown();
		homePage.userLogout();*/

		boolean isSignInDisplayed = homepage.isSignInPageDisplayed();
		Assert.assertTrue(isSignInDisplayed,Constants.LOGOUT);
	}
}
