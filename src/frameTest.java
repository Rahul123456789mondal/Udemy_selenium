import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class frameTest {

    public static void main( String [] args){

        frameTest myObject = new frameTest();

    	WebDriver cDriver = new ChromeDriver();
        cDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        cDriver.get("https://ui.vision/demo/webtest/frames/");
        cDriver.manage().window().maximize();

        // Switching The Frame
        WebElement frame1 = cDriver.findElement(By.xpath("//frame[@src= 'frame_1.html']"));
        cDriver.switchTo().frame(frame1);
        cDriver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Arka Mondal");

        // Switch back to the default content (main page)
        myObject.defaultFrameCall(cDriver);

        // Switching The Frame 2
        WebElement frame2 = cDriver.findElement(By.xpath("//frame[@src= 'frame_2.html']"));
        cDriver.switchTo().frame(frame2);
        cDriver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("Frame 2");

        // Switch back to the default content (main page)
        myObject.defaultFrameCall(cDriver);

        // Switching The Frame 3
        WebElement frame3 = cDriver.findElement(By.xpath("//frame[@src= 'frame_3.html']"));
        cDriver.switchTo().frame(frame3);
        cDriver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("Frame 3");

        // Switching The Inner Frame
        myObject.innerFrameCall(cDriver);

        // Switch back to the default content (main page)
        myObject.defaultFrameCall(cDriver);

        // Switching The Frame 5
        WebElement frame5 = cDriver.findElement(By.xpath("//frame[@src= 'frame_5.html']"));
        cDriver.switchTo().frame(frame5);
        cDriver.findElement(By.xpath("//input[@name='mytext5']")).sendKeys("Frame 5");
        cDriver.findElement(By.xpath("//a[text()='https://a9t9.com']")).click();
    }

    void defaultFrameCall(WebDriver driver){
        driver.switchTo().defaultContent();
    }

    void innerFrameCall(WebDriver driver){
        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//div[@id='i5']//div[@class='AB7Lab Id5V1']")).click();
    }

}

