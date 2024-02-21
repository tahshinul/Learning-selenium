package first;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import net.bytebuddy.dynamic.TypeResolutionStrategy.Passive;
public class locators {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
//		System.setProperty("webdriver.gecho.driver", "C:\\eclipse\\geckodriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.google.com");
		driver.navigate().to("http://www.rahulshettyacademy.com/locatorspractice/");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.id("inputUsername")).sendKeys("tahshin");
		driver.findElement(By.name("inputPassword")).sendKeys("asdsasd");
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.id("chkboxTwo")).click();
		Thread.sleep(1000);
		driver.findElement(By.className("signInBtn")).click();
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.cssSelector(".error")).getText());
		Thread.sleep(1000);
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Tahshin");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("khashi@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Email']")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("tahshin123@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("01875517992");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@class='reset-pwd-btn']")).click();
		Thread.sleep(1000);
		
		
		
//		System.out.println(driver.findElement(By.xpath("//p[@class='infoMsg']")).getText());
//		
		String pass = getPass(driver); 
		
		
		driver.findElement(By.xpath("//button[@class='go-to-login-btn']")).click();
		Thread.sleep(1000);
		String name = "Tahshin";
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.name("inputPassword")).sendKeys(pass);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(1000);
		
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),"Hello "+name+",");
		Thread.sleep(1000);
		
		
		
		driver.findElement(By.xpath("//button[@class='logout-btn']")).click();
		driver.navigate().back();
		driver.quit();
	}
	
	public static String getPass(WebDriver driver) throws InterruptedException {
//		driver.get("http://www.rahulshettyacademy.com/locatorspractice/");
//		driver.findElement(By.linkText("Forgot your password?")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//button[@class='reset-pwd-btn']")).click();
		String psring = driver.findElement(By.xpath("//p[@class='infoMsg']")).getText();
		String x[] =   psring.split("'");
		String y[] = x[1].split(",");
		return y[0];
	}
}
