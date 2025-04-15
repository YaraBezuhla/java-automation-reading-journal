package journal.reading.automation.uiTests;

import io.qameta.allure.Description;
import journal.reading.automation.datas.BookProcessor;
import journal.reading.automation.pageObjects.components.PagesInHeaderComponents;
import journal.reading.automation.pageObjects.pages.SearchPagePageObject;
import journal.reading.automation.config.LaunchSettings;
import org.testng.annotations.Test;

public class SearchPageTests extends LaunchSettings {

    @Test
    @Description("Перевірка пошуку книги по назві")
    public void checkSearchTitle() {
        SearchPagePageObject searchPagePageObject = new SearchPagePageObject(driver);
        PagesInHeaderComponents pagesInHeaderComponents = new PagesInHeaderComponents(driver);
        BookProcessor bookProcessor = new BookProcessor();

        pagesInHeaderComponents.goToSearchPage();
        searchPagePageObject.clickSearchInput();
        String titleForSearch = bookProcessor.getRandomTitle();
        searchPagePageObject.inputTextInSearchInput(titleForSearch);
        searchPagePageObject.assertBookFoundByName(titleForSearch);
    }

    @Test
    @Description("Перевірка пошуку книги/книг по автору")
    public void checkSearchAuthor() {
        SearchPagePageObject searchPagePageObject = new SearchPagePageObject(driver);
        PagesInHeaderComponents pagesInHeaderComponents = new PagesInHeaderComponents(driver);
        BookProcessor bookProcessor = new BookProcessor();

        pagesInHeaderComponents.goToSearchPage();
        searchPagePageObject.clickSearchInput();
        String authorForSearch = bookProcessor.getRandomAuthor();
        searchPagePageObject.inputTextInSearchInput(authorForSearch);
        searchPagePageObject.assertBookFoundByAuthor(authorForSearch);
    }

    @Test
    @Description("Перевірка валідації при відсутності книги")
    public void checkValidationNoResult() {
        SearchPagePageObject searchPagePageObject = new SearchPagePageObject(driver);
        PagesInHeaderComponents pagesInHeaderComponents = new PagesInHeaderComponents(driver);
        String expectedText = "Інтеррнат";

        pagesInHeaderComponents.goToSearchPage();
        searchPagePageObject.clickSearchInput();
        searchPagePageObject.inputTextInSearchInput(expectedText);
        searchPagePageObject.assertNoResultsValidation(expectedText);
    }
}
