package utilities;

import java.sql.Driver;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility 
{

	// DropDown methods:
	public void dropDownByVisibleText(WebElement element,String text)
	{
		Select drop=new Select(element);
		drop.selectByVisibleText(text);
		
	}
	
	public void dropDownByIndex(WebElement element,int index)
	{
		Select drop=new Select(element);
		drop.selectByIndex(index);
	}
	public void dropDownByValue(WebElement element,String value)
	{
		Select drop=new Select(element);
		drop.selectByValue(value);;
	}
	
	// Action Handling
	
	public void actionHandlingDragAndDrop(WebDriver driver, WebElement source, WebElement target)
	{
		Actions action=new Actions(driver);
		action.dragAndDrop(source, target).perform();
	}
	public void actionHandlingRightClick(WebDriver driver, WebElement rightclick) 
	{
		Actions action=new Actions(driver);
		action.contextClick(rightclick).perform();
	}
	public void actionHandlingMouseOver(WebDriver driver, WebElement mouseover) 
	{
		Actions action=new Actions(driver);
		action.moveToElement(mouseover).perform();
	}
	public void actionHandlingDoubleClick(WebDriver driver, WebElement doubleclick) 
	{
		Actions action=new Actions(driver);
		action.doubleClick(doubleclick).perform();
	}
	
	// Alert:
	public void simpleAlert(WebDriver driver)
	{
		Alert alert=driver.switchTo().alert();
		alert.accept();
	}
	public void confirmationAlertaccept(WebDriver driver)
	{
		Alert alert=driver.switchTo().alert();
		alert.accept();	
	}
	public void confirmationAlertacceptdismiss(WebDriver driver)
	{
		Alert alert=driver.switchTo().alert();
		alert.dismiss();
	}
	public void promtAlertSendKeys(WebDriver driver,String text)
	{
		Alert alert=driver.switchTo().alert();
		alert.sendKeys(text);
	}
	public void promtAlertAccept(WebDriver driver)
	{
		Alert alert=driver.switchTo().alert();
		alert.accept();	
	}
	public void promtAlertDismiss(WebDriver driver)
	{
		Alert alert=driver.switchTo().alert();
		alert.dismiss();
	}
	
// JavaScript :	
//	JavascriptExecutor js = (JavascriptExecutor) driver;
//	js.executeScript("arguments[0].value='value';", WebElement name);
//	js.executeScript("arguments[0].click();", WebElement name);
	
	public void javaScriptExecutorValue(WebDriver driver, WebElement element,String value)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver ;
		js.executeScript("arguments[0].value='value';", element);
	}
	
	public void javaScriptExecutorClick(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver ;
		js.executeScript("arguments[0].click();", element);
	}
}


