import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alert_Handel {

	public static void main(String[] args) throws InterruptedException {

		WebDriver Cdriver = new ChromeDriver();
		Cdriver.get("https://rahulshettyacademy.com/AutomationPractice/");
		Cdriver.manage().window().maximize();

		Cdriver.findElement(By.xpath("//input[@id='alertbtn']")).click();

		Thread.sleep(5000);

		Cdriver.switchTo().alert().accept();

		Cdriver.findElement(By.xpath("//input[@id='confirmbtn']")).click();

		Thread.sleep(5000);

		Cdriver.switchTo().alert().accept();

		Cdriver.findElement(By.xpath("//input[@id='confirmbtn']")).click();

		Thread.sleep(5000);

		Cdriver.switchTo().alert().dismiss();

	}

}
