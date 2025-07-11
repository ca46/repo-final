package testscript;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

@Test
public class ManageCategoryTest extends Base {
	public ManageCategoryPage managecategorypage;
	public HomePage homepage;

	@Test(retryAnalyzer = retry.Retry.class,description="CATEGORYDISPLAY")
	public void verifyTheUserIsAbleToAddCategoryInformations() throws IOException, AWTException {

		String username = ExcelUtility.getStringData(1, 0, "loginpage");
		String password = ExcelUtility.getStringData(1, 1, "loginpage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUserName(username).enterThePassword(password);
		homepage=loginpage.clickTheSignInButton();
		managecategorypage=homepage.moreInfoManageCategory();
		managecategorypage.newlist();
		FakerUtility fakerutility = new FakerUtility();
		String catgry = fakerutility.creatARandomFirstName();
		managecategorypage.categoryInformation(catgry).selectGroup().fileUpload().saveCategoryInformations();
		/*loginpage.enterTheUserName(username);
		loginpage.enterThePassword(password);
		loginpage.clickTheSignInButton();

		ManageCategoryPage managecategory = new ManageCategoryPage(driver);

		managecategory.moreInfoManageCategory();
		managecategory.newButton();

		FakerUtility fakerutility = new FakerUtility();
		String catgry = fakerutility.creatARandomFirstName();

		managecategory.categoryInformation(catgry);
		managecategory.selectGroup();
		managecategory.fileUpload();
		managecategory.saveCategoryInformations();*/

		boolean alertmsg = managecategorypage.isAlertMessageIsDisplayed();
		Assert.assertTrue(alertmsg, Constants.CATEGORYDISPLAY);

	}
}