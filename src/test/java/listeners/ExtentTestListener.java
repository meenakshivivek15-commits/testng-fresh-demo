package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import reports.ExtentManager;
import setup.TestSetup;

public class ExtentTestListener implements ITestListener {

    // ✅ PUT STATIC BLOCK HERE (INSIDE CLASS, OUTSIDE METHODS)
    static {
        System.out.println(">>> ExtentTestListener LOADED <<<");
    }

    private static ExtentReports extent = ExtentManager.getExtent();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest =
                extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        System.out.println(">>> onTestFailure CALLED <<<");

        Object testClass = result.getInstance();
        TestSetup setup = (TestSetup) testClass;

        String screenshotPath =
                setup.captureScreenshot(result.getMethod().getMethodName());

        test.get().fail(
                result.getThrowable(),
                MediaEntityBuilder
                        .createScreenCaptureFromPath(screenshotPath)
                        .build()
        );
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.get().skip("Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
