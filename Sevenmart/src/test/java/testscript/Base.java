package testscript;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Base {

WebDriver driver;
	
    @Test
	@BeforeMethod
   public void browserInitialisation()
    {
        driver=new ChromeDriver();
    	driver.get("https://groceryapp.uniqassosiates.com/admin");
    	driver.manage().window().maximize();
    	
    }
	
    @Test
    @AfterMethod
	public void driverQuit() {
		//driver.close();
    	driver.quit();
		
	}
}
