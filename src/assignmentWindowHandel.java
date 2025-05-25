import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.Set;


public class assignmentWindowHandel {

    public static void main (String[] args){

        WebDriver cDriver = new ChromeDriver();
        cDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        cDriver.get("https://the-internet.herokuapp.com/");
        cDriver.findElement(By.xpath("//a[contains(text(),'Multiple Windows')]")).click();

        String mainWindow = cDriver.getWindowHandle();
        System.out.println(mainWindow + "  " + " " + cDriver.getTitle());
        cDriver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();
        Set<String> windows = cDriver.getWindowHandles();
        for (String windowHandle : windows) {
            // If the window handle is not the main window, switch to the new window
            if (!mainWindow.equals(windowHandle)) {
                cDriver.switchTo().window(windowHandle);
                System.out.println("Switched to new window: " + windowHandle);
                System.out.println(cDriver.getTitle());
            }
        }
        System.out.println(cDriver.findElement(By.xpath("//h3[contains(text(),'New Window')]")).getText());
        cDriver.close();
        cDriver.switchTo().window(mainWindow);
        System.out.println(cDriver.findElement(By.xpath("//h3[contains(text(),'Opening a new window')]")).getText());
    }

}
