package journal.reading.automation.pageObjects.pages;

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
    public void assertBookFoundByName(String expectedTitle) {
        WebElement nameBookWE = driver.findElement(nameBook);
        nameBookWE.isDisplayed();
        String titleDisplayed = nameBookWE.getText();
        Assert.assertEquals(titleDisplayed, expectedTitle, "Назва книги не вірна");
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

    By noResultsValidation = By.xpath("//div[@class='no-results']");

    @Step("Перевірка, що з'являється валідація коли відсутні результати пошуку")
    public void assertNoResultsValidation(String inputText) {
        driver.findElement(noResultsValidation).isDisplayed();
        WebElement noResultsValidationWE = driver.findElement(noResultsValidation);

    //    noResultsValidationWE.isDisplayed();
        String validationDisplayed = noResultsValidationWE.getText();
        String validationExpected = "Нічого не знайдено за запитом \"" + inputText + "\"";

        Assert.assertEquals(validationDisplayed, validationExpected, "Проблеми з валідацією");
    }
}
