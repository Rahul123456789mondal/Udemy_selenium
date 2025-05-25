import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sync {

	public static void main(String[] args) throws InterruptedException {
	
		WebDriver Cdriver = new ChromeDriver();
		Cdriver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Cdriver.manage().window().maximize();
		Thread.sleep(4000);
		Cdriver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("admin");
		Cdriver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		Cdriver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(4000);
		Cdriver.findElement(By.xpath("//span[normalize-space()='Admin']")).click();
		Thread.sleep(4000);
		Cdriver.findElement(By.xpath("//button[normalize-space()='Add']")).click();
		Thread.sleep(4000);
		Cdriver.findElement(By.xpath("(//div[@class='oxd-select-wrapper'])[1]")).click();
		Thread.sleep(4000);
		Cdriver.findElement(By.xpath("(//div[@class='oxd-select-wrapper'])[1]")).sendKeys(Keys.ARROW_DOWN);
		Cdriver.findElement(By.xpath("(//div[@class='oxd-select-wrapper'])[1]")).sendKeys(Keys.ARROW_DOWN);
		Cdriver.findElement(By.xpath("(//div[@class='oxd-select-wrapper'])[1]")).sendKeys(Keys.ENTER);
		//List<WebElement> role_dropdown = Cdriver.findElements(By.xpath("(//div[@class='oxd-select-wrapper'])[1]//div[@role='listbox']"));
	    //for( WebElement a : role_dropdown ) {
		  // System.out.println(a.getText());
	    //}
		
		
		
	}

}
