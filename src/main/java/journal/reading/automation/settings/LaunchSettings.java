package journal.reading.automation.settings;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeOptions;

public class LaunchSettings {

    ChromeOptions chromeOptions = new ChromeOptions();
    public ChromeOptions configChromeOptions(){
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        chromeOptions.setAcceptInsecureCerts(false); //SSL сертифікат
        chromeOptions.addArguments("--start-maximized");

        return chromeOptions;
    }

    WebDriver driver = new ChromeDriver(configChromeOptions());

    @BeforeEach
    public void setup() {
    //    driver.manage().window().maximize();
        driver.get("http://localhost:8081/");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
