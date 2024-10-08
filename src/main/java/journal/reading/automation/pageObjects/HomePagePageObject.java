package journal.reading.automation.pageObjects;

import journal.reading.automation.settings.launch.LaunchSettings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class HomePagePageObject {
    private WebDriver driver;
    public HomePagePageObject(WebDriver driver) {
        this.driver = driver;
    }
    By booksName = By.xpath("//h3[@name]");
    By loadMoreButton = By.xpath("//div[@data-test='top-books']//button[@data-test='load-more-button']");

    public void getAllTitles(){
        ArrayList<String> titlesList = new ArrayList<>();

        List<WebElement> bookNameArray = driver.findElements(booksName);
        for (WebElement name : bookNameArray){
            String title = name.getText();
            if(!title.isEmpty()){
                titlesList.add(title);
            }
        }
        for (String title : titlesList) {
            System.out.println(title);
        }
    }
}
