package testscript;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {

	@Test(retryAnalyzer = retry.Retry.class)
	public void verifyUserCanCreateNews() throws IOException {

		String username = ExcelUtility.getStringData(1, 0, "loginpage");
		String password = ExcelUtility.getStringData(1, 1, "loginpage");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterTheUserName(username);
		loginPage.enterThePassword(password);
		loginPage.clickTheSignInButton();

		String newsContent = ExcelUtility.getStringData(1, 0, "managenews");

		ManageNewsPage newsPage = new ManageNewsPage(driver);
		newsPage.clickNewsMoreInfo();
		newsPage.clickAddNewsButton();
		newsPage.typeNewsContent(newsContent);
		newsPage.clickCreateNews();

		Assert.assertTrue(newsPage.isSuccessAlertDisplayed());
	}

	@Test(retryAnalyzer = retry.Retry.class)
	public void verifyUserCanUpdateNews() throws IOException {

		String username = ExcelUtility.getStringData(1, 0, "loginpage");
		String password = ExcelUtility.getStringData(1, 1, "loginpage");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterTheUserName(username);
		loginPage.enterThePassword(password);
		loginPage.clickTheSignInButton();

		ManageNewsPage newsPage = new ManageNewsPage(driver);
		newsPage.clickNewsMoreInfo();
		newsPage.clickEditNewsIcon();
		newsPage.clickUpdateNewsButton();

		Assert.assertTrue(newsPage.isSuccessAlertDisplayed());
	}
}
