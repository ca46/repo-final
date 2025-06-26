package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {

    @Test
    public void verifyTheUserIsAbleToLoginUsingValidCredential () throws IOException
	{
		//String username="admin";
		//String password="admin";
		String username=ExcelUtility.getStringData(1, 0, "loginpage");
		String password=ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterTheUsername(username);
		loginpage.enterThePassword(password);
		loginpage.clickSigninButton();
		boolean dashboardloaded=loginpage.isdashboardDisplayed();
		Assert.assertTrue(dashboardloaded);
	}
    @Test
    public void invalidUsernameAndCorrectPassword() throws IOException
	{
		
		//String username="password";
		//String password="admin";
		String username=ExcelUtility.getStringData(2, 0, "loginpage");
		String password=ExcelUtility.getStringData(2, 1, "loginpage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterTheUsername(username);
		loginpage.enterThePassword(password);
		loginpage.clickSigninButton();
		boolean alert=loginpage.isAlertMessageDisplayed();
		Assert.assertTrue(alert);
	}

    /*@Test
    public void correctUsernameAndIncorrectPassword() throws IOException {
        String username = ExcelUtility.getStringData(3, 0, "loginpage");
        String password = ExcelUtility.getStringData(3, 1, "loginpage");
        LoginPage loginpage = new LoginPage(driver);
        loginpage.enterTheUsername(username);
        loginpage.enterThePassword(password);
        loginpage.clickSigninButton();
        boolean alert = loginpage.isAlertMessageDisplayed();
        Assert.assertTrue(alert);
    }

    //@Test
    public void incorrectUsernameAndIncorrectPassword() throws IOException {
        String username = ExcelUtility.getStringData(4, 0, "loginpage");
        String password = ExcelUtility.getStringData(4, 1, "loginpage");
        LoginPage loginpage = new LoginPage(driver);
        loginpage.enterTheUsername(username);
        loginpage.enterThePassword(password);
        loginpage.clickSigninButton();
        boolean alert = loginpage.isAlertMessageDisplayed();
        Assert.assertTrue(alert);
    }

   // @Test
    public void emptyUsernameAndPassword() throws IOException {
        String username = ExcelUtility.getStringData(5, 0, "loginpage");
        String password = ExcelUtility.getStringData(5, 1, "loginpage");
        LoginPage loginpage = new LoginPage(driver);
        loginpage.enterTheUsername(username);
        loginpage.enterThePassword(password);
        loginpage.clickSigninButton();
        boolean alert = loginpage.isAlertMessageDisplayed();
        Assert.assertTrue(alert);
    }

    //@Test
    public void emptyUsernameValidPassword() throws IOException {
        String username = ExcelUtility.getStringData(6, 0, "loginpage");
        String password = ExcelUtility.getStringData(6, 1, "loginpage");
        LoginPage loginpage = new LoginPage(driver);
        loginpage.enterTheUsername(username);
        loginpage.enterThePassword(password);
        loginpage.clickSigninButton();
        boolean alert = loginpage.isAlertMessageDisplayed();
        Assert.assertTrue(alert);
    }

    //@Test
    public void validUsernameEmptyPassword() throws IOException {
        String username = ExcelUtility.getStringData(7, 0, "loginpage");
        String password = ExcelUtility.getStringData(7, 1, "loginpage");
        LoginPage loginpage = new LoginPage(driver);
        loginpage.enterTheUsername(username);
        loginpage.enterThePassword(password);
        loginpage.clickSigninButton();
        boolean alert = loginpage.isAlertMessageDisplayed();
        Assert.assertTrue(alert);
    }*/
}