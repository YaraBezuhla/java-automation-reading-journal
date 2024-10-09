package journal.reading.automation;

import journal.reading.automation.pageObjects.HomePagePageObject;
import journal.reading.automation.settings.database.DataManipulation;
import journal.reading.automation.settings.database.GetDateWithMongoDB;
import journal.reading.automation.settings.launch.LaunchSettings;
import org.testng.annotations.*;
import java.util.ArrayList;

public class HomePageTests extends LaunchSettings {
    GetDateWithMongoDB getDateWithMongoDB = new GetDateWithMongoDB();
    HomePagePageObject homePagePageObject = new HomePagePageObject(driver);
    DataManipulation dataManipulation = new DataManipulation();

    @Test
    public void TitleBlockBooks() {
        ArrayList<String> dbTitles = getDateWithMongoDB.getBookTitlesFromDatabase();
        ArrayList<String> webTitles = homePagePageObject.getBookTitlesOnWebsite();
        dataManipulation.compareDataFromWebsiteAndDatabase(dbTitles,webTitles);
    }

}
