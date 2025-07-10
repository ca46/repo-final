package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageContactPage;
import pages.ManageFooterPage;
import utilities.ExcelUtility;

public class ManageFooterTest extends Base {
	public ManageFooterPage managefooterpage;
	public HomePage homepage;

	@Test(description="UPDATEFOOTER")
	public void verifyTheUserIsAbleToUpdateManageFooterTextInformation() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "loginpage");
		String password = ExcelUtility.getStringData(1, 1, "loginpage");
		String manageaddress = ExcelUtility.getStringData(1, 0, "footer");
		String manageemail = ExcelUtility.getStringData(1, 1, "footer");
		String managephoneno = ExcelUtility.getIntegerData(1, 2, "footer");

		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterTheUserName(username).enterThePassword(password);
		homepage=loginPage.clickTheSignInButton();
		managefooterpage=homepage.moreInfoManageFooter();
		managefooterpage.actionButton().addressFooterTextInfo(manageaddress).emailFooterTextInfo(manageemail).phonenumberFooterTextInfo(managephoneno).updateFooterTextInfo();
		
		/*loginpage.enterTheUserName(username);
		loginpage.enterThePassword(password);
		loginpage.clickTheSignInButton();

		String manageaddress = ExcelUtility.getStringData(1, 0, "footer");
		String manageemail = ExcelUtility.getStringData(1, 1, "footer");
		String managephoneno = ExcelUtility.getIntegerData(1, 2, "footer");

		ManageFooterPage managefooterpage = new ManageFooterPage(driver);
		managefooterpage.moreInfoManageFooter();
		managefooterpage.actionButton();
		managefooterpage.addressFooterTextInfo(manageaddress);
		managefooterpage.emailFooterTextInfo(manageemail);
		managefooterpage.phonenumberFooterTextInfo(managephoneno);
		managefooterpage.updateFooterTextInfo();*/

		boolean alertmsg = managefooterpage.isAlertMessageIsDisplayed();
		Assert.assertTrue(alertmsg,Constants.UPDATEFOOTER);
	}
}