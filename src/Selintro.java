import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Selintro {

	public static void main(String[] args) throws InterruptedException {
		
		// Chrome Driver Set-Up
		//WebDriver driver = new ChromeDriver();
		
		// Fire-fox setup 
		//System.setProperty("webdriver.gecko.driver", "C://Users//CODECLOUDS-ARKA//Documents//geckodriver-v0.33.0-win64//geckodriver.exe");
		WebDriver fdriver = new FirefoxDriver();
		fdriver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		// Implicit wait implementation 
		fdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		System.out.println(fdriver.getTitle());
		System.out.println(fdriver.getCurrentUrl());
		Thread.sleep(10);
		
		fdriver.findElement(By.id("inputUsername")).sendKeys("Arka Mondal");
		fdriver.findElement(By.name("inputPassword")).sendKeys("Arka123456");
		fdriver.findElement(By.className("submit")).click();
		
		// Introduction CSS Selectors 
		System.out.println(fdriver.findElement(By.cssSelector("p.error")).getText());
		
		fdriver.findElement(By.linkText("Forgot your password?")).click();
		fdriver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Arka Mondal");
		fdriver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("arka.mondal@codeclouds.co.in");
		fdriver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		fdriver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("arka.mondal@codeclouds.co.in");
		fdriver.findElement(By.xpath("//form/input[3]")).sendKeys("7001945080");
		fdriver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		
		System.out.println(fdriver.findElement(By.cssSelector(".infoMsg")).getText());
		
		fdriver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		fdriver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");
		fdriver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
		fdriver.findElement(By.id("chkboxOne")).click();
		fdriver.findElement(By.cssSelector("#chkboxTwo")).click();
		fdriver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
		
		//fdriver.close();

	}

}
