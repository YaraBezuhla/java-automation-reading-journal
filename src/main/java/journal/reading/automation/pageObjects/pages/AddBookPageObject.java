package journal.reading.automation.pageObjects.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddBookPageObject {

    public AddBookPageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "title")
    private WebElement titleInput;

    @FindBy(id = "author")
    private WebElement authorInput;

    @FindBy(id = "genre")
    private WebElement genreSelect;

    @Step("Enter the name of book")
    public void enterTitle(String title) {
        titleInput.sendKeys(title);
    }

    @Step("Enter the author of book")
    public void enterAuthor(String author) {
        authorInput.sendKeys(author);
    }

    @Step("Choose a book genre")
    public void selectGenre(String genre) {
        Select select = new Select(genreSelect);
        select.selectByVisibleText(genre);
    }
}
