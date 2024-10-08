package journal.reading.automation;

import journal.reading.automation.pageObjects.HomePagePageObject;
import journal.reading.automation.settings.database.GetDateWithMongoDB;
import journal.reading.automation.settings.launch.LaunchSettings;
import org.testng.annotations.*;

public class HomePageTests extends LaunchSettings {
    GetDateWithMongoDB getDateWithMongoDB = new GetDateWithMongoDB();
    HomePagePageObject homePagePageObject = new HomePagePageObject(driver);
    @Test
    public void TitleBlockBooks() {
   //     getDateWithMongoDB.loadTitlesFromDatabase();
        homePagePageObject.getAllTitles();
    }

}
