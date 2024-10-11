package journal.reading.automation;

import io.qameta.allure.Description;
import journal.reading.automation.settings.api.ApiMethods;
import org.testng.annotations.Test;

public class AddBookTests {

    @Test
    @Description("Перевірка додавання книг через апі")
    public void addBookTest(){
        ApiMethods apiMethods = new ApiMethods();
        apiMethods.addBookApi();

    }
}
