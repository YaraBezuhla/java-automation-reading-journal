package journal.reading.automation.config;

import journal.reading.automation.config.drivers.BrowserType;
import journal.reading.automation.config.drivers.DriverFactory;
import journal.reading.automation.pageObjects.PageObjectsFacade;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.util.Date;


public class LaunchSettings {

    public static WebDriver driver;
    private final DriverFactory driverFactory = new DriverFactory();
    protected PageObjectsFacade pages;

    @BeforeMethod
    @Parameters("browser")
    public void setup() {
        driver = driverFactory.CreateWebDriver(BrowserType.Chrome);
        driver.get(Sites.siteDomains.locale);
        pages = new PageObjectsFacade(driver);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void failedScreenshot(String testMethodName) {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Date d = new Date();

        String TimeStamp = d.toString().replace(":", "_").replace(" ", "_");
        try {
            FileUtils.copyFile(srcFile, new File("C:/Users/Ярослава/Projects/java-automation-reading-journal/build/screenshots/"
                    + testMethodName + "_" + TimeStamp + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
