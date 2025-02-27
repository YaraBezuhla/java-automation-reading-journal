package journal.reading.automation.config;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener extends LaunchSettings implements ITestListener {
    public void onTestFailure(ITestResult result) {
        try {
            failedScreenshot(result.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
