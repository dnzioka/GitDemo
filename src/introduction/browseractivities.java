package introduction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class browseractivities {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.drive", "C:/Users/Administrator/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.navigate().to("https://rahulshettyacademy.com/locatorspractice/");
		driver.navigate().back();
		//driver.navigate().forward();
		//driver.close();

	}

}
