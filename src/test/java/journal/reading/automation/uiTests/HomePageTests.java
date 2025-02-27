package journal.reading.automation.uiTests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import journal.reading.automation.pageObjects.components.BookTitlesComponent;
import journal.reading.automation.pageObjects.pages.HomePagePageObject;
import journal.reading.automation.database.DataManipulation;
import journal.reading.automation.database.GetDataWithMongoDB;
import journal.reading.automation.config.LaunchSettings;
import org.testng.annotations.*;
import java.util.ArrayList;

//@Listeners(journal.reading.automation.settings.launch.TestListener.class)
@Feature("Home Page")
public class HomePageTests extends LaunchSettings {

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Description("Порівняння книг, що є в базі і що виводяться на сайті по тайтлу")
    public void AssertBooks() {
        GetDataWithMongoDB getDataWithMongoDB = new GetDataWithMongoDB();
        DataManipulation dataManipulation = new DataManipulation();
        BookTitlesComponent bookTitlesComponent = new BookTitlesComponent(driver);

        ArrayList<String> dbTitles = getDataWithMongoDB.getBookTitlesFromDatabase();
        ArrayList<String> webTitles = bookTitlesComponent.getBookTitlesOnWebsite();
        dataManipulation.compareDataFromWebsiteAndDatabase(dbTitles,webTitles);
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    @Description("Перевірка назви блоку з топовими книгами")
    public void AssertTopBooksBlockTitle() {
        HomePagePageObject homePagePageObject = new HomePagePageObject(driver);

        homePagePageObject.checkBlockTitle(homePagePageObject.getTopBooksBlockTitle(),
                "Найпопулярніші книги");
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    @Description("Перевірка назви блоку з топовими авторами")
    public void AssertTopAuthorsBlockTitle() {
        HomePagePageObject homePagePageObject = new HomePagePageObject(driver);

        homePagePageObject.checkBlockTitle(homePagePageObject.getTopAuthorsBlockTitle(),
                "Українські автори");
    }

}
