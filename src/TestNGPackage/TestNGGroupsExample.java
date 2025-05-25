package TestNGPackage;

import org.testng.annotations.Test;

public class TestNGGroupsExample {

    @Test(groups = {"smoke"}, priority = 1)
    public void testLogin() {
        System.out.println("Smoke Test: Login Test");
    }

    @Test(groups = {"regression"}, priority = 4)
    public void testSearch() {
        System.out.println("Regression Test: Search Test");
    }

    @Test(groups = {"smoke", "regression"}, priority = 2)
    public void testCheckout() {
        System.out.println("Smoke & Regression Test: Checkout Test");
    }

    @Test(groups = {"functional"}, priority = 3)
    public void testProfileUpdate() {
        System.out.println("Functional Test: Profile Update Test");
    }

}
