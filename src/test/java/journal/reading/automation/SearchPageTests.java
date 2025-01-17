package journal.reading.automation;

import journal.reading.automation.datas.BookProcessor;
import journal.reading.automation.pageObjects.HomePagePageObject;
import journal.reading.automation.pageObjects.SearchPagePageObject;
import journal.reading.automation.settings.launch.LaunchSettings;
import org.testng.annotations.Test;

public class SearchPageTests extends LaunchSettings {

    @Test
    public void checkSearchTitle() {
        HomePagePageObject homePagePageObject = new HomePagePageObject(driver);
        SearchPagePageObject searchPagePageObject = new SearchPagePageObject(driver);
        BookProcessor bookProcessor = new BookProcessor();

        homePagePageObject.goToSearchPage();
        searchPagePageObject.clickSearchInput();
        String titleForSearch = bookProcessor.getRandomTitle();
        searchPagePageObject.inputTextInSearchInput(titleForSearch);
        searchPagePageObject.assertBookFound(titleForSearch);
    }
}
