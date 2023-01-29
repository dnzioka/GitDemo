package introduction;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Explicitwait {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.drive", "C:/Users/Administrator/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebDriverWait we = new WebDriverWait(driver, 5);

		String[] veges = { "Cucumber", "Brocolli", "Beetroot", "Beans", "Capsicum" };
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		Thread.sleep(3000);
		// addItems(driver,veges );
		Explicitwait meth = new Explicitwait();
		meth.addItems(driver, veges);
		
		//click on cart
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='PROCEED TO CHECKOUT']")).click();
		driver.findElement(By.cssSelector("input[placeholder='Enter promo code']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector(".promoBtn")).click();
		// ExplicitWait
		
		we.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoInfo")));
		
		System.out.println(driver.findElement(By.cssSelector(".promoInfo")).getText());
		

	}

	public void addItems(WebDriver driver, String[] veges) {

		int j = 0;
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

		for (int i = 0; i < products.size(); i++) {

			String Item = products.get(i).getText();

			// format the product name to match the search
			String[] itemformat = Item.split("-");

			// if a item name of what we want appears
			// check whether name you extracted is present in array or not
			// convert the array to arrayList for easy search
			// array take small memories
			// arraylist are used for complicated arrays

			List veglist = Arrays.asList(veges);
			if (veglist.contains(itemformat[0].trim())) {
				j++;
				// click to add to cart
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if (j == veges.length) {
					break;
				}

			}

		}

	}

}
