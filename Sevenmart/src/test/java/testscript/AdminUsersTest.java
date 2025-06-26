package testscript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminUsersPage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUsersTest extends Base{
   
	@Test(retryAnalyzer=retry.Retry.class)
	public void verifyTheUserIsAbleToCreateTheAdminUsers() throws IOException
	{
		       
				
		        String username=ExcelUtility.getStringData(1, 0, "loginpage");
		        String password=ExcelUtility.getStringData(1, 1, "loginpage");
				
				LoginPage loginpage=new LoginPage(driver);
				loginpage.enterTheUsername(username);
				loginpage.enterThePassword(password);
				loginpage.clickSigninButton();
				
				AdminUsersPage adminuserspage=new AdminUsersPage(driver);
				
				FakerUtility fakerutility=new FakerUtility();
				
				String adminusername=fakerutility.creatARandomFirstName();
				String adminpassword=fakerutility.creatARandomFirstName();
				
				
				adminuserspage.clickMoreInformationAdmin();
				adminuserspage.clickNewButton();
				adminuserspage.enterUserName(adminusername);
				adminuserspage.enterPassword(adminpassword);
				adminuserspage.selectUserType();
				adminuserspage.saveAdminUsers();
				boolean alertmsg=adminuserspage.displayAlertMessage();
				Assert.assertTrue(alertmsg);
	}
	
	@Test
	public void verifyTheUserIsAbleToUpdateTheAdminUsers() throws IOException
	{
		String username=ExcelUtility.getStringData(1, 0, "loginpage");
        String password=ExcelUtility.getStringData(1, 1, "loginpage");
        
        LoginPage loginpage=new LoginPage(driver);
		loginpage.enterTheUsername(username);
		loginpage.enterThePassword(password);
		loginpage.clickSigninButton();
		
		AdminUsersPage adminuserspage=new AdminUsersPage(driver);
		adminuserspage.clickMoreInformationAdmin();
		adminuserspage.editAdminUsers();
		adminuserspage.updateAdminUsers();
		boolean alert=adminuserspage.displayAlert();
		Assert.assertTrue(alert);
	}
}