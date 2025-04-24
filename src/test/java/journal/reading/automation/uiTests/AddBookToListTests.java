package journal.reading.automation.uiTests;

import io.qameta.allure.Description;
import journal.reading.automation.config.utilities.LaunchSettings;
import org.testng.annotations.Test;

public class AddBookToListTests extends LaunchSettings {

    @Test
    @Description("Successfully add the book to your wish list")
    public void successfullyAddBookToWishList() {
        String bookExpected = "Інтернат";
        pages.headerComponent().clickLoginInHeader();
        pages.authPageObject().fullAuthorization("testlogin4", "testlogin4");
        pages.bookTitlesComponent().openBook(bookExpected);
        pages.bookPageObject().clickReadListBtn();
        pages.headerComponent().clickBurger();
        pages.burgerComponent().clickReadBooksList();
        pages.bookTitlesComponent().checkAvailabilityBook(bookExpected);
    }
}
