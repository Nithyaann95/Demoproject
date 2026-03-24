package testscript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Login  extends Base
{
@Test
	public void verifyTheUserisAbleToLoginUsingValidCredentials()
	{
		String username= "admin";
		String password= "admin";
		WebElement userfield=driver.findElement(By.xpath("//input[@placeholder='Username']"));
		userfield.sendKeys(username);
		WebElement passwordfield=driver.findElement(By.xpath("//input[@placeholder='Password']"));
		passwordfield.sendKeys(password);
		WebElement signfield=driver.findElement(By.xpath("//button[text()='Sign In']"));
		signfield.click();
		
	}
@Test
public void verifyTheUserisAbleToLoginUsingInvalidValidPassword()
{
	String username= "jiji123";
	String password= "admin";
	WebElement userfield=driver.findElement(By.xpath("//input[@placeholder='Username']"));
	userfield.sendKeys(username);
	WebElement passwordfield=driver.findElement(By.xpath("//input[@placeholder='Password']"));
	passwordfield.sendKeys(password);
	WebElement signfield=driver.findElement(By.xpath("//button[text()='Sign In']"));
	signfield.click();
}

}
