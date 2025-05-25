package TestNGPackage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNGDay1 {

    // @BeforeClass: The @BeforeClass annotated method runs before the execution of test methods in a current class.
    @BeforeClass
    public void before_class(){
        System.out.println("This method is executed before Class");
    }

    @Test
    public void demo(){
        System.out.println("Hello Run From TestNG-Day1");
    }

    @Test
    public void demo2(){ System.out.println("Hello Run From TestNG-Demo2"); }


}
