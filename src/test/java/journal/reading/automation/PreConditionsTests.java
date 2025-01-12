package journal.reading.automation;

import journal.reading.automation.settings.api.ApiMethods;
import org.testng.annotations.Test;

public class PreConditionsTests {

    @Test
    public void deleteBooks(){
        ApiMethods apiMethods = new ApiMethods();
        apiMethods.deleteBookApi();
    }
}
