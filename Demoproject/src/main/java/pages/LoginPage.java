package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class LoginPage 

{
public WebDriver driver;
@FindBy(xpath="//input[@placeholder='Username']")WebElement userfield; //@FindBy Locate elements using annotations
@FindBy(xpath="//input[@placeholder='Password']")WebElement passwordfield;
@FindBy(xpath="//button[text()='Sign In']")WebElement signfield;
@FindBy(xpath="//p[text()='Dashboard']")WebElement dashboard;
@FindBy(xpath="//div [contains(@class,'alert-dismissible')]")WebElement alert;

public LoginPage(WebDriver driver) 
{
	this.driver=driver;
	PageFactory.initElements(driver,this);  //PageFactory :Initialize elements
}

public LoginPage enterTheUsername(String username) 
{
	
	userfield.sendKeys(username);
	return this;
}
public LoginPage enterThePassword(String password)
{
	passwordfield.sendKeys(password);
	return this;
}
public Homepage clickOnSigninButton()
{
	signfield.click();
	return new Homepage(driver);
}

//public void dropDown()
//{
//	PageUtility page=new PageUtility();
//	page.dropDownVisibleText(drop, "drop");
//	
//}
public boolean isDashboardDisplayed() //checking dashboard displayed or not
{
	return dashboard.isDisplayed();
}
public boolean isAlertDisplayed()
{
	return alert.isDisplayed();
}

}

