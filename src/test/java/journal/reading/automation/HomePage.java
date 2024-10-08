package journal.reading.automation;

import journal.reading.automation.settings.*;
import journal.reading.automation.settings.database.GetDateWithMongoDB;
import org.testng.annotations.*;

public class HomePage extends LaunchSettings {
    GetDateWithMongoDB getDateWithMongoDB = new GetDateWithMongoDB();

    @Test
    public void TitleBlockBooks() {
        getDateWithMongoDB.loadTitlesFromDatabase();
    }

}
