package journal.reading.automation.pageObjects;

import journal.reading.automation.config.utilities.WaitService;
import journal.reading.automation.pageObjects.components.BookTitlesComponent;
import journal.reading.automation.pageObjects.components.PagesInHeaderComponents;
import journal.reading.automation.pageObjects.pages.AddBookPageObject;
import journal.reading.automation.pageObjects.pages.HomePagePageObject;
import journal.reading.automation.pageObjects.pages.SearchPagePageObject;
import org.openqa.selenium.WebDriver;


public class PageObjectsFacade {
    private final WebDriver driver;
    private final WaitService wait;

    public PageObjectsFacade(WebDriver driver, WaitService wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public BookTitlesComponent bookTitlesComponent() {
        return new BookTitlesComponent(driver);
    }

    public PagesInHeaderComponents pagesInHeaderComponents() {
        return new PagesInHeaderComponents(driver);
    }

    public AddBookPageObject addBookPageObject() {
        return new AddBookPageObject(driver);
    }

    public HomePagePageObject homePagePageObject() {
        return new HomePagePageObject(driver);
    }

    public SearchPagePageObject searchPagePageObject() {
        return new SearchPagePageObject(driver, wait);
    }

}
