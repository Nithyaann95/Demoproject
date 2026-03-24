package testscript;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constant.Constant;
import utilities.ScreenshotUtility;


public class Base 

{
	//WebDriver : its an interface in selenium
	//            powerful automation tool,widely using selenium, webdriver controlling behaviours like navigation ,click..
	//            It also supporting different browsers,different prgming languages,different OS.
	
public 	WebDriver driver; 
public Properties properties;
public FileInputStream fileinput;
@BeforeMethod(alwaysRun=true)

@Parameters("browser")
public void browserinitalization(String browser) throws Exception
{
	try 
	 {
		properties= new Properties();
		fileinput=new FileInputStream(Constant.CONFIGFILE);
		properties.load(fileinput);
	 }
	catch(Exception e)
	{
		System.out.println(e);
	}
	if(browser.equalsIgnoreCase("chrome"))
	{
		
	driver=new ChromeDriver(); // open the chrome browser   , WebDriver -interface  ChromeDriver-class
	}
	else if(browser.equalsIgnoreCase("Firefox"))
	{
		driver=new FirefoxDriver();
	}
	else
	{
		throw new Exception("invalid");
	}
	//driver.get("https://groceryapp.uniqassosiates.com/admin"); //opens the given URL
	driver.get(properties.getProperty("url"));
	driver.manage().window().maximize();  // maximize the browser window
		
}
//@AfterMethod(alwaysRun=true)
	
	public void browserQuitAndClose(ITestResult iTestResult) throws IOException 
	{
		if(iTestResult.getStatus()==iTestResult.FAILURE) //iTestResult
		{
			ScreenshotUtility screenshot=new ScreenshotUtility();
			screenshot.getScreenShot(driver, iTestResult.getName());//passing 
		}
		
		driver.quit();
	}
}




