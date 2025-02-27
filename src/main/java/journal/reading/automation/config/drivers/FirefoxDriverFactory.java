package journal.reading.automation.config.drivers;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxDriverFactory implements Driver {

    @Override
    public WebDriver CreateDriver(MutableCapabilities options) {
        return new FirefoxDriver((FirefoxOptions) options);
    }
}
