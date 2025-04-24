package journal.reading.automation.uiTests;

import io.qameta.allure.Description;
import journal.reading.automation.config.utilities.LaunchSettings;
import org.testng.annotations.Test;

public class AddBookToListTests extends LaunchSettings {

    @Test
    @Description("Successfully add the book to your wish list")
    public void successfullyAddBookToWishList(){
        pages.headerComponent().clickLoginInHeader();
        pages.authPageObject().fullAuthorization("testlogin4", "testlogin4");
    }
}
