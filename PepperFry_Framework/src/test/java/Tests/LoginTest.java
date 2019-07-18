package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Base.BaseClass;
import com.PageObjects.HomePage;
import com.PageObjects.Login;


public class LoginTest extends BaseClass{
	Login login;
	HomePage homepage;
	
		public LoginTest() {
		super();	
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		login= new Login();
			
	}
	@Test
	public void validLogin() {
		login.clickMyAcc();
		login.HandleAlert();
		homepage= login.enter(prop.getProperty("username"),prop.getProperty("password"));
		if (driver.getPageSource().contains("My Account Information")) {
		Assert.assertTrue(true,"Valid user login");}
				
		
	}

	@AfterMethod
	public void teardown() {

		driver.quit();
	}

}
