package journal.reading.automation.uiTests;

import io.qameta.allure.Description;
import journal.reading.automation.datas.BookProcessor;
import journal.reading.automation.pageObjects.pages.HomePagePageObject;
import journal.reading.automation.pageObjects.pages.SearchPagePageObject;
import journal.reading.automation.config.LaunchSettings;
import org.testng.annotations.Test;

public class SearchPageTests extends LaunchSettings {

    @Test
    @Description("Перевірка пошуку книги по назві")
    public void checkSearchTitle() {
        HomePagePageObject homePagePageObject = new HomePagePageObject(driver);
        SearchPagePageObject searchPagePageObject = new SearchPagePageObject(driver);
        BookProcessor bookProcessor = new BookProcessor();

        homePagePageObject.goToSearchPage();
        searchPagePageObject.clickSearchInput();
        String titleForSearch = bookProcessor.getRandomTitle();
        searchPagePageObject.inputTextInSearchInput(titleForSearch);
        searchPagePageObject.assertBookFoundByName(titleForSearch);
    }

    @Test
    @Description("Перевірка пошуку книги/книг по автору")
    public void checkSearchAuthor() {
        HomePagePageObject homePagePageObject = new HomePagePageObject(driver);
        SearchPagePageObject searchPagePageObject = new SearchPagePageObject(driver);
        BookProcessor bookProcessor = new BookProcessor();

        homePagePageObject.goToSearchPage();
        searchPagePageObject.clickSearchInput();
        String authorForSearch = bookProcessor.getRandomAuthor();
        searchPagePageObject.inputTextInSearchInput(authorForSearch);
        searchPagePageObject.assertBookFoundByAuthor(authorForSearch);
    }

    @Test
    @Description("Перевірка валідації при відсутності книги")
    public void checkValidationNoResult() {
        HomePagePageObject homePagePageObject = new HomePagePageObject(driver);
        SearchPagePageObject searchPagePageObject = new SearchPagePageObject(driver);
        String expectedText = "Інтеррнат";

        homePagePageObject.goToSearchPage();
        searchPagePageObject.clickSearchInput();
        searchPagePageObject.inputTextInSearchInput(expectedText);
        searchPagePageObject.assertNoResultsValidation(expectedText);
    }
}
