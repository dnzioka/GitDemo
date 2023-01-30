package introduction;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Childwindows {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.drive", "C:/Users/Administrator/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.cssSelector(".blinkingText")).click();
		// redirect the driver to the child window
		//get the id of the windows
		Set <String> windows = driver.getWindowHandles(); // parentid, childid
		// to get the the childid we iterate through the set
		 Iterator <String> it = windows.iterator();
		 String parentid =  it.next(); //grad the id for the parent
		 String Childid= it.next(); //moves to the sexond index which has child Id
		 
		driver.switchTo().window(Childid);
		String sentence = driver.findElement(By.cssSelector(".im-para.red")).getText();
		String[] sentence1 = sentence.split("at");
		String [] sentence2 = sentence1[1].split("with");
		String emailid = sentence2[0].trim();
		//System.out.println(emailid);
		
		driver.switchTo().window(parentid);
		driver.findElement(By.id("username")).sendKeys(emailid);
		
		
		

	}

}
