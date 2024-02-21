package first;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class firstsele {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecho.driver", "C:\\eclipse\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://www.rahulshettyacademy.com/locatorspractice/");
		System.out.println(driver.getTitle());
		
		System.out.println(driver.getCurrentUrl());
		driver.quit();
		
		
	}

}
