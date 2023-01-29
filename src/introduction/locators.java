package introduction;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class locators {

	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.drive", "C:/Users/Administrator/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		//access the method below
		String finalpass = getPassword(driver);
		
		String name = "rahul";
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.name("inputPassword")).sendKeys(finalpass);
		driver.findElement(By.className("signInBtn")).click();
		//driver.findElement(By.cssSelector(".logout-btn")).click();
		//Thread.sleep(2000);
		//System.out.println(driver.findElement(By.cssSelector(".error")).getText());
		// xpath locator
		//driver.findElement(By.xpath("//a[normalize-space()='Forgot your password?']")).click();
		//By linktext locator - > Forgot your password?
		//driver.findElement(By.linkText("Forgot your password?")).click();
		//driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("dominic");
		//driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("dominic@gmail.com");
		//driver.findElement(By.cssSelector("input[placeholder='Phone Number']")).sendKeys("0720222524");
		//driver.findElement(By.xpath("//button[normalize-space()='Reset Login']")).click();
		//System.out.println(driver.findElement(By.cssSelector(".infoMsg")).getText());
		driver.close();
	}
	public static String getPassword(WebDriver driver) throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[normalize-space()='Reset Login']")).click();
		String passwordText = (driver.findElement(By.cssSelector(".infoMsg")).getText());
		driver.findElement(By.cssSelector(".go-to-login-btn")).click();
		Thread.sleep(1000);
		// Please use temporary password ' rahulshettyacademy' to Login.
		String [] passwordArray = passwordText.split("'");
		String [] exactpass = passwordArray[1].split("'");
		return exactpass[0];
		
		
		
		
	}
	
	
}
