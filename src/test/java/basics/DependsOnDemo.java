package basics;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependsOnDemo {

    @Test
    public void launchApp() {
        System.out.println("Launch App");
        Assert.fail(); // force failure
    }

    @Test(dependsOnMethods = "launchApp")
    public void login() {
        System.out.println("Login");
    }

    @Test(dependsOnMethods = "login")
    public void logout() {
        System.out.println("Logout");
    }
}
