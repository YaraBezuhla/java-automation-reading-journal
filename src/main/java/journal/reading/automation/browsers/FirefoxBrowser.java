package journal.reading.automation.browsers;

import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxBrowser {
    public WebDriver getDriver(){
        WebDriver driver = new FirefoxDriver();
        return driver;
    }

}
