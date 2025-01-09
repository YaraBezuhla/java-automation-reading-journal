package journal.reading.automation;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import journal.reading.automation.pageObjects.BookTitlesComponent;
import journal.reading.automation.pageObjects.HomePagePageObject;
import journal.reading.automation.settings.database.DataManipulation;
import journal.reading.automation.settings.database.GetDateWithMongoDB;
import journal.reading.automation.settings.launch.LaunchSettings;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class AuthorPageTests extends LaunchSettings {

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Description("Перевірка, що на сторінці автора виводяться всі його книги, що є в БД")
    public void AssertBooksOnAuthorPage() {
        GetDateWithMongoDB getDateWithMongoDB = new GetDateWithMongoDB();
        HomePagePageObject homePagePageObject = new HomePagePageObject(driver);
        DataManipulation dataManipulation = new DataManipulation();
        BookTitlesComponent bookTitlesComponent = new BookTitlesComponent(driver);

        homePagePageObject.goToAuthorPage("Ілларіон Павлюк");
        ArrayList<String> dbTitles = getDateWithMongoDB.getBookTitlesOneAuthorFromDatabase("Ілларіон Павлюк");
        ArrayList<String> webTitles = bookTitlesComponent.getBookTitlesOnWebsite();
        dataManipulation.compareDataFromWebsiteAndDatabase(dbTitles,webTitles);
    }
}
