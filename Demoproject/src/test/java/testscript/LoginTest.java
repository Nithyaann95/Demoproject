package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Homepage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base

{
	public Homepage homepage;
	
	@Test(groups="regression") //retry class Retry package
public void verifyTheUserisAbleToLoginUsingValidCredentials() throws IOException  // valid username and password
{
	
		//String username= "admin";           // valid username and valid password
		//String password= "admin";
		
		String username=ExcelUtility.readStringData(1, 0, "LoginPage"); // reading from excel file
		String password=ExcelUtility.readStringData(1, 1, "LoginPage");
		
		LoginPage loginpage=new LoginPage(driver);
		
		loginpage.enterTheUsername(username).enterThePassword(password);
	//	loginpage.enterThePassword(password);
		homepage=loginpage.clickOnSigninButton();
		boolean homepage=loginpage.isDashboardDisplayed(); //result is storing in homepage variable
		Assert.assertTrue(homepage);  // using for validation
}
	
	@Test
	public void verifyTheUserisAbleToLoginUsingInvalidusernameandvalidpassword() throws IOException  // invalid username and valid password
	{
		
			//String username= "admininin";
			//String password= "admin";
			
		String username=ExcelUtility.readStringData(2, 0, "LoginPage");
		String password=ExcelUtility.readStringData(2, 1, "LoginPage");		
			LoginPage loginpage=new LoginPage(driver);
			
			loginpage.enterTheUsername(username);
			loginpage.enterThePassword(password);
			loginpage.clickOnSigninButton();
			
		boolean homepage=loginpage.isAlertDisplayed();
		Assert.assertTrue(homepage);
	}
	
	@Test
	public void verifyTheUserisAbleToLoginUsingValidusernameandinvalidPassword() throws IOException // valid username and invalid password
	{
		
			//String username= "admin";
			//String password= "adminnjnj";
			
			String username=ExcelUtility.readStringData(3, 0, "LoginPage");
			String password=ExcelUtility.readStringData(3, 1, "LoginPage");		
			
			LoginPage loginpage=new LoginPage(driver);
			
			loginpage.enterTheUsername(username);
			loginpage.enterThePassword(password);
			loginpage.clickOnSigninButton();
	}
	
	@Test
	public void verifyTheUserisAbleToLoginUsingInvalidValidusernameandPassword() throws IOException //invalid username and ininvalid password
	{
		
			//String username= "admin3rfw";
			//String password= "adminnjnj";
			
			String username=ExcelUtility.readStringData(4, 0, "LoginPage");
			String password=ExcelUtility.readStringData(4, 1, "LoginPage");		
			
			LoginPage loginpage=new LoginPage(driver);
			
			loginpage.enterTheUsername(username);
			loginpage.enterThePassword(password);
			loginpage.clickOnSigninButton();
	}
	
}
