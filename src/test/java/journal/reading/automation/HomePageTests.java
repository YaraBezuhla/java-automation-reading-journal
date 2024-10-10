package journal.reading.automation;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import journal.reading.automation.pageObjects.HomePagePageObject;
import journal.reading.automation.settings.database.DataManipulation;
import journal.reading.automation.settings.database.GetDateWithMongoDB;
import journal.reading.automation.settings.launch.LaunchSettings;
import org.testng.annotations.*;
import java.util.ArrayList;

@Feature("Home Page")
public class HomePageTests extends LaunchSettings {
    GetDateWithMongoDB getDateWithMongoDB = new GetDateWithMongoDB();
    HomePagePageObject homePagePageObject = new HomePagePageObject(driver);
    DataManipulation dataManipulation = new DataManipulation();

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Description("Порівняння книг, що є в базі і що виводяться на сайті по тайтлу")
    public void TitleBlockBooks() {
        ArrayList<String> dbTitles = getDateWithMongoDB.getBookTitlesFromDatabase();
        ArrayList<String> webTitles = homePagePageObject.getBookTitlesOnWebsite();
        dataManipulation.compareDataFromWebsiteAndDatabase(dbTitles,webTitles);
    }

}
