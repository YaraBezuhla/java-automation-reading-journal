package journal.reading.automation.pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BookTitlesComponent {

    private final WebDriver driver;

    public BookTitlesComponent(WebDriver driver) {
        this.driver = driver;
    }


    By booksName = By.xpath("//h3[@name]");
    By loadMoreButtonBooksBlock = By.xpath("//div[@data-test='top-books']//button[@data-test='load-more-button']");

    @Step("Отримати назви книг на головній сторінці сайту")
    public ArrayList<String> getBookTitlesOnWebsite() {
        ArrayList<String> titlesList = new ArrayList<>();

        while (true) {
            try {
                WebElement loadMoreButtonWE = driver.findElement(loadMoreButtonBooksBlock);
                if (loadMoreButtonWE.isDisplayed()) {
                    loadMoreButtonWE.click();
                } else {
                    break;
                }
            } catch (NoSuchElementException e) {
                break;
            }
        }
        List<WebElement> bookNameArray = driver.findElements(booksName);
        for (WebElement name : bookNameArray) {
            String title = name.getText();
            if (!title.isEmpty()) {
                titlesList.add(title);
            }
        }
        return titlesList;
    }
}
