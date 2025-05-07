package journal.reading.automation.pageObjects.components;

import io.qameta.allure.Step;
import journal.reading.automation.core.utilities.WaitService;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderComponent {
    private final WaitService wait;

    public HeaderComponent(WebDriver driver, WaitService wait) {
        PageFactory.initElements(driver, this);
        this.wait = wait;
    }

    @FindBy(xpath = "//a[@data-test='search-link']")
    private WebElement searchPage;

    @Step("Go to the search page")
    public void goToSearchPage() {
        searchPage.click();
    }

    @FindBy(xpath = "//a[@data-test='add-book-link']")
    private WebElement addBook;

    @Step("Go to Add Book page")
    public void goToAddBook() {
        addBook.click();
    }

    @FindBy(className = "auth-btn")
    private WebElement loginInHeader;

    @Step("Click Login in Header")
    public void clickLoginInHeader() {
        loginInHeader.click();
    }

    @FindBy(className = "burger-menu")
    private WebElement burger;

    @Step("Click on burger")
    public void clickBurger() {
        wait.waitForClickable(burger).click();
    }
}
