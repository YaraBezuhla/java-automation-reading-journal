package journal.reading.automation.pageObjects.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

public class HomePagePageObject {
    private final WebDriver driver;

    public HomePagePageObject(WebDriver driver) {
        this.driver = driver;
    }

    By topBooksBlockTitle = By.xpath("//div[@data-test='top-books']/h2");
    By topAuthorsBlockTitle = By.xpath("//div[@data-test='top-authors']/h2");

    @Step("Отримати назву блоку з топовими книгами")
    public String getTopBooksBlockTitle() {
        WebElement booksBlockTitle = driver.findElement(topBooksBlockTitle);
        return booksBlockTitle.getText();
    }

    @Step("Отримати назву блоку з топовими авторами")
    public String getTopAuthorsBlockTitle() {
        WebElement authorsBlockTitle = driver.findElement(topAuthorsBlockTitle);
        return authorsBlockTitle.getText();
    }

    @Step("Перевірити назву блоку")
    public void checkBlockTitle(String titleOnWebsite, String expectedTitle) {
        Assert.assertEquals(titleOnWebsite, expectedTitle, "Тайтл на сайті не співпадає з очікуваним тайтлом");
    }

    By authorsName = By.xpath("//div[@data-test='author-card']/h3");
    By loadMoreButtonAuthorsBlock = By.xpath("//div[@data-test='top-authors']//button[@data-test='load-more-button']");

    @Step("Перейти на сторінку автора")
    public void goToAuthorPage(String authorName) {

        while (true) {
            try {
                WebElement loadMoreButtonWE = driver.findElement(loadMoreButtonAuthorsBlock);
                if (loadMoreButtonWE.isDisplayed()) {
                    loadMoreButtonWE.click();
                } else {
                    break;
                }
            } catch (NoSuchElementException e) {
                break;
            }
        }

        List<WebElement> authorNameArray = driver.findElements(authorsName);

        for (WebElement author : authorNameArray) {
            String name = author.getText();
            if (name.contains(authorName)) {
                author.click();
                break;
            }
        }
    }

    By searchPage = By.xpath("//a[@data-test='search-link']");

    @Step("Перейти на сторінку пошуку")
    public void goToSearchPage() {
        WebElement searchPageWE = driver.findElement(searchPage);
        searchPageWE.click();
    }
}
