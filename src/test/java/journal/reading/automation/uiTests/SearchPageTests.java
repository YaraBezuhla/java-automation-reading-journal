package journal.reading.automation.uiTests;

import io.qameta.allure.Description;
import journal.reading.automation.testData.processor.BookProcessor;
import journal.reading.automation.core.BaseTest;
import org.testng.annotations.Test;

public class SearchPageTests extends BaseTest {

    @Test
    @Description("Check book search by title")
    public void checkSearchTitle() {
        BookProcessor bookProcessor = new BookProcessor();

        pages.headerComponent().goToSearchPage();
        pages.searchPagePageObject().clickSearchInput();
        String titleForSearch = bookProcessor.getRandomTitle();
        pages.searchPagePageObject().inputTextInSearchInput(titleForSearch);
        pages.searchPagePageObject().assertBookFoundByName(titleForSearch);
    }

    @Test
    @Description("Check the search for a book/books by author")
    public void checkSearchAuthor() {
        BookProcessor bookProcessor = new BookProcessor();

        pages.headerComponent().goToSearchPage();
        pages.searchPagePageObject().clickSearchInput();
        String authorForSearch = bookProcessor.getRandomAuthor();
        pages.searchPagePageObject().inputTextInSearchInput(authorForSearch);
        pages.searchPagePageObject().assertBookFoundByAuthor(authorForSearch);
    }

    @Test
    @Description("Validation check in the absence of a book")
    public void checkValidationNoResult() {
        String expectedText = "Інтеррнат";

        pages.headerComponent().goToSearchPage();
        pages.searchPagePageObject().clickSearchInput();
        pages.searchPagePageObject().inputTextInSearchInput(expectedText);
        pages.searchPagePageObject().assertNoResultsValidation(expectedText);
    }
}
