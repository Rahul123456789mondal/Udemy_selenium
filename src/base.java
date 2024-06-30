import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class base {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = null;

        try {

            driver = new ChromeDriver();

            driver.manage().window().maximize();

            // Using Implicit Wait For The Handel The Element Finding Time
            //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

            // Explicit Waits
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

            String[] itemsNeeded = {"Cucumber", "Brocolli", "Beetroot"};

            driver.get("https://rahulshettyacademy.com/seleniumPractise/");

            //Thread.sleep(3000);
            // Call The Add Items Function
            addItems(driver, itemsNeeded);

            driver.findElement(By.cssSelector("img[alt='Cart']")).click();
            driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
            driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");

            driver.findElement(By.xpath("//button[@class='promoBtn']")).click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='promoInfo']")));
            WebElement Output = driver.findElement(By.xpath("//span[@class='promoInfo']"));
            if (Output.getText().equalsIgnoreCase("Code applied ..!")){
                System.out.println(Output.getText());
                driver.quit();
            }else {
                System.out.println("Some Thing Wrong");
            }

        }catch (Exception e){
            e.fillInStackTrace();
            if (driver != null) {
                driver.quit();
            }
        }


    }

    public static void addItems(WebDriver driver, String[] itemsNeeded) {

        int j = 0;

        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

        for (int i = 0; i < products.size(); i++) {

            String[] name = products.get(i).getText().split("-");

            String formattedName = name[0].trim();

            List<String> itemsNeededList = Arrays.asList(itemsNeeded);

            if (itemsNeededList.contains(formattedName)) {

                j++;

                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

                if (j == itemsNeeded.length) {

                    break;

                }

            }

        }

    }


}
