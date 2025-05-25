import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AccessScrolling {

    public static void main(String[] args) throws InterruptedException {

        WebDriver cDriver = new ChromeDriver();
        //cDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        cDriver.get("https://rahulshettyacademy.com/AutomationPractice/");
        cDriver.manage().window().maximize();


        // Cast WebDriver to JavaScriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) cDriver;

        // Scroll to a specific element
        WebElement element = cDriver.findElement(By.xpath("//div[@class='tableFixHead']"));
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        js.executeScript("arguments[0].scrollBy(0, 250);", element);

        //js.executeScript("window.scrollBy(0, 700)");

        /* // Change The iframe scroll
          cDriver.switchTo().frame("//iframe[@id='courses-iframe']");
          js.executeScript("window.scrollBy(0,-200)"); */

        // Access The Table Row And Col
        List<WebElement> table_diff = cDriver.findElements(By.xpath("//div[@class='tableFixHead']//table//tbody//td"));
        System.out.println(table_diff.size());
        List<WebElement> table_row = cDriver.findElements(By.xpath("//div[@class='tableFixHead']//table//tr"));
        System.out.println(table_row.size());
        List<WebElement> table_col = cDriver.findElements(By.xpath("//div[@class='tableFixHead']//table//tr//th"));
        System.out.println(table_col.size());

        Thread.sleep(5000);
        for( int i=1; i<table_row.size(); i++){
            for(int j=1; j<=table_col.size(); j++){
                WebElement data = cDriver.findElement(By.xpath("//div[@class='tableFixHead']//table//tbody//tr[" + i + "]//td[" + j + "]"));
                System.out.println(data.getText());
            }
        }


    }
}
