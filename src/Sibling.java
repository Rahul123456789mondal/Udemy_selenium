import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Sibling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver Edriver = new EdgeDriver();
		Edriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// Sibling - Child to parent traverse

		//header/div/button[1]/following-sibling::button[1]

		Edriver.get("https://rahulshettyacademy.com/AutomationPractice/");

		System.out.println(Edriver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());

		System.out.println(Edriver.findElement(By.xpath("//header/div/button[1]/parent::div/button[2]")).getText());

	}

}
