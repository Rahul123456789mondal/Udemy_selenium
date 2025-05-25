import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestive {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver Cdriver = new ChromeDriver();
		//Cdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		Cdriver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		Cdriver.manage().window().maximize();
		Cdriver.findElement(By.cssSelector("#autosuggest")).sendKeys("Au");
		Thread.sleep(2000);
		//List<WebElement> options =  Cdriver.findElements(By.cssSelector("li[class=ui-menu-item] a"));
		
		List<WebElement> options =  Cdriver.findElements(By.xpath("//li[@class='ui-menu-item']//a"));
		JavascriptExecutor executor = (JavascriptExecutor)Cdriver;
		for(WebElement option : options )
		{
			
			if(option.getText().equalsIgnoreCase("Australia"))
			{
				System.out.println(option.getText());
				executor.executeScript("arguments[0].click();", option);
				//option.click();
				break;
			}
		}
		

		/* Demo Practice 
		Cdriver.get("https://www.makemytrip.com/flights/");
		Cdriver.manage().window().maximize();
		Cdriver.findElement(By.id("fromCity")).click();
		Cdriver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("Arka");
		*/
	}

}
