package basics;

import org.testng.annotations.Test;

public class PriorityDemo {

    @Test(priority = 2)
    public void testLogin() {
        System.out.println("Login Test");
    }

    @Test(priority = 1)
    public void testLaunch() {
        System.out.println("Launch App");
    }

    @Test(priority = 3)
    public void testLogout() {
        System.out.println("Logout Test");
    }
}
