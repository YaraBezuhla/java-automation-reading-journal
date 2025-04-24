package journal.reading.automation.pageObjects;

import journal.reading.automation.config.utilities.WaitService;
import journal.reading.automation.pageObjects.components.BookTitlesComponent;
import journal.reading.automation.pageObjects.components.BurgerComponent;
import journal.reading.automation.pageObjects.components.HeaderComponent;
import journal.reading.automation.pageObjects.pages.*;
import org.openqa.selenium.WebDriver;


public class PageObjectsFacade {
    private final WebDriver driver;
    private final WaitService wait;

    public PageObjectsFacade(WebDriver driver, WaitService wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public BookTitlesComponent bookTitlesComponent() {
        return new BookTitlesComponent(driver, wait);
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

    public AuthPageObject authPageObject() {
        return new AuthPageObject(driver);
    }

    public HeaderComponent headerComponent() {
        return new HeaderComponent(driver);
    }

    public BookPageObject bookPageObject() {
        return new BookPageObject(driver);
    }

    public BurgerComponent burgerComponent() {
        return new BurgerComponent(driver, wait);
    }

}
