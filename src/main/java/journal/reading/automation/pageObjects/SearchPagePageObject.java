package journal.reading.automation.pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class SearchPagePageObject {
    private final WebDriver driver;

    public SearchPagePageObject(WebDriver driver) {
        this.driver = driver;
    }

    By searchInput = By.xpath("//input[@class='search-input']");

    @Step("Клікнути в поле пошуку")
    public void clickSearchInput() {
        WebElement searchInputWE = driver.findElement(searchInput);
        searchInputWE.click();
    }

    @Step("Ввести пошуковий запит")
    public void inputTextInSearchInput(String searchText) {
        WebElement searchInputWE = driver.findElement(searchInput);
        searchInputWE.sendKeys(searchText);
    }

    By nameBook = By.xpath("//h3[@data-test='search-book-title']");

    @Step("Перевірити, що книгу знайдено по назві")
    public void assertBookFoundByName(String title) {
        WebElement nameBookWE = driver.findElement(nameBook);
        nameBookWE.isDisplayed();
        String titleDisplayed = nameBookWE.getText();
        Assert.assertEquals(title, titleDisplayed, "Назва книги не вірна");
    }

    By authorBook = By.xpath("//p[@data-test='search-book-author']");

    @Step("Перевірити, знайдено книгу/книги по автору")
    public void assertBookFoundByAuthor(String expectedAuthor) {
        List<WebElement> authorList = driver.findElements(authorBook);

        Assert.assertTrue(
                authorList.stream().allMatch(element -> element.getText().equals(expectedAuthor)),
                "Не всі книги належать автору '" + expectedAuthor + "'."
        );
    }
}
