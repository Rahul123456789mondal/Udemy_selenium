package TestNGPackage;

import org.testng.annotations.Test;
import org.testng.annotations.Parameters;

public class TestNGParams {
	
	@Test  
	@Parameters("mango")  
	public void Fruit_One(String a)  
	{ 
	System.out.println("Prameters are - "+a);
	}
	
	@Test  
	@Parameters("orange")  
	public void Fruit_Two(String b)  
	{ 
	System.out.println("Prameters are - "+b);
	}
}
