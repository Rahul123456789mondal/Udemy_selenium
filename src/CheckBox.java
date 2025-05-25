import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBox {

	public static void main(String[] args) throws InterruptedException {

		WebDriver Cdriver = new ChromeDriver();
		Cdriver.get("https://rahulshettyacademy.com/AutomationPractice/");
		Cdriver.manage().window().maximize();

		List<WebElement> checkbox = Cdriver.findElements(By.xpath("//div[@id='checkbox-example']//fieldset//input"));
		for (WebElement option : checkbox) {

			if (option.getAttribute("value").equalsIgnoreCase("option1")) {
				System.out.println(option.getAttribute("value"));
				option.click();
				if (option.isSelected()) {
					System.out.println("size " + checkbox.size());
					System.out.println("Successfully checked");
					option.click();
					if (!option.isSelected()) {
						System.out.println("Successfully Unchecked");
					}
				}
				break;
			}
		}

	}

}
