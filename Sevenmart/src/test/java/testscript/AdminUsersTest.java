package testscript;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUsersTest extends Base {
public AdminUsersPage adminuserspage;
public HomePage homepage;
	@Test(retryAnalyzer = retry.Retry.class)
	public void verifyAdminUserCreation() throws IOException {

		String username = ExcelUtility.getStringData(1, 0, "loginpage");
		String password = ExcelUtility.getStringData(1, 1, "loginpage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUserName(username).enterThePassword(password);
		homepage=loginpage.clickTheSignInButton();
		adminuserspage=homepage.clickAdminMoreInfo();
		FakerUtility faker = new FakerUtility();
		String newAdminUser = faker.creatARandomFirstName();
		String newAdminPass = faker.creatARandomFirstName();
		adminuserspage.clickAddNewAdmin();
		adminuserspage.typeAdminUsername(newAdminUser);
		adminuserspage.typeAdminPassword(newAdminPass);
		adminuserspage.chooseUserType();
		adminuserspage.clickCreateAdmin();
		
		
		
		/*loginpage.enterTheUserName(username);
		loginpage.enterThePassword(password);
		loginpage.clickTheSignInButton();

		AdminUsersPage adminPage = new AdminUsersPage(driver);
		FakerUtility faker = new FakerUtility();

		String newAdminUser = faker.creatARandomFirstName();
		String newAdminPass = faker.creatARandomFirstName();

		adminPage.clickAdminMoreInfo();
		adminPage.clickAddNewAdmin();
		adminPage.typeAdminUsername(newAdminUser);
		adminPage.typeAdminPassword(newAdminPass);
		adminPage.chooseUserType();
		adminPage.clickCreateAdmin();*/

		Assert.assertTrue(adminuserspage.isSuccessAlertDisplayed());
	}

	@Test(retryAnalyzer = retry.Retry.class)
	public void verifyAdminUserUpdate() throws IOException {

		String username = ExcelUtility.getStringData(1, 0, "loginpage");
		String password = ExcelUtility.getStringData(1, 1, "loginpage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUserName(username).enterThePassword(password);
		homepage=loginpage.clickTheSignInButton();
		adminuserspage=homepage.clickAdminMoreInfo();
		adminuserspage.clickEditAdmin();
		adminuserspage.clickUpdateAdmin();
		
		/*loginpage.enterThePassword(password);
		loginpage.clickTheSignInButton();

		AdminUsersPage adminPage = new AdminUsersPage(driver);
		adminPage.clickAdminMoreInfo();
		adminPage.clickEditAdmin();
		adminPage.clickUpdateAdmin();*/

		Assert.assertTrue(adminuserspage.isUpdateAlertDisplayed());
	}
}
