package setup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class TestSetup {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @BeforeMethod
    public void setUp() {

        // ✅ REQUIRED FOR CI
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");              // IMPORTANT
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");

        driver.set(new ChromeDriver(options));
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    // Screenshot support for listeners
    public String captureScreenshot(String testName) {
        try {
            File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
            String destPath = "screenshots/" + testName + ".png";
            File dest = new File(destPath);
            dest.getParentFile().mkdirs();
            Files.copy(src.toPath(), dest.toPath());
            return destPath;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @AfterMethod
    public void tearDown() {
        if (getDriver() != null) {
            getDriver().quit();
            driver.remove();
        }
    }
}

