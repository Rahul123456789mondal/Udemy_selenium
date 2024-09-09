import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class windowHandelTask {

    public static void main (String[] args){

        String extractString ;
        windowHandelTask myClassInstance = new windowHandelTask();

        WebDriver cDriver = new ChromeDriver();
        cDriver.get("http://www.rahulshettyacademy.com/loginpagePractise/");
        cDriver.findElement(By.xpath("//a[@class='blinkingText']")).click();

        // Get the current window handle (main window)
        String mainWindowHandle = cDriver.getWindowHandle();
        System.out.println("Main window handle: " + mainWindowHandle);

        // Get all window handles after the new window is opened
        Set<String> windows = cDriver.getWindowHandles();

        for (String windowHandle : windows) {
            // If the window handle is not the main window, switch to the new window
            if (!mainWindowHandle.equals(windowHandle)) {
                cDriver.switchTo().window(windowHandle);
                System.out.println("Switched to new window: " + windowHandle);
                System.out.println("New window title: " + cDriver.getTitle());
            }
        }

        extractString = cDriver.findElement(By.xpath("//p[@class='im-para red']")).getText();
        System.out.println("Extract Text From New window: " + extractString);
        // Call The Function
        myClassInstance.emailIDFinder(extractString);
        // Close the new window
        cDriver.close();

    }

    public void emailIDFinder(String newText){

        // Regular expression to match email addresses
        String emailRegex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}";

        // Compile the regex into a pattern
        Pattern pattern = Pattern.compile(emailRegex);

        // Create a matcher for the input string
        Matcher matcher = pattern.matcher(newText);

        // Find and extract the email address
        if (matcher.find()) {
            String email = matcher.group();
            System.out.println("Extracted Email: " + email);
        } else {
            System.out.println("No email address found in the input.");
        }

    }

}
