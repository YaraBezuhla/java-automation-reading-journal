package journal.reading.automation.config.drivers;

import journal.reading.automation.config.browserOptions.BrowserOptionsProvider;
import journal.reading.automation.config.browserOptions.ChromeOptionsProvider;
import journal.reading.automation.config.browserOptions.FirefoxOptionsProvider;
import org.openqa.selenium.WebDriver;

import java.util.Map;
import java.util.function.Supplier;

public class DriverFactory {

    public WebDriver CreateWebDriver(BrowserType browserType) {
        Map<BrowserType, Supplier<Driver>> driverMap = Map.of(
                BrowserType.Firefox, FirefoxDriverFactory::new,
                BrowserType.Chrome, ChromeDriverFactory::new
        );

        Map<BrowserType, Supplier<BrowserOptionsProvider>> optionsMap = Map.of(
                BrowserType.Firefox, FirefoxOptionsProvider::new,
                BrowserType.Chrome, ChromeOptionsProvider::new
        );

        Driver driver = driverMap.getOrDefault(browserType, ChromeDriverFactory::new).get();
        BrowserOptionsProvider optionsProvider = optionsMap.getOrDefault(browserType, ChromeOptionsProvider::new).get();

        return driver.CreateDriver(optionsProvider.getOptions());

        /*driver = switch (browserType) {
            case Firefox -> new FirefoxDriverFactory();
            default -> new ChromeDriverFactory();
        };
        return driver.CreateDriver(options);*/
    }
}
