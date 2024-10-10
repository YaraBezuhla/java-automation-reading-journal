package journal.reading.automation.settings.launch;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.testng.annotations.*;

@Listeners({ TestListener.class })
public class LaunchSettings {

    public WebDriver driver;

    ChromeOptions chromeOptions = new ChromeOptions();
    public ChromeOptions configChromeOptions(){
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        chromeOptions.setAcceptInsecureCerts(false); //SSL сертифікат
        chromeOptions.addArguments("--start-maximized");

        return chromeOptions;
    }

    @BeforeMethod
    public void setup() {
    //    driver.manage().window().maximize();
        driver = new ChromeDriver(configChromeOptions());
        driver.get(Sites.siteDomains.locale);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
