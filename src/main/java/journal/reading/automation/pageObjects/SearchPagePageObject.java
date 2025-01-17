package journal.reading.automation.pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

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
    @Step("Перевірити, що книгу знайдено")
    public void assertBookFound(String book) {
        WebElement nameBookWE = driver.findElement(nameBook);
        String title = nameBookWE.getText();
        Assert.assertEquals(book, title, "Назва книги не вірна");
    }
}
