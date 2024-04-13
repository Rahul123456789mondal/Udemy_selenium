import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Introtwo {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver Cdriver = new ChromeDriver();
		Cdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Cdriver.get("https://rahulshettyacademy.com/locatorspractice/");
		Cdriver.findElement(By.id("inputUsername")).sendKeys("rahul");
		Cdriver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");
		Cdriver.findElement(By.id("chkboxOne")).click();
		Cdriver.findElement(By.cssSelector("#chkboxTwo")).click();
		Cdriver.findElement(By.className("submit")).click();
		Thread.sleep(2000);
		System.out.println(Cdriver.findElement(By.tagName("p")).getText());
		Assert.assertEquals(Cdriver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		
	}

}


/*   ******* For Headless Use Code 
 * 
 * 
 * 	ChromeOptions options = new ChromeOptions();
	options.addArguments("--headless");
	options.addArguments("start-maximized");
	WebDriver driver = new ChromeDriver(options);
 * 
 * 	ChromeOptions options = new ChromeOptions();
	options.addArguments("--headless");
	options.addArguments("--window-size=1400,600");
	WebDriver driver = new ChromeDriver(options);
 * 
 * */
