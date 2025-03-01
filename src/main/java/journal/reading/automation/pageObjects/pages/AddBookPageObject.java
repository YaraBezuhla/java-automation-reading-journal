package journal.reading.automation.pageObjects.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddBookPageObject {
    private final WebDriver driver;

    public AddBookPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "title")
    private WebElement titleInput;

    @FindBy(id = "author")
    private WebElement authorInput;

    @FindBy(id = "genre")
    private WebElement genreSelect;

    public void enterTitle(String title) {
        titleInput.sendKeys(title);
    }

    public void enterAuthor(String author) {
        authorInput.sendKeys(author);
    }

    public void selectGenre(String genre) {
        Select select = new Select(genreSelect);
        select.selectByVisibleText(genre);
    }
}
