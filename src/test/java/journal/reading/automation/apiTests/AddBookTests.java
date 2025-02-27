package journal.reading.automation.apiTests;

import io.qameta.allure.Description;
import journal.reading.automation.api.ApiMethods;
import org.testng.annotations.Test;


public class AddBookTests {

    @Test
    @Description("Перевірка успішного додавання книги через апі")
    public void successfulAddingBookTest() {
        ApiMethods apiMethods = new ApiMethods();
        apiMethods.addBookApi(0, 201);
    }

    @Test
    @Description("Перевірка успішного додавання книги через апі")
    public void unsuccessfulAddingDuplicateBookTest() {
        ApiMethods apiMethods = new ApiMethods();
        apiMethods.addBookApi(1, 201);
        apiMethods.addBookApi(1, 409);
    }
}
