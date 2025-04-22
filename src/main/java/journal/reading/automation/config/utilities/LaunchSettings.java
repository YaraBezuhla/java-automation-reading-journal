package journal.reading.automation.config.utilities;

import journal.reading.automation.config.drivers.DriverFactory;
import journal.reading.automation.pageObjects.PageObjectsFacade;
import org.openqa.selenium.*;
import org.testng.annotations.*;

public class LaunchSettings {

    public static WebDriver driver;
    protected WaitService wait;
    private final DriverFactory driverFactory = new DriverFactory();
    protected PageObjectsFacade pages;


    @BeforeMethod
    @Parameters("browser")
    public void setup() {
        driver = driverFactory.CreateWebDriver(Config.BrowserType.CHROME);
        wait = new WaitService(driver, Config.DEFAULT_TIMEOUT);
        driver.get(Config.Domains.LOCALE);
        pages = new PageObjectsFacade(driver, wait);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
