package journal.reading.automation.preConditions;

import journal.reading.automation.services.api.ApiMethods;
import journal.reading.automation.testData.providers.BookDataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class PreConditionsTests {

    @Test
    public void deleteBooksByTitle(){
        ApiMethods apiMethods = new ApiMethods();
        List<String> bookTitles = BookDataProvider.getBookTitles();
        apiMethods.deleteBooksApiByTitle(bookTitles);
    }
}
