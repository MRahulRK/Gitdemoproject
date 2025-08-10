package Base;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




public class FindElement extends BaseTestLogin {
	
	// This class is used to find elements using Xpath from the Locators file
	// It uses WebDriverWait to ensure the element is visible before interacting with it
	
	private WebDriver driver;
    private Properties loc;
    
    
    public FindElement(WebDriver driver, Properties loc) {
        this.driver = driver;
        this.loc = loc;
    }

    public WebElement getElementByXpath(String propertyKey) throws IOException {
    	
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(loc.getProperty(propertyKey))
        ));
    }

	

	
	

}
