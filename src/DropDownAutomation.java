import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropDownAutomation {

	public static void main(String[] args) throws InterruptedException {

		// Static Drop Down Implementation
		WebDriver Cdriver = new ChromeDriver();
		Cdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Cdriver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		Cdriver.manage().window().maximize();

		Cdriver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		Cdriver.findElement(By.xpath("//a[@value='BLR']")).click();
		Thread.sleep(2000);
		// Cdriver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();

		// driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();

		Cdriver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='PNQ']"))
				.click();

	}

}
