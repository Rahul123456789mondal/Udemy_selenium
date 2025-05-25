package TestNGPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HRMTest {
	
	WebDriver driver;
	
  @Test(priority=1)
  public void openApp() {
	  
	  driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	  driver.get("https://opensource-demo.orangehrmlive.com/");
	  
  }
  
  @Test(priority=2)
  public void testLogo() {
	  
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	  WebElement logo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='OrangeHRM']")));
	  System.out.println(logo.isDisplayed());
	  
  }
  
  @Test(priority=3)
  public void testLogin() {
	  
	  driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
	  driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
	  driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
	  
  }
  
}
