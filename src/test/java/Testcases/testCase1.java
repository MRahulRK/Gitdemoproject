package Testcases;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.BaseTestLogin;

import java.time.Duration;

public class testCase1 extends BaseTestLogin {

	public static void main(String[] args) {
		
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
//		
//		driver.get("https://www.zoho.com/");
		System.out.println("Title of the page is: " + driver.getTitle());
		System.out.println("Current URL is: " + driver.getCurrentUrl());

		driver.findElement(By.linkText(loc.getProperty(""))).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("login_id"))));
		driver.findElement(By.xpath("//input[@id='login_id']")).sendKeys("rahulharidasrkm@gmail.com");
		
		driver.findElement(By.xpath("//*[@id=\"nextbtn\"]/span")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']")));
		
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Autowms@620");
		
		driver.findElement(By.xpath("//*[@id=\"nextbtn\"]/span")).click();
		

	}


}