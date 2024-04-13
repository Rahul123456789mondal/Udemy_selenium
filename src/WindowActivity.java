import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class WindowActivity {

	public static void main(String[] args) {
		
		WebDriver Edriver = new EdgeDriver();
		Edriver.manage().window().maximize();
		Edriver.get("https://www.google.com/");
		
		Edriver.navigate().to("https://rahulshettyacademy.com");

		Edriver.navigate().back();

		Edriver.navigate().forward();
	}

}
