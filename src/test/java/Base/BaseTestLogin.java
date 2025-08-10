package Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTestLogin {

	public static Properties pr = new Properties();
	public static Properties loc = new Properties();
	public static WebDriver driver;
	public static FileInputStream fisPr;
	public static FileInputStream fisLoc;

	@BeforeTest
	public void login() throws IOException {

		if (driver == null) {
			
			
//			fisPr = new FileInputStream(
//				    System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator +
//				    "resources" + File.separator + "TestData" + File.separator + "Config.Properties"
//				);
//			fisLoc = new FileInputStream(
//				    System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator +
//				    "resources" + File.separator + "TestData" + File.separator + "Locaters.Properties"
//				);

			
			fisPr = new FileInputStream(
				    Paths.get(System.getProperty("user.dir"), "src", "test", "resources", "TestData", "Config.Properties").toFile()
				);
			fisLoc = new FileInputStream(
				    Paths.get(System.getProperty("user.dir"), "src", "test", "resources", "TestData", "Locaters.Properties").toFile()
				);

			
	//		fisPr = new FileInputStream(
	//				System.getProperty("user.dir") + "\\src\\test\\resources\\TestData\\Config.Properties");
	//		fisLoc = new FileInputStream(
	//				System.getProperty("user.dir") + "\\src\\test\\resources\\TestData\\Locaters.Properties");
			pr.load(fisPr);
			loc.load(fisLoc);
			
			if (fisLoc == null) {
                throw new IOException("Config.Properties file not found in resources/TestData");
            }
			if (fisPr == null) {
				throw new IOException("Locaters.Properties file not found in resources/TestData");
			}

		}

		if (pr.getProperty("Browser").equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(pr.getProperty("TestURL"));

		} else if (pr.getProperty("Browser").equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get(pr.getProperty("TestURL"));

		}

	}

	@AfterTest
	public void closeBrowser() {
		if (driver != null) {
			driver.close();
			System.out.println("Browser closed successfully.");
		}

	}

}
