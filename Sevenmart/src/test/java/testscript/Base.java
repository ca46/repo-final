package testscript;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constants.Constants;
import utilities.ScreenShotUtility;
import utilities.WaitUtility;

public class Base {

	WebDriver driver;
	public Properties properties;
	public FileInputStream fileinputstream;
	
	
	@Parameters("browser")
	@BeforeMethod(alwaysRun=true)
	public void browserInitialisation(String browser) throws Exception
	
	//public void browserInitialisation()
	{
		try {
			
			properties=new Properties();
			fileinputstream=new FileInputStream(Constants.CONFIGFILE);
			properties.load(fileinputstream);
			
			
		}catch(Exception e) {
			System.out.println("invalid");
		}
		
		   driver=new ChromeDriver();
		if(browser.equalsIgnoreCase("chrome"))
		{
			 driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		else
		{
			throw new Exception("invalid");
		}
		
		driver.get(properties.getProperty("url"));
		//driver.get("https://groceryapp.uniqassosiates.com/admin");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtility.IMPLICIT_WAIT));//implicit wait always give after loading URL
		
		driver.manage().window().maximize();
		
	}
	@AfterMethod(alwaysRun=true)
	public void browserQuit(ITestResult iTestResult) throws IOException { 
		if (iTestResult.getStatus() == ITestResult.FAILURE) { 
			ScreenShotUtility scrShot = new ScreenShotUtility(); 
			scrShot.getScreenShot(driver, iTestResult.getName()); 
		}
		driver.quit();
	}
	
}
