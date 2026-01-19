import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class DropDownAutomationAss {

    public static void main(String[] args) throws InterruptedException {


        WebDriver d =new ChromeDriver();
        d.manage().window().maximize();
        d.get("https://rahulshettyacademy.com/angularpractice/");
        d.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));

        //Thread.sleep(3000);

        d.findElement(By.xpath("/html/body/app-root/form-comp/div/form/div[1]/input")).sendKeys("Dileep Adusumalli");

        d.findElement(By.xpath("//input[@name='email']")).sendKeys("adusumallidileep77@gmail.com");

        d.findElement(By.id("exampleInputPassword1")).sendKeys("Dileep@5627");

        boolean checkbox = d.findElement(By.xpath("//div/input[@type= 'checkbox']")).isSelected();

        if(checkbox)

        {
            System.out.println("Check box is selected successfully no need to check");

        }else {

            d.findElement(By.xpath("//div/input[@type= 'checkbox']")).click();
        }

        Select selectgender =new Select(d.findElement(By.id("exampleFormControlSelect1")));
        selectgender.selectByVisibleText("Male");
        d.findElement(By.id("inlineRadio1")).click();
        d.findElement(By.xpath("//div/input[@name= 'bday']")).sendKeys("20-06-2001");
        d.findElement(By.cssSelector("input[class ='btn btn-success']")).click();
        //Thread.sleep(2000);
        System.out.println(d.findElement(By.cssSelector("div[class='alert alert-success alert-dismissible']")).getText());
        d.quit();

    }

}
