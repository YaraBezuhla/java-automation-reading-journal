package journal.reading.automation.config.browserOptions;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeOptionsProvider implements BrowserOptionsProvider {
    @Override
    public MutableCapabilities getOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        chromeOptions.setAcceptInsecureCerts(false); // SSL сертифікат
        chromeOptions.addArguments("--start-maximized");
        return chromeOptions;
    }
}
