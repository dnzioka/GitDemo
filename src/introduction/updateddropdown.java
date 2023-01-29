package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class updateddropdown {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.drive", "C:/Users/Administrator/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(1000);
		//driver.findElement(By.id("hrefIncAdt")).click(); // added one passenger
		// to select multiple passengers
		// we use while loops
		int i = 1;
		while (i<5)
		{
			driver.findElement(By.id("hrefIncAdt")).click(); // clicked 4 times
			i++;
		}
		
		driver.findElement(By.id("btnclosepaxoption")).click();
	}

}
