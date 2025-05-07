package journal.reading.automation.core.browserOptions;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxOptionsProvider implements BrowserOptionsProvider {
    @Override
    public MutableCapabilities getOptions() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        firefoxOptions.setAcceptInsecureCerts(true);
        firefoxOptions.addArguments("--start-maximized");
        return firefoxOptions;
    }
}
