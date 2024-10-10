package journal.reading.automation.settings.launch;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener extends LaunchSettings implements ITestListener {
    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPng(WebDriver driver) {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog (String message) {
        return message;
    }

    @Override
    public void onTestFailure(ITestResult iTestResult){
        System.out.println(getTestMethodName(iTestResult) + "failed");

        Object testClass = iTestResult.getInstance();
        WebDriver driver = ((LaunchSettings) testClass).getDriver();

        if (driver instanceof  WebDriver) {
            saveScreenshotPng((driver));
        }

        saveTextLog((getTestMethodName(iTestResult)));
    }
}
