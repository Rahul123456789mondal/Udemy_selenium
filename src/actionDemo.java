import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class actionDemo {

	public static void main(String[] args) {
		
		WebDriver cDriver = new ChromeDriver();
		cDriver.get("https://www.amazon.in/");
		cDriver.manage().window().maximize();
		
		Actions action = new Actions(cDriver);
		action.moveToElement(cDriver.findElement(By.xpath("(//div[@class='layoutToolbarPadding']//a)[2]"))).build().perform();
		WebElement searchBar = cDriver.findElement(By.id("twotabsearchtextbox"));
		action.moveToElement(searchBar).click().keyDown(Keys.SHIFT).sendKeys("Pen").build().perform();

	}

}
