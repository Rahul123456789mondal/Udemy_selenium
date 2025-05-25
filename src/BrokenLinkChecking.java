import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BrokenLinkChecking {

    public static void main(String[] args) {

        // Automatically the driver (no manual download needed)
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // List of pages to check
        List<String> pagesToVisit = List.of(
                "https://www.thehygienistbar.com/blog/the-oral-microbiome-the-key-to-a-healthier-brighter-smile",
                "https://www.thehygienistbar.com/blog/title-more-than-a-cleaning-the-power-purpose-and-future-of-the-dental-hygienist"
        );

        for (String pageUrl : pagesToVisit) {
            System.out.println("========================================");
            System.out.println("🔍 Visiting Page: " + pageUrl);

            driver.get(pageUrl);

            // Get all links
            List<WebElement> links = driver.findElements(By.tagName("a"));
            Set<String> uniqueUrls = new HashSet<>();

            for (WebElement link : links) {
                String href = link.getAttribute("href");
                if (href != null && !href.trim().isEmpty() && (href.startsWith("http") || href.startsWith("https"))) {
                    uniqueUrls.add(href.trim());
                }
            }

            System.out.println("🔗 Total unique links found: " + uniqueUrls.size());

            // Check all extracted links
            checkBrokenLinks(uniqueUrls);
        }

        driver.quit();
        System.out.println("\n✅ All pages checked.");
    }

    public static void checkBrokenLinks(Set<String> urls) {
        for (String url : urls) {
            try {
                HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
                connection.setRequestMethod("HEAD");
                connection.setConnectTimeout(5000);
                connection.connect();

                int responseCode = connection.getResponseCode();

                if (responseCode >= 400) {
                    System.out.printf("❌ [BROKEN] %s - %d %s%n", url, responseCode, connection.getResponseMessage());
                } else {
                    System.out.printf("✅ [VALID]  %s - %d %s%n", url, responseCode, connection.getResponseMessage());
                }

                connection.disconnect();
            } catch (Exception e) {
                System.out.printf("⚠️ [ERROR] %s - %s%n", url, e.getMessage());
            }
        }

    }
}
