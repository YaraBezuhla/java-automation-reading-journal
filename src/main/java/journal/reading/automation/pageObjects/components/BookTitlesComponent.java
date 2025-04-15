package journal.reading.automation.pageObjects.components;

import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class BookTitlesComponent {

    public BookTitlesComponent(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h3[@name]")
    private List<WebElement> booksName;

    @FindBy(xpath = "//div[@data-test='top-books']//button[@data-test='load-more-button']")
    private WebElement loadMoreButtonBooksBlock;

    @Step("Отримати назви книг")
    public ArrayList<String> getBookTitlesOnWebsite() {
        ArrayList<String> titlesList = new ArrayList<>();
        while (true) {
            try {
                if (loadMoreButtonBooksBlock.isDisplayed()) {
                    loadMoreButtonBooksBlock.click();
                } else {
                    break;
                }
            } catch (NoSuchElementException e) {
                break;
            }
        }
        for (WebElement name : booksName) {
            String title = name.getText();
            if (!title.isEmpty()) {
                titlesList.add(title);
            }
        }
        return titlesList;
    }
}
