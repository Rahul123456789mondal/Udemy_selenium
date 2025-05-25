import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.List;

public class BrokenLink {

    public static void main(String[] args) {

        WebDriver cDriver = new ChromeDriver();

        try {
            cDriver.get("https://www.thehygienistbar.com/services"); // Replace with the URL of the website you want to check

            // Retrieve all anchor tags with href attributes
            List<WebElement> links = cDriver.findElements(By.tagName("a"));

            System.out.println("Total links found: " + links.size());

            // Loop through all links and check their status
            for (WebElement link : links) {
                String url = link.getAttribute("href");

                // Check if the URL is valid before testing - !url.isEmpty()
                if (url != null && url.startsWith("http")) {
                    checkLinkStatus(url);
                } else {
                    System.out.println("Invalid or empty URL: " + url);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cDriver.quit();
        }

    }

    // Method to send HTTP request and check response status
    public static void checkLinkStatus(String url) {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet httpGet = new HttpGet(url);
            try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
                int statusCode = response.getCode();

                if (statusCode >= 400) {
                    System.out.println(url + " is a broken link. Status Code: " + statusCode);
                } else {
                    System.out.println(url + " is a valid link. Status Code: " + statusCode);
                }
            }
        } catch (IOException e) {
            System.out.println("Error checking URL: " + url);
            e.printStackTrace();
        }
    }

}
