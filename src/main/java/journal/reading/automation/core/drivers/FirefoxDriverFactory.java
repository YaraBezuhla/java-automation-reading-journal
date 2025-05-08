package journal.reading.automation.core.drivers;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxDriverFactory implements Driver {

    @Override
    public WebDriver createDriver(MutableCapabilities options) {
        return new FirefoxDriver((FirefoxOptions) options);
    }
}
