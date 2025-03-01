package journal.reading.automation.uiTests;

import journal.reading.automation.config.LaunchSettings;
import journal.reading.automation.pageObjects.pages.AddBookPageObject;
import journal.reading.automation.pageObjects.pages.HomePagePageObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddBookUiTests extends LaunchSettings {

    @DataProvider(name = "bookData")
    public Object[][] bookDataProvider() {
        return new Object[][]{
                {"1984", "George Orwell", "Біографія"},
                {"The Great Gatsby", "F. Scott Fitzgerald", "Роман"},
                {"To Kill a Mockingbird", "Harper Lee", "Пригоди"}
        };
    }

    @Test(dataProvider = "bookData")
    public void addBookTest(String title, String author, String genre) {
        AddBookPageObject addBook = new AddBookPageObject(driver);
        HomePagePageObject homePage = new HomePagePageObject(driver);

        homePage.goToAddBook();
        addBook.enterTitle(title);
        addBook.enterAuthor(author);
        addBook.selectGenre(genre);
    }
}
