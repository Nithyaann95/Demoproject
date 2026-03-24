package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.Homepage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base

{
	public Homepage homepage;
	public ManageNewsPage managenewspage;
	@Test
	public void verifyTheUserAbleToManageNewsPage() throws IOException  // valid Username and password
	{
		
			//String username= "admin";           // valid username and valid password
			//String password= "admin";
			
			String username=ExcelUtility.readStringData(1, 0, "LoginPage"); // reading from excel file
			String password=ExcelUtility.readStringData(1, 1, "LoginPage");
			String text=ExcelUtility.readStringData(0, 0, "ManageNewsPage");
			
			LoginPage loginpage=new LoginPage(driver);
			
			loginpage.enterTheUsername(username).enterThePassword(password);
		//	loginpage.enterThePassword(password);
			homepage=loginpage.clickOnSigninButton();
			
			//ManageNewsPage newspage=new ManageNewsPage(driver);
			managenewspage=	homepage.clickOnManageNewsMoreInfo();	
			managenewspage.clickOnNewTab().enterNews(text).clickOnSave();
			
			
			//newspage.enterNews(text);
			//newspage.clickOnSave();
			boolean alertMessage = managenewspage.alertDisplay();
			Assert.assertTrue(alertMessage);
	}
	
}
