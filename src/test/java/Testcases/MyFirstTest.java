package Testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Base.BaseTestLogin;
import Base.FindElement;

public class MyFirstTest extends BaseTestLogin  {
	
	
	
	@Test
	public void testCaseNumber1() throws IOException {

		FindElement findElementXpath= new FindElement(driver, loc);
		driver.findElement(By.linkText(loc.getProperty("obj_SignIn"))).click();
		
		
		WebElement weUserId=findElementXpath.getElementByXpath("obj_EnteruserID");
		weUserId.sendKeys("rahulharidasrkm@gmail.com");
		
		WebElement weNext=findElementXpath.getElementByXpath("obj_Next");
		weNext.click();

		
		WebElement wePassword=findElementXpath.getElementByXpath("obj_EnterPassword");
		wePassword.sendKeys("Autowms@620");
		
		weNext=findElementXpath.getElementByXpath("obj_Next");
		weNext.click();
		

	}

}
