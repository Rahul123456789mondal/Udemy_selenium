import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class windowHandel {

    public static void main(String[] args) throws InterruptedException {

        WebDriver cDriver = new ChromeDriver();
        cDriver.get("https://www.naukri.com/registration/createAccount?othersrcp=23531&wExp=N&utm_source=google&utm_medium=cpc&utm_campaign=Brand&gad_source=1&gclid=Cj0KCQjw0Oq2BhCCARIsAA5hubXIbTfwYSX7RbSFMxdXCE-AiQAOeePPYRGzKc5FWDVusax29s2CXi4aArk9EALw_wcB&gclsrc=aw.ds");
        cDriver.manage().window().maximize();

        cDriver.findElement(By.xpath("//span[contains(text(),'Google')]")).click();

        // Get the current window handle (main window)
        String mainWindowHandle = cDriver.getWindowHandle();
        System.out.println("Main window handle: " + mainWindowHandle);

        // Get all window handles after the new window is opened
        Set<String> windows = cDriver.getWindowHandles();
        // Iterate through the window handles

        for (String windowHandle : windows) {
            // If the window handle is not the main window, switch to the new window
            if (!mainWindowHandle.equals(windowHandle)) {
                cDriver.switchTo().window(windowHandle);
                System.out.println("Switched to new window: " + windowHandle);

                // Perform actions in the new window (e.g., get the title)
                Thread.sleep(2000);
                System.out.println("New window title: " + cDriver.getTitle());

                // Close the new window
                cDriver.close();
            }

        }
        cDriver.switchTo().window(mainWindowHandle);
        System.out.println("New window title: " + cDriver.getTitle());
    }

}
