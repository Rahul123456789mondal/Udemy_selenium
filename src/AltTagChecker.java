import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class AltTagChecker {

    public static void main(String[] args) {
        // Set path to your WebDriver
        WebDriver driver = new ChromeDriver();

        // List of URLs to check
        String[] urls = {
                "https://klhaudio.com/cart"
        };

        for (String url : urls) {
            checkAltTags(driver, url);
        }

        driver.quit();
    }

    public static void checkAltTags(WebDriver driver, String url) {
        driver.get(url);
        List<WebElement> images = driver.findElements(By.tagName("img"));
        int missingAltCount = 0;

        System.out.println("\nChecking URL: " + url);
        System.out.println("Total images found: " + images.size());

        for (WebElement image : images) {
            String altText = image.getAttribute("alt");
            String src = image.getAttribute("src");
            String formated_scr = src.replace("%","").replace("20", " ");
            if (altText == null || altText.trim().isEmpty()) {
                missingAltCount++;
                System.out.println("Missing alt text - Image src: " + formated_scr);
            }
        }

        System.out.println("Images missing alt text: " + missingAltCount);
        /*System.out.println("Percentage with alt text: " +
                ((images.size() - missingAltCount) * 100 / images.size()) + "%");*/
    }

}

