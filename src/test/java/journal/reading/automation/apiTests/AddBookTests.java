package journal.reading.automation.apiTests;

import io.qameta.allure.Description;
import journal.reading.automation.services.api.ApiMethods;
import journal.reading.automation.testData.providers.BookDataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;


public class AddBookTests {

    @Test
    @Description("Checking the successful addition of a book via api")
    public void successfulAddingBookTest() {
        ApiMethods apiMethods = new ApiMethods();
        List<Map<String, Object>> books = BookDataProvider.getBooks();
        apiMethods.addBookApi(books.get(0), 201);
    }

    @Test
    @Description("Checking the unsuccessful addition of a book via api")
    public void unsuccessfulAddingDuplicateBookTest() {
        ApiMethods apiMethods = new ApiMethods();
        List<Map<String, Object>> books = BookDataProvider.getBooks();
        apiMethods.addBookApi(books.get(1), 201);
        apiMethods.addBookApi(books.get(1), 409);
    }
}
