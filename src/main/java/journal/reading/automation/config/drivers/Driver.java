package journal.reading.automation.config.drivers;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;

public interface Driver {

    WebDriver CreateDriver(MutableCapabilities options);
}
