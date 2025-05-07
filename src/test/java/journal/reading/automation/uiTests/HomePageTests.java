package journal.reading.automation.uiTests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import journal.reading.automation.testData.providers.DataManipulation;
import journal.reading.automation.services.database.GetDataWithMongoDB;
import journal.reading.automation.core.BaseTest;
import org.testng.annotations.*;
import java.util.ArrayList;

//@Listeners(journal.reading.automation.settings.launch.TestListener.class)
@Feature("Home Page")
public class HomePageTests extends BaseTest {

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Description("Comparison of books in the database and those displayed on the website by title")
    public void AssertBooks() {
        GetDataWithMongoDB getDataWithMongoDB = new GetDataWithMongoDB();
        DataManipulation dataManipulation = new DataManipulation();

        ArrayList<String> dbTitles = getDataWithMongoDB.getBookTitlesFromDatabase();
        ArrayList<String> webTitles = pages.bookTitlesComponent().getBookTitlesOnWebsite();
        dataManipulation.compareTwoArrays(dbTitles,webTitles);
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    @Description("Check the title of a block with top books")
    public void AssertTopBooksBlockTitle() {
        pages.homePagePageObject().checkBlockTitle(pages.homePagePageObject().getTopBooksBlockTitle(),
                "Найпопулярніші книги");
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    @Description("Verify block titles with top authors")
    public void AssertTopAuthorsBlockTitle() {
        pages.homePagePageObject().checkBlockTitle(pages.homePagePageObject().getTopAuthorsBlockTitle(),
                "Українські автори");
    }

}
