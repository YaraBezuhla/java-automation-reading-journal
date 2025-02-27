package journal.reading.automation.uiTests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import journal.reading.automation.pageObjects.components.BookTitlesComponent;
import journal.reading.automation.pageObjects.pages.HomePagePageObject;
import journal.reading.automation.database.DataManipulation;
import journal.reading.automation.database.GetDataWithMongoDB;
import journal.reading.automation.config.LaunchSettings;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class AuthorPageTests extends LaunchSettings {

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Description("Перевірка, що на сторінці автора виводяться всі його книги, що є в БД")
    public void AssertBooksOnAuthorPage() {
        GetDataWithMongoDB getDataWithMongoDB = new GetDataWithMongoDB();
        HomePagePageObject homePagePageObject = new HomePagePageObject(driver);
        DataManipulation dataManipulation = new DataManipulation();
        BookTitlesComponent bookTitlesComponent = new BookTitlesComponent(driver);

        homePagePageObject.goToAuthorPage("Ілларіон Павлюк");
        ArrayList<String> dbTitles = getDataWithMongoDB.getBookTitlesOneAuthorFromDatabase("Ілларіон Павлюк");
        ArrayList<String> webTitles = bookTitlesComponent.getBookTitlesOnWebsite();
        dataManipulation.compareDataFromWebsiteAndDatabase(dbTitles,webTitles);
    }
}
