package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;

public class FileUploadUtility 
{
	public void fileUploadUsingSendkeys(WebElement element,String path)
	{
		element.sendKeys(path);
	}
	
	public void fileUploadUsingRobotClass(WebElement element,String path) throws AWTException
	{
		element.click();//
		StringSelection strselection=new StringSelection(path);//give file path to String selection class 
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strselection, null);//then the path is copied to clipboard
		Robot robot=new Robot();//upload starts using Robot class here
		robot.delay(3000);
		robot.keyPress(KeyEvent.VK_CONTROL);//ctrl, this and the following lne is to perform Ctrl+V(paste)
		robot.keyPress(KeyEvent.VK_V);//V
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyPress(KeyEvent.VK_ENTER);//perform Enter
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

}
