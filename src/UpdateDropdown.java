import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UpdateDropdown {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver Cdriver = new ChromeDriver();
		Cdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Cdriver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		Cdriver.manage().window().maximize();
		
		Cdriver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000L); 
		
		for(int i=1; i<4; i++) {
			Cdriver.findElement(By.id("hrefIncAdt")).click();
		}
		
		//  //a[@value='MAA']  - Xpath for chennai

		//  //a[@value='BLR']

		Cdriver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();

		Cdriver.findElement(By.xpath("//a[@value='BLR']")).click();

		Thread.sleep(2000);

		//driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();

		Cdriver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();

		Cdriver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();

	}

}
