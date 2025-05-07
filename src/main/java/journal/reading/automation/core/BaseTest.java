package journal.reading.automation.core;

import journal.reading.automation.core.drivers.DriverFactory;
import journal.reading.automation.core.utilities.ConfigReader;
import journal.reading.automation.core.utilities.WaitService;
import journal.reading.automation.pageObjects.PageObjectsFacade;
import org.openqa.selenium.*;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {

    public WebDriver driver;
    protected WaitService wait;
    private final DriverFactory driverFactory = new DriverFactory();
    protected PageObjectsFacade pages;


    @BeforeMethod
    public void setup() {
        driver = driverFactory.createWebDriver(ConfigReader.get("browser.chrome"));
        wait = new WaitService(driver, Duration.parse(ConfigReader.get("waitTimeout.default_seconds")));
        driver.get(ConfigReader.get("url.locale"));
        pages = new PageObjectsFacade(driver, wait);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
