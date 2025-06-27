package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageFooterPage;
import utilities.ExcelUtility;

public class ManageFooterTest extends Base
{

	@Test
	public void verifyTheUserIsAbleToUpdateManageFooterTextInformation() throws IOException
	{
		String username=ExcelUtility.getStringData(1, 0, "loginpage");
		String password=ExcelUtility.getStringData(1, 1, "loginpage");

		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterTheUsername(username);
		loginpage.enterThePassword(password);
		loginpage.clickSigninButton();
		
		String manageaddress=ExcelUtility.getStringData(1, 0, "footer");
		String manageemail=ExcelUtility.getStringData(1, 1, "footer");
		String managephoneno=ExcelUtility.getIntegerData(1, 2, "footer");
		
		ManageFooterPage managefooterpage=new ManageFooterPage(driver);
		managefooterpage.moreInfoManageFooter();
		managefooterpage.actionButton();
		managefooterpage.addressFooterTextInfo(manageaddress);
		managefooterpage.emailFooterTextInfo(manageemail);
		managefooterpage.phonenumberFooterTextInfo(managephoneno);
		managefooterpage.updateFooterTextInfo();
		
		boolean alertmsg=managefooterpage.isAlertMessageIsDisplayed();
		Assert.assertTrue(alertmsg);
	}
}