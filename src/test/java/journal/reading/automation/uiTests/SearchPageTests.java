package journal.reading.automation.uiTests;

import io.qameta.allure.Description;
import journal.reading.automation.datas.BookProcessor;
import journal.reading.automation.config.utilities.LaunchSettings;
import org.testng.annotations.Test;

public class SearchPageTests extends LaunchSettings {

    @Test
    @Description("Перевірка пошуку книги по назві")
    public void checkSearchTitle() {
        BookProcessor bookProcessor = new BookProcessor();

        pages.pagesInHeaderComponents().goToSearchPage();
        pages.searchPagePageObject().clickSearchInput();
        String titleForSearch = bookProcessor.getRandomTitle();
        pages.searchPagePageObject().inputTextInSearchInput(titleForSearch);
        pages.searchPagePageObject().assertBookFoundByName(titleForSearch);
    }

    @Test
    @Description("Перевірка пошуку книги/книг по автору")
    public void checkSearchAuthor() {
        BookProcessor bookProcessor = new BookProcessor();

        pages.pagesInHeaderComponents().goToSearchPage();
        pages.searchPagePageObject().clickSearchInput();
        String authorForSearch = bookProcessor.getRandomAuthor();
        pages.searchPagePageObject().inputTextInSearchInput(authorForSearch);
        pages.searchPagePageObject().assertBookFoundByAuthor(authorForSearch);
    }

    @Test
    @Description("Перевірка валідації при відсутності книги")
    public void checkValidationNoResult() {
        String expectedText = "Інтеррнат";

        pages.pagesInHeaderComponents().goToSearchPage();
        pages.searchPagePageObject().clickSearchInput();
        pages.searchPagePageObject().inputTextInSearchInput(expectedText);
        pages.searchPagePageObject().assertNoResultsValidation(expectedText);
    }
}
