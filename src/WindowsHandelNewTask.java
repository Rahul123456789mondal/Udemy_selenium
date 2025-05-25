import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class WindowsHandelNewTask {

    public static void main ( String[] args ){

        WebDriver cDriver = new ChromeDriver();
        cDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        cDriver.get("https://testautomationpractice.blogspot.com/");
        cDriver.manage().window().maximize();
        cDriver.findElement(By.xpath("//input[@id='Wikipedia1_wikipedia-search-input']")).sendKeys("selenium");
        cDriver.findElement(By.xpath("//input[@type='submit']")).click();

    }

}
