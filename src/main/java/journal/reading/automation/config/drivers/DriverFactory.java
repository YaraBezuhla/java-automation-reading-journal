package journal.reading.automation.config.drivers;

import journal.reading.automation.config.Config;
import journal.reading.automation.config.browserOptions.BrowserOptionsProvider;
import journal.reading.automation.config.browserOptions.ChromeOptionsProvider;
import journal.reading.automation.config.browserOptions.FirefoxOptionsProvider;
import org.openqa.selenium.WebDriver;

import java.util.Map;
import java.util.function.Supplier;

public class DriverFactory {

    public WebDriver CreateWebDriver(Config.BrowserType browserType) {
        Map<Config.BrowserType, Supplier<Driver>> driverMap = Map.of(
                Config.BrowserType.FIREFOX, FirefoxDriverFactory::new,
                Config.BrowserType.CHROME, ChromeDriverFactory::new
        );

        Map<Config.BrowserType, Supplier<BrowserOptionsProvider>> optionsMap = Map.of(
                Config.BrowserType.FIREFOX, FirefoxOptionsProvider::new,
                Config.BrowserType.CHROME, ChromeOptionsProvider::new
        );

        Driver driver = driverMap.getOrDefault(browserType, ChromeDriverFactory::new).get();
        BrowserOptionsProvider optionsProvider = optionsMap.getOrDefault(browserType, ChromeOptionsProvider::new).get();

        return driver.CreateDriver(optionsProvider.getOptions());
    }
}
