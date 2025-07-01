package testscript;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {

	@Test(retryAnalyzer = retry.Retry.class,description="VERIFYUSERABLETOENTERTHENEWS")
	public void verifyTheUserIsAbleToEnterTheNews() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "loginpage");
		String password = ExcelUtility.getStringData(1, 1, "loginpage");
		String news = ExcelUtility.getStringData(1, 0, "managenews");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUserName(username);
		loginpage.enterThePassword(password);
		loginpage.clickTheSignInButton();

		ManageNewsPage managenewspage = new ManageNewsPage(driver);
		managenewspage.clickMoreInformation();
		managenewspage.clickNewButton();
		managenewspage.enterNewsInformation(news);
		managenewspage.saveNews();

		boolean alertmessage = managenewspage.displayAlertMessage();
		Assert.assertTrue(alertmessage,Constants.VERIFYUSERABLETOENTERTHENEWS);
	}

	@Test(retryAnalyzer = retry.Retry.class,description="UPDATETHENEWS")
	public void verifyTheUserIsAbleToUpdateTheNews() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "loginpage");
		String password = ExcelUtility.getStringData(1, 1, "loginpage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUserName(username);
		loginpage.enterThePassword(password);
		loginpage.clickTheSignInButton();

		ManageNewsPage managenewspage = new ManageNewsPage(driver);
		managenewspage.clickMoreInformation();
		managenewspage.editNews();
		managenewspage.updateNews();

		boolean alertmsg = managenewspage.displayAlert();
		Assert.assertTrue(alertmsg,Constants.UPDATETHENEWS);
	}
}
