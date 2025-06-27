package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageContactPage;
import utilities.ExcelUtility;

@Test
public class ManageContactTest extends Base {

    @Test
    public void verifyUserCanUpdateContactInformation() throws IOException {
        String username = ExcelUtility.getStringData(1, 0, "loginpage");
        String password = ExcelUtility.getStringData(1, 1, "loginpage");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterTheUsername(username);
        loginPage.enterThePassword(password);
        loginPage.clickSigninButton();

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
        Assert.assertTrue(isAlertVisible);
    }

    @Test
    public void verifyUserCanDisplayContactInformation() throws IOException {
        String username = ExcelUtility.getStringData(1, 0, "loginpage");
        String password = ExcelUtility.getStringData(1, 1, "loginpage");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterTheUsername(username);
        loginPage.enterThePassword(password);
        loginPage.clickSigninButton();

        ManageContactPage contactPage = new ManageContactPage(driver);
        contactPage.clickContactMoreInfo();
        contactPage.clickEditContactIcon();
        contactPage.clickUpdateButton();

        boolean isAlertVisible = contactPage.isSuccessAlertDisplayed();
        Assert.assertTrue(isAlertVisible);
    }
}
