package testscript;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtility;

@Test
public class ManageCategoryTest extends Base{
    
	@Test
	public void verifyTheUserIsAbleToAddCategoryInformations() throws IOException, AWTException
	{

    	String username=ExcelUtility.getStringData(1, 0, "loginpage");
 		String password=ExcelUtility.getStringData(1, 1, "loginpage");
 		String catgry=ExcelUtility.getStringData(1, 0,"managecategorypage");

 		LoginPage loginpage=new LoginPage(driver);
 		loginpage.enterTheUsername(username);
 		loginpage.enterThePassword(password);
 		loginpage.clickSigninButton();
 		
 		ManageCategoryPage managecategory=new ManageCategoryPage(driver);
 		managecategory.moreInfo();
 		managecategory.newButton();
 		managecategory.categoryInfo(catgry);
 		managecategory.selectGroup();
 		managecategory.fileUpload();
 		managecategory.saveInformations();
 		
 		boolean alertmsg=managecategory.isAlertMessageIsDisplayed();
 		Assert.assertTrue(alertmsg);
	}
}