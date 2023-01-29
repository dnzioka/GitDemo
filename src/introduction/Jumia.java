package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Jumia {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.drive", "C:/Users/Administrator/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.jumia.co.ke/oraimo-senior-bt5.0-single-wireless-bluetooth-headsets-48096423.html");
		 
		driver.findElement(By.cssSelector("button[class='add btn _prim -pea _i -fw']")).click();

	}

}
