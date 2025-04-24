package journal.reading.automation.pageObjects.components;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderComponent {

    public HeaderComponent(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@data-test='search-link']")
    private WebElement searchPage;

    @Step("Go to the search page")
    public void goToSearchPage() { searchPage.click(); }

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
}
