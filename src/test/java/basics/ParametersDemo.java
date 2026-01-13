package basics;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersDemo {

    @Parameters({"browser"})
    @Test
    public void launchApp(@Optional("chrome") String browser) {
        System.out.println("Browser from XML: " + browser);
    }
}
