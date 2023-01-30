package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Frames {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.drive", "C:/Users/Administrator/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");
		// frame using webElement locator since the frame doesn't have id
		// now we can access it
		// access it by weblement

		// how to know how many Elements are present in the webpage

		System.out.println(driver.findElements(By.tagName("iframe")).size());
		// access the frames and later come out
		driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));

		// access it by index -> only one at index 0
		// driver.switchTo().frame(0);

		// Action class will help us to drag itF
		Actions fram = new Actions(driver);
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));

		fram.dragAndDrop(source, target).build().perform();

		// after access the frame, we need to come out of the frame to access other
		// elements
		driver.switchTo().defaultContent();
		driver.findElement(By.cssSelector("a[href='http://jqueryui.com/accordion/']")).click();

	}

}
