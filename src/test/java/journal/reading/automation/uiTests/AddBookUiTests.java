package journal.reading.automation.uiTests;

import io.qameta.allure.Description;
import journal.reading.automation.core.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddBookUiTests extends BaseTest {

    @DataProvider(name = "bookData")
    public Object[][] bookDataProvider() {
        return new Object[][]{
                {"1984", "George Orwell", "Біографія"},
                {"The Great Gatsby", "F. Scott Fitzgerald", "Роман"},
                {"To Kill a Mockingbird", "Harper Lee", "Пригоди"}
        };
    }

    @Test(dataProvider = "bookData")
    @Description("Parameterised test for adding books through a form")
    public void addBookTest(String title, String author, String genre) {
        pages.headerComponent().goToAddBook();
        pages.addBookPageObject().enterTitle(title);
        pages.addBookPageObject().enterAuthor(author);
        pages.addBookPageObject().selectGenre(genre);
    }
}
