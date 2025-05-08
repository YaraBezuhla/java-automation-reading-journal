package journal.reading.automation.core.drivers;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverFactory implements Driver {

    @Override
    public WebDriver createDriver(MutableCapabilities options) {
        return new ChromeDriver((ChromeOptions) options);
    }

}
