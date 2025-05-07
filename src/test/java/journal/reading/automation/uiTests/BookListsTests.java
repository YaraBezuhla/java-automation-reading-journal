package journal.reading.automation.uiTests;

import io.qameta.allure.Description;
import journal.reading.automation.core.BaseTest;
import journal.reading.automation.testData.providers.CredentialsProvider;
import org.testng.annotations.Test;

public class BookListsTests extends BaseTest {

    @Test
    @Description("Successfully add the book to your read list")
    public void successfullyAddBookToReadList() {
        String bookExpected = "Інтернат";
        pages.headerComponent().clickLoginInHeader();
        pages.authPageObject().fullAuthorization(CredentialsProvider.get("username"), CredentialsProvider.get("password"));
        pages.bookTitlesComponent().openBook(bookExpected);
        pages.bookPageObject().clickReadListBtn();
        pages.headerComponent().clickBurger();
        pages.burgerComponent().clickReadBooksList();
        pages.bookTitlesComponent().checkAvailabilityBook(bookExpected);
    }

    @Test
    @Description("Successfully add the book to your wish list")
    public void successfullyAddBookToWishList() {
        String bookExpected = "Я бачу, вас цікавить пітьма";
        pages.headerComponent().clickLoginInHeader();
        pages.authPageObject().fullAuthorization(CredentialsProvider.get("username"), CredentialsProvider.get("password"));
        pages.bookTitlesComponent().openBook(bookExpected);
        pages.bookPageObject().clickWishListBtn();
        pages.headerComponent().clickBurger();
        pages.burgerComponent().clickWishList();
        pages.bookTitlesComponent().checkAvailabilityBook(bookExpected);
    }

    @Test
    @Description("Delete book with reag list")
    public void deleteBookWithReadList(){
        pages.headerComponent().clickLoginInHeader();
        pages.authPageObject().fullAuthorization(CredentialsProvider.get("username"), CredentialsProvider.get("password"));
        pages.headerComponent().clickBurger();
        pages.burgerComponent().clickReadBooksList();
        pages.deleteButtonWithList().deleteBtnClick();
    }

    @Test
    @Description("Delete book with wish list")
    public void deleteBookWithWithList(){
        pages.headerComponent().clickLoginInHeader();
        pages.authPageObject().fullAuthorization(CredentialsProvider.get("username"), CredentialsProvider.get("password"));
        pages.headerComponent().clickBurger();
        pages.burgerComponent().clickWishList();
        pages.deleteButtonWithList().deleteBtnClick();
    }
}
