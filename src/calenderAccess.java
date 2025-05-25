import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class calenderAccess {

    public static void main(String[] args){

        WebDriver Cdriver = new ChromeDriver();
        Cdriver.get("https://jqueryui.com/datepicker/");
        Cdriver.manage().window().maximize();
        Cdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));



    }

}
