package journal.reading.automation.pageObjects.components;

import io.qameta.allure.Step;
import journal.reading.automation.config.utilities.WaitService;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class BookTitlesComponent {
    private final WaitService wait;

    public BookTitlesComponent(WebDriver driver, WaitService wait) {
        PageFactory.initElements(driver, this);
        this.wait = wait;
    }

    @FindBy(className = "book-title")
    private List<WebElement> booksName;

    @FindBy(xpath = "//div[@data-test='top-books']//button[@data-test='load-more-button']")
    private WebElement loadMoreButtonBooksBlock;

    @Step("Get book titles")
    public ArrayList<String> getBookTitlesOnWebsite() {
        ArrayList<String> titlesList = new ArrayList<>();
        while (true) {
            try {
                if (loadMoreButtonBooksBlock.isDisplayed()) {
                    loadMoreButtonBooksBlock.click();
                } else {
                    break;
                }
            } catch (NoSuchElementException e) {
                break;
            }
        }
        for (WebElement name : booksName) {
            String title = name.getText();
            if (!title.isEmpty()) {
                titlesList.add(title);
            }
        }
        return titlesList;
    }

    @Step("Open book")
    public void openBook(String bookExpected) {
        for (WebElement name : wait.waitForVisibility(booksName)) {
            String book = name.getText();
            if (book.equals(bookExpected)) {
                name.click();
                break;
            }
        }
    }

    @Step("Check the availability of the book")
    public void checkAvailabilityBook(String bookExpected) {
        boolean found = false;

        for (WebElement name : wait.waitForVisibility(booksName)) {
            String book = name.getText();
            if (book.equals(bookExpected)) {
                found = true;
                break;
            }
        }
        Assert.assertTrue(found, "Book with title '" + bookExpected + "' was not found in the list!");
    }
}
