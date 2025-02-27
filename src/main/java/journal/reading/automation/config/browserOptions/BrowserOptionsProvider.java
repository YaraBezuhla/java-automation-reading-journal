package journal.reading.automation.config.browserOptions;

import org.openqa.selenium.MutableCapabilities;

public interface BrowserOptionsProvider {
    MutableCapabilities getOptions();
}
