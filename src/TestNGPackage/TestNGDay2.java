package TestNGPackage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNGDay2 {

    @Test
    public void demo3(){ System.out.println("Hello Run From TestNG-Demo3"); }

    @Test
    public void demo4(){ System.out.println("Hello Run From TestNG-Demo4"); }

    // @BeforeClass: The @BeforeClass annotated method runs before the execution of test methods in a current class.
    @BeforeClass
    public void before_class()
    {
        System.out.println("This method is executed before Class2");
    }

}
