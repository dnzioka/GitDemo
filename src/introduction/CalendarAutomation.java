package introduction;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarAutomation {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.drive", "C:/Users/Administrator/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://trippygotours.com/package/lamu-holiday-deals-3-5-days-flying-packages");

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// provide Month name and date of travel January 31
		// script to select it
		
		// select the month
		
		
		while (!driver.findElement(By.cssSelector("li[data-view='month current']")).getText().contains("March")) {
			driver.findElement(By.cssSelector("li[data-view='month next']")).click();
		}

		// select the date first
		driver.findElement(By.cssSelector("#show-form")).click();
		driver.findElement(By.id("enquiry_date")).click();
		// lets select January 31
		List<WebElement> dates = driver.findElements(By.className("day"));

		int count = driver.findElements(By.className("day")).size();

		// System.out.println(count);
		for (int i = 0; i < count; i++) {

			String text = driver.findElements(By.className("day")).get(i).getText();
			if (text.equalsIgnoreCase("30")) {
				driver.findElements(By.className("day")).get(i).click();
				break;
			}

		}

		

	}

}
