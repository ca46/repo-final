package testscript;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminUsersPage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUsersTest extends Base {

	@Test(retryAnalyzer = retry.Retry.class)
	public void verifyAdminUserCreation() throws IOException {

		String username = ExcelUtility.getStringData(1, 0, "loginpage");
		String password = ExcelUtility.getStringData(1, 1, "loginpage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUsername(username);
		loginpage.enterThePassword(password);
		loginpage.clickSigninButton();

		AdminUsersPage adminPage = new AdminUsersPage(driver);
		FakerUtility faker = new FakerUtility();

		String newAdminUser = faker.creatARandomFirstName();
		String newAdminPass = faker.creatARandomFirstName();

		adminPage.clickAdminMoreInfo();
		adminPage.clickAddNewAdmin();
		adminPage.typeAdminUsername(newAdminUser);
		adminPage.typeAdminPassword(newAdminPass);
		adminPage.chooseUserType();
		adminPage.clickCreateAdmin();

		Assert.assertTrue(adminPage.isSuccessAlertDisplayed());
	}

	@Test(retryAnalyzer = retry.Retry.class)
	public void verifyAdminUserUpdate() throws IOException {

		String username = ExcelUtility.getStringData(1, 0, "loginpage");
		String password = ExcelUtility.getStringData(1, 1, "loginpage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUsername(username);
		loginpage.enterThePassword(password);
		loginpage.clickSigninButton();

		AdminUsersPage adminPage = new AdminUsersPage(driver);
		adminPage.clickAdminMoreInfo();
		adminPage.clickEditAdmin();
		adminPage.clickUpdateAdmin();

		Assert.assertTrue(adminPage.isUpdateAlertDisplayed());
	}
}
