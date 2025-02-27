package journal.reading.automation.preConditions;

import journal.reading.automation.api.ApiMethods;
import org.testng.annotations.Test;

public class PreConditionsTests {

    @Test
    public void deleteBooksByTitle(){
        ApiMethods apiMethods = new ApiMethods();
        apiMethods.deleteBookApiByTitle();
    }
}
