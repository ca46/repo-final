package testscript;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base{
	
	@Test
	
	public void verifyTheUserIsAbleToEnterTheNews() throws IOException
	{

		
		String username=ExcelUtility.getStringData(1, 0,"loginpage");
		String password=ExcelUtility.getStringData(1, 1,"loginpage");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterTheUsername(username);
		loginpage.enterThePassword(password);
		loginpage.clickSigninButton();
		
		String news=ExcelUtility.getStringData(1, 0,"managenews");
		
		ManageNewsPage managenewspage=new ManageNewsPage(driver);
		managenewspage.clickMoreInformation();
		managenewspage.clickNewButton();
		managenewspage.enterNewsInformation(news);
		managenewspage.saveNews();
		boolean alertmessage=managenewspage.displayAlertMessage();
		Assert.assertTrue(alertmessage);
		
	}
	
	//@Test
	public void verifyTheUserIsAbleToUpdateTheNews() throws IOException
	{
		
		String username=ExcelUtility.getStringData(1, 0,"loginpage");
		String password=ExcelUtility.getStringData(1, 1,"loginpage");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterTheUsername(username);
		loginpage.enterThePassword(password);
		loginpage.clickSigninButton();
		
		ManageNewsPage managenewspage=new ManageNewsPage(driver);
		managenewspage.clickMoreInformation();
		managenewspage.editNews();
		managenewspage.updateNews();
		managenewspage.displayAlert();
		
		boolean alertmsg=managenewspage.displayAlertMessage();
		Assert.assertTrue(alertmsg);
		
	}
}