package journal.reading.automation.uiTests;

import journal.reading.automation.config.utilities.LaunchSettings;
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
        pages.headerComponent().goToAddBook();
        pages.addBookPageObject().enterTitle(title);
        pages.addBookPageObject().enterAuthor(author);
        pages.addBookPageObject().selectGenre(genre);
    }
}
