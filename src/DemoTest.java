import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class DemoTest {
	
	
	public static void sendKeysJavascript(By element, String keysToSend, WebDriver driver) {
	    WebElement el = driver.findElement(element);
	    JavascriptExecutor ex = (JavascriptExecutor) driver;
	    ex.executeScript("arguments[0].value='"+ keysToSend +"';", el);
	    ex.executeScript("arguments[0].click();", el);
	}


	public static void main(String[] args) throws InterruptedException {

			WebDriver driver = new ChromeDriver();
		    driver.get("https://new-setup.joylocks.com/test/");
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollBy(0,850)", ""); // Scrolling the page
	        Thread.sleep(3000);
	        driver.findElement(By.xpath(("//*[@class='custom-btn questinare-btn']"))).click();
	        Thread.sleep(3000);
	        driver.findElement(By.xpath(("//*[@class='txtSec']"))).click();
	        Thread.sleep(3000);
	        driver.findElement(By.xpath(("//*[@class='imgSec']"))).click();
	        Thread.sleep(3000);
	        driver.findElement(By.id("A Little Only I notice it")).click();
	        Thread.sleep(3000);
	        driver.findElement(By.id("nosymptom")).click();
	        driver.findElement(By.id("no")).click();
	        Thread.sleep(3000);
	        driver.findElement(By.id("Both")).click();
	        Thread.sleep(3000);
	        
	        By Newelement = By.xpath("//input[@id='dob']");
	        String dob = "01/11/1995";
	        DemoTest.sendKeysJavascript(Newelement, dob, driver);
	        
	        /// JavascriptExecutor
	        
	        /*
	        WebElement birthField  = driver.findElement(By.xpath("//input[@id='dob']"));
	        JavascriptExecutor executor = (JavascriptExecutor)driver;
	        String dob = "01/11/1995";
	        executor.executeScript("arguments[0].value='"+ dob +"';", birthField);
	        */

	        //// Using Action Class 

	        /*WebElement element = driver.findElement(By.xpath("//input[@id='dob']"));
	        JavascriptExecutor executor = (JavascriptExecutor)driver;
	        String dob = "01/11/1995";
	        executor.executeScript("arguments[0].value='"+ dob +"';", element);
	        Actions actions = new Actions(driver);
	        //actions.moveToElement(element).sendKeys("01/11/1995").build().perform();
	        actions.moveToElement(element).click().sendKeys(Keys.ENTER).build().perform();*/


	        
	        //executor.executeScript("document.getElementById('dob').setAttribute('01/11/1995', 'new value for element')");
	        //executor.executeScript("arguments[0].setAttribute('value', '" + longstring +"')", inputField);
	        //driver.findElement(By.xpath("//input[@id='dob']")).click();
	        //birthField.sendKeys("0622004");

	}
	
}
