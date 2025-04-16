package journal.reading.automation.config.utilities;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestListener extends LaunchSettings implements ITestListener {
    private long startTime;

    @Override
    public void onTestStart(ITestResult result) {
        startTime = System.currentTimeMillis();
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logEnvironment();
        logDuration();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log("Test FAILED: " + result.getName());
        logEnvironment();
        takeScreenshot(result);
        logDuration();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log("Test SKIPPED: " + result.getName());
        logEnvironment();
        takeScreenshot(result);
        logDuration();
    }

    private void takeScreenshot(ITestResult result) {
        if (driver != null) {
            try {
                File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                File dest = new File("screenshots/" + result.getName() + "_" + timestamp + ".png");
                dest.getParentFile().mkdirs();
                Files.copy(src.toPath(), dest.toPath());
                log("Screenshot saved to: " + dest.getAbsolutePath());
            } catch (IOException e) {
                log("Could not take screenshot: " + e.getMessage());
            }
        } else {
            log("WebDriver is null, screenshot not taken.");
        }
    }


    private void logDuration() {
        long duration = System.currentTimeMillis() - startTime;
        log("Duration: " + duration + " ms");
    }

    private void logEnvironment() {
        try {
            Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
            String browserName = caps.getBrowserName();
            String browserVersion = caps.getBrowserVersion();
            String os = System.getProperty("os.name");

            log("OS: " + os);
            log("Browser: " + browserName + " " + browserVersion);
        } catch (Exception e) {
            log("Unable to read browser capabilities: " + e.getMessage());
        }
    }

    private void log(String message) {
        System.out.println("[TestListener] " + message);
    }
}
