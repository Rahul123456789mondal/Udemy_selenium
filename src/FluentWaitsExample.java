import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.function.Function;

public class FluentWaitsExample {

    public static void main (String[] args){

        WebDriver Driver = new ChromeDriver();
        Driver.get("https://the-internet.herokuapp.com/dynamic_loading");
        Driver.manage().window().maximize();

        Driver.findElement(By.xpath("//a[contains(text(),'Example 1: Element on page that is hidden')]")).click();

        // We Can Use Also The Alternate Xpath "//button[text()='Start']" || "//button[contains(text(),'Start')]"
        Driver.findElement(By.xpath("//button[normalize-space(text())='Start']")).click();
        // Apple The Fluent Waits
        FluentWait<WebDriver> wait = new FluentWait<>(Driver)
                .withTimeout(Duration.ofSeconds(30))       // Maximum wait time
                .pollingEvery(Duration.ofSeconds(3))       // Check every 5 seconds
                .ignoring(NoSuchElementException.class);

        WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {

                if (driver.findElement(By.xpath("//h4[contains(text(),'Hello World!')]")).isDisplayed()){
                    return driver.findElement(By.xpath("//h4[contains(text(),'Hello World!')]"));
                }else {
                    return null;
                }
            }
        });
        System.out.println(foo.getText());
        //System.out.println(Driver.findElement(By.xpath("//h4[contains(text(),'Hello World!')]")).getText());


    }

}
