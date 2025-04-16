package journal.reading.automation.pageObjects.pages;

import io.qameta.allure.Step;
import journal.reading.automation.config.utilities.WaitService;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class SearchPagePageObject {
    private final WaitService wait;

    public SearchPagePageObject(WebDriver driver, WaitService wait) {
        PageFactory.initElements(driver, this);
        this.wait = wait;
    }

    @FindBy(xpath = "//input[@class='search-input']")
    private WebElement searchInput;

    @Step("Click in the search field")
    public void clickSearchInput() { searchInput.click(); }

    @Step("Enter a search query")
    public void inputTextInSearchInput(String searchText) { searchInput.sendKeys(searchText); }

    @FindBy(xpath = "//h3[@data-test='search-book-title']")
    private WebElement nameBook;

    @Step("Check that the book is found by name")
    public void assertBookFoundByName(String expectedTitle) {
        String titleDisplayed = wait.waitForVisibility(nameBook).getText();
        Assert.assertEquals(titleDisplayed, expectedTitle, "Назва книги не вірна");
    }

    @FindBy(xpath = "//p[@data-test='search-book-author']")
    private List<WebElement>  authorBook;

    @Step("Check if the book/books were found by author")
    public void assertBookFoundByAuthor(String expectedAuthor) {
        Assert.assertTrue(
                authorBook.stream().allMatch(element -> element.getText().equals(expectedAuthor)),
                "Не всі книги належать автору '" + expectedAuthor + "'."
        );
    }

    @FindBy(xpath = "//div[@class='no-results']")
    private WebElement noResultsValidation;

    @Step("Check that validation appears when there are no search results")
    public void assertNoResultsValidation(String inputText) {
        String validationDisplayed = noResultsValidation.getText();
        String validationExpected = "Нічого не знайдено за запитом \"" + inputText + "\"";

        Assert.assertEquals(validationDisplayed, validationExpected, "Проблеми з валідацією");
    }
}
