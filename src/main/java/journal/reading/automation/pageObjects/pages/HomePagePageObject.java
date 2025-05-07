package journal.reading.automation.pageObjects.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePagePageObject {

    public HomePagePageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@data-test='top-books']/h2")
    private WebElement topBooksBlockTitle;

    @Step("Get the name of the block with top books")
    public String getTopBooksBlockTitle() {
        return topBooksBlockTitle.getText();
    }
    @FindBy(xpath = "//div[@data-test='top-authors']/h2")
    private WebElement topAuthorsBlockTitle;

    @Step("Get the name of the block with top authors")
    public String getTopAuthorsBlockTitle() {
        return topAuthorsBlockTitle.getText();
    }

    @Step("Check the block name")
    public void checkBlockTitle(String titleOnWebsite, String expectedTitle) {
        Assert.assertEquals(titleOnWebsite, expectedTitle, "The title on the site does not match the expected title");
    }

    @FindBy(xpath = "//div[@data-test='author-card']/h3")
    private List<WebElement> authorsName;

    @FindBy(xpath = "//div[@data-test='top-authors']//button[@data-test='load-more-button']")
    private WebElement loadMoreButtonAuthorsBlock;

    @Step("Go to the author's page")
    public void goToAuthorPage(String authorName) {

        while (true) {
            try {
                if (loadMoreButtonAuthorsBlock.isDisplayed()) {
                    loadMoreButtonAuthorsBlock.click();
                } else {
                    break;
                }
            } catch (NoSuchElementException e) {
                break;
            }
        }
        for (WebElement author : authorsName) {
            String name = author.getText();
            if (name.contains(authorName)) {
                author.click();
                break;
            }
        }
    }
}
