package journal.reading.automation.uiTests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import journal.reading.automation.services.database.DataManipulation;
import journal.reading.automation.services.database.GetDataWithMongoDB;
import journal.reading.automation.core.BaseTest;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class AuthorPageTests extends BaseTest {

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Description("Checking that the author's page displays all his books in the database")
    public void AssertBooksOnAuthorPage() {
        GetDataWithMongoDB getDataWithMongoDB = new GetDataWithMongoDB();
        DataManipulation dataManipulation = new DataManipulation();

        pages.homePagePageObject().goToAuthorPage("Ілларіон Павлюк");
        ArrayList<String> dbTitles = getDataWithMongoDB.getBookTitlesOneAuthorFromDatabase("Ілларіон Павлюк");
        ArrayList<String> webTitles = pages.bookTitlesComponent().getBookTitlesOnWebsite();
        dataManipulation.compareDataFromWebsiteAndDatabase(dbTitles,webTitles);
    }
}
