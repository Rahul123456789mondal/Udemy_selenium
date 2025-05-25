package TestNGPackage;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestNGDay3 {

    @Test
    public void demo5(){ System.out.println("Hello Run From TestNG-Demo5"); }

    @Test
    public void demo6(){ System.out.println("Hello Run From TestNG-Demo6"); }

    @BeforeSuite
    public void before_suite()
    {
        System.out.println("The @BeforeSuite annotated method is executed before the execution of all the test cases defined in thefolder.\n" +
                "\n" +
                "Generally, @BeforeSuite is used when we have different URLs to run your test cases. Environment variables are set in a @BeforeSuite annotated method so that before executing all the test cases, you need to load all the environment variables for your framework, and then it starts executing your test cases.\n" +
                "\n" +
                "The @BeforeSuite annotated method is given as the first priority, so it is executed before all the other test methods."+"\n");
    }

}
