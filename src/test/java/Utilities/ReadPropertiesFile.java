package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertiesFile {

	public static void main(String[] args) throws IOException {
		Properties pr = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\Hrishitha V M\\OneDrive\\Desktop\\Zohoauto\\AutomationFrameWork\\src\\test\\resources\\TestData\\Config.Properties");
		pr.load(fis);
		pr.getProperty("browser");
		pr.getProperty("TestURL");
		System.out.println(pr.getProperty("Browser"));
		System.out.println(pr.getProperty("TestURL"));
		pr.setProperty("Rahull", "Is Great");
		
	//	FileOutputStream fos = new FileOutputStream("C:\\Users\\Hrishitha V M\\OneDrive\\Desktop\\Zohoauto\\AutomationFrameWork\\src\\test\\resources\\TestData\\Config.Properties");
		pr.setProperty("Rahul", "Is Great");
	//	pr.store(fos, "rahul");
	
	
	}
	
	

}
	