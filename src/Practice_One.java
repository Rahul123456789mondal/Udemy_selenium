import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice_One {

	static WebDriver Cdriver;

	static double price = 0;

	public static int validate_price(WebDriver driver) {

		// driver.findElement(By.xpath("//a[@class='cart-icon']")).click();

		String priceValue = driver.findElement(By.xpath("(//div[@class='cart-info']//table//tr)[2]//td//strong"))
				.getText();
		System.out.println(priceValue);

		return Integer.parseInt(priceValue);

	}

	public static void main(String[] args) throws InterruptedException {

		Cdriver = new ChromeDriver();
		Cdriver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		Cdriver.manage().window().maximize();

		List<WebElement> select_items = Cdriver.findElements(By.xpath("//div[@class='product']"));
		List<WebElement> add_to_cart = Cdriver.findElements(By.xpath("//div[@class='product-action']//button"));
		List<WebElement> product_price = Cdriver
				.findElements(By.xpath("//div[@class='product']//p[@class='product-price']"));
		
		for (int i = 0; i < select_items.size(); i++) {

			if (select_items.get(i).getText().contains("Cucumber") || select_items.get(i).getText().contains("Beetroot")
					|| select_items.get(i).getText().contains("Carrot")) {

				add_to_cart.get(i).click();
				
				// Total price
				price = price + Integer.parseInt(product_price.get(i).getText());

			}

		}
		Cdriver.findElement(By.xpath("//div[@class='cart']//a[@class='cart-icon']")).click();
		Thread.sleep(5000);
		List<WebElement> product_amount = Cdriver
				.findElements(By.xpath("//div[@class='cart-preview active']//p[@class='amount']"));
		System.out.println(product_amount.size());

		System.out.println(price);

		/*
		 * // Call the Function int Total_price = validate_price(Cdriver); // Total
		 * Price Validate if (price == Total_price) { System.out.println("Test Passed");
		 * } else { System.out.println("Test Failed"); }
		 * 
		 * Cdriver.quit();
		 */
	}

}
