package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class E2EflightbookingUI {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.drive", "C:/Users/Administrator/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		// select from city
		driver.findElement(By.cssSelector("#ctl00_mainContent_ddl_originStation1_CTXT")).click();
		// select to city
		driver.findElement(By.cssSelector("a[value='HYD']")).click();
		Thread.sleep(2000); // pause the driver for 2 sec
		driver.findElement(By.xpath(
				"//body[1]/form[1]/div[4]/div[2]/div[1]/div[5]/div[2]/div[2]/div[2]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/div[3]/div[1]/div[1]/ul[1]/li[11]/a[1]"))
				.click();
		// select from date
		driver.findElement(By.xpath("//a[normalize-space()='29']")).click();
		// select the 5 passengers
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(1000);
		// Loop to add people
		for (int i = 1; i < 7; i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		driver.findElement(By.id("btnclosepaxoption")).click();

		// select currency from the staticdropdown
		WebElement drops = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropdown = new Select(drops);
		dropdown.selectByVisibleText("AED");

		driver.findElement(By.cssSelector("#ctl00_mainContent_btn_FindFlights")).click();
	}

}
