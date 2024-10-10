package journal.reading.automation.settings.launch;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.testng.annotations.*;

@Listeners({ TestListener.class })
public class LaunchSettings {

    ChromeOptions chromeOptions = new ChromeOptions();
    public ChromeOptions configChromeOptions(){
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        chromeOptions.setAcceptInsecureCerts(false); //SSL сертифікат
        chromeOptions.addArguments("--start-maximized");

        return chromeOptions;
    }

    public WebDriver driver = new ChromeDriver(configChromeOptions());

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod
    public void setup() {
    //    driver.manage().window().maximize();
        driver.get(Sites.siteDomains.locale);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
