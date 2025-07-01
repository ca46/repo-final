package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.LoginPage;
import pages.ManageContactPage;
import utilities.ExcelUtility;

@Test
public class ManageContactTest extends Base {

	@Test(description="UPDATECONTACTINFORMATION")
	public void verifyUserCanUpdateContactInformation() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "loginpage");
		String password = ExcelUtility.getStringData(1, 1, "loginpage");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterTheUserName(username);
		loginPage.enterThePassword(password);
		loginPage.clickTheSignInButton();

		String phone = ExcelUtility.getIntegerData(1, 0, "contactpage");
		String email = ExcelUtility.getStringData(1, 1, "contactpage");
		String address = ExcelUtility.getStringData(1, 2, "contactpage");

		ManageContactPage contactPage = new ManageContactPage(driver);
		contactPage.clickContactMoreInfo();
		contactPage.clickEditContactIcon();
		contactPage.updatePhoneNumber(phone);
		contactPage.updateEmail(email);
		contactPage.updateAddress(address);
		contactPage.clickUpdateButton();

		boolean isAlertVisible = contactPage.isSuccessAlertDisplayed();
		Assert.assertTrue(isAlertVisible,Constants.UPDATECONTACTINFORMATION);
	}

	@Test(description="DISPLAYCONTACTINFORMATION")
	public void verifyUserCanDisplayContactInformation() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "loginpage");
		String password = ExcelUtility.getStringData(1, 1, "loginpage");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterTheUserName(username);
		loginPage.enterThePassword(password);
		loginPage.clickTheSignInButton();

		ManageContactPage contactPage = new ManageContactPage(driver);
		contactPage.clickContactMoreInfo();
		contactPage.clickEditContactIcon();
		contactPage.clickUpdateButton();

		boolean isAlertVisible = contactPage.isSuccessAlertDisplayed();
		Assert.assertTrue(isAlertVisible,Constants.DISPLAYCONTACTINFORMATION);
	}
}
