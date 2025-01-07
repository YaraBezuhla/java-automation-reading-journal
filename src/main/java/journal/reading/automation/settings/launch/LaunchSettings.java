package journal.reading.automation.settings.launch;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.util.Date;


public class LaunchSettings {

    public static WebDriver driver;

    ChromeOptions chromeOptions = new ChromeOptions();

    public ChromeOptions configChromeOptions() {
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        chromeOptions.setAcceptInsecureCerts(false); //SSL сертифікат
        chromeOptions.addArguments("--start-maximized");

        return chromeOptions;
    }

    @BeforeMethod
    public void setup() {
        //    driver.manage().window().maximize();
        driver = new ChromeDriver(configChromeOptions());
        driver.get(Sites.siteDomains.locale);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
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
