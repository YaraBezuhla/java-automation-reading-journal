package journal.reading.automation.core.drivers;

import journal.reading.automation.core.browserOptions.BrowserOptionsProvider;
import journal.reading.automation.core.browserOptions.ChromeOptionsProvider;
import journal.reading.automation.core.browserOptions.FirefoxOptionsProvider;
import org.openqa.selenium.WebDriver;

public class DriverFactory {

    public WebDriver createWebDriver(String browserName) {
        Driver driverFactory;
        BrowserOptionsProvider optionsProvider;

        switch (browserName.toLowerCase()) {
            case "chrome":
                driverFactory = new ChromeDriverFactory();
                optionsProvider = new ChromeOptionsProvider();
                break;
            case "firefox":
                driverFactory = new FirefoxDriverFactory();
                optionsProvider = new FirefoxOptionsProvider();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browserName);
        }

        WebDriver driver = driverFactory.createDriver(optionsProvider.getOptions());
        return driver;
    }
}
