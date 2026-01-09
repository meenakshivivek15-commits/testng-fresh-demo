package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import setup.TestSetup;

public class LoginPageTest extends TestSetup {

    @Test(groups = "smoke")
    public void verifyLoginPageLoads() {

        getDriver().get("https://example.com");

        LoginPage loginPage = new LoginPage(getDriver());

        Assert.assertTrue(
                loginPage.isLoginPageLoaded(),
                "Login page did not load"
        );
    }
}
