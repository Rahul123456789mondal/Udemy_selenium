import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AccessCalender {

	public static void main(String[] args) throws InterruptedException {

		WebDriver Cdriver = new ChromeDriver();
		Cdriver.get("https://www.makemytrip.com/");
		Cdriver.manage().window().maximize();
		Cdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		// To Switch the Frame
		WebElement fream = Cdriver.findElement(By.id("webklipper-publisher-widget-container-notification-frame"));
		Cdriver.switchTo().frame(fream);

		// Thread.sleep(2000);
		Cdriver.findElement(By.id("webklipper-publisher-widget-container-notification-close-div")).click();

		// Thread.sleep(7000);
		List<WebElement> tripSelect = Cdriver
				.findElements(By.xpath("//ul[@class='fswTabs latoRegular darkGreyText ']//li"));
		for (WebElement select : tripSelect) {

			if (select.getText().contains("Round")) {
				select.click();
				break;
			}
		}

		Cdriver.findElement(By.xpath("//div[@class='flt_fsw_inputBox dates inactiveWidget ']")).click();

	}

}
