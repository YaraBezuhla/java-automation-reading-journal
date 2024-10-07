package journal.reading.automation.browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeBrowser {
    public WebDriver getDriver(){
        WebDriver driver = new ChromeDriver();
        return driver;
 }
}
