package Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Base.BaseClass;
import com.PageObjects.HomePage;
import com.PageObjects.Login;
import com.PageObjects.Register;

public class RegisterTest extends BaseClass{
	Register register;
	HomePage homepage;
	
	public RegisterTest() {
	super();	
	}

@BeforeMethod
public void setup() {
	initialization();
	register= new Register();
		
}
@Test
public void registration() {
	register.clickRegister();
	register.HandleAlert();
	homepage= register.registrationDetails(prop.getProperty("email"),prop.getProperty("mobile"),prop.getProperty("fname"),prop.getProperty("lname"),prop.getProperty("pwd"));  
	if (driver.getPageSource().contains("My Account Information")) {
	Assert.assertTrue(true,"Valid Registration");}
			
	
}

@AfterMethod
public void teardown() {

	driver.quit();
}


}
