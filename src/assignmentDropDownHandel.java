import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class assignmentDropDownHandel {

    @Test
    public void assignmentTask(){
        WebDriver cDriver = new ChromeDriver();
        cDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        cDriver.get("https://rahulshettyacademy.com/AutomationPractice/");
        // Click On The Check-Box and Gate The Data
        String selectedValue = null;
        WebElement checkbox = cDriver.findElement(By.id("checkBoxOption2"));
        if (!checkbox.isSelected()) {
            checkbox.click();
            selectedValue  = checkbox.getAttribute("value");
        }
        System.out.println("Selected checkbox value: " + selectedValue);

        // Select The Drop-Down From The Selected Check-Box Value
        WebElement dropdown = cDriver.findElement(By.id("dropdown-class-example"));
        Select select = new Select(dropdown);
        select.selectByValue(selectedValue);
        System.out.println(selectedValue + " - " + select.getFirstSelectedOption().getText().toLowerCase());

        // Selected Data Send To The Text Field
        WebElement nameField = cDriver.findElement(By.xpath("//input[@id='name']"));
        nameField.sendKeys(selectedValue);
        WebElement clickAlert = cDriver.findElement(By.xpath("//input[@id='alertbtn']"));
        clickAlert.click();

        // Handel The Alert And Get The Data
        Alert alert = cDriver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println("Alert Text: " + alertText);
        Assert.assertTrue(alertText.contains(selectedValue), "Alert does not contain selected value");
        alert.accept();
        cDriver.quit();

    }
}
