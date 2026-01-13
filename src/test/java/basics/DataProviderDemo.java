package basics;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {

    @DataProvider(name = "loginData")
    public Object[][] getData() {
        return new Object[][]{
                {"admin", "admin123"},
                {"user", "user123"},
                {"guest", "guest123"}
        };
    }

    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password) {
        System.out.println("Username: " + username + " | Password: " + password);
    }
}
