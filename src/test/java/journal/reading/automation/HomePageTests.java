package journal.reading.automation;

import journal.reading.automation.pageObjects.HomePagePageObject;
import journal.reading.automation.settings.database.GetDateWithMongoDB;
import journal.reading.automation.settings.launch.LaunchSettings;
import org.testng.annotations.*;

import java.util.List;

public class HomePageTests extends LaunchSettings {
    GetDateWithMongoDB getDateWithMongoDB = new GetDateWithMongoDB();
    HomePagePageObject homePagePageObject = new HomePagePageObject(driver);
    @Test
    public void TitleBlockBooks() {
        List<String> dbTitles = getDateWithMongoDB.loadTitlesFromDatabase();
        List<String> webTitles = homePagePageObject.getAllTitles();
        homePagePageObject.compareBookTitlesWithStream(dbTitles,webTitles);
    }

}
