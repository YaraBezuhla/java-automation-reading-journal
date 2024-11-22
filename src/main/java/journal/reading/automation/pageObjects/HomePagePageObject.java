package journal.reading.automation.pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

public class HomePagePageObject {
    private final WebDriver driver;
    public HomePagePageObject(WebDriver driver) {
        this.driver = driver;
    }
    By booksName = By.xpath("//h3[@name]");
    By loadMoreButton = By.xpath("//div[@data-test='top-books']//button[@data-test='load-more-button']");

    @Step("Отримати назви книг на головній сторінці сайту")
    public ArrayList<String> getBookTitlesOnWebsite(){
        ArrayList<String> titlesList = new ArrayList<>();

        while (true) {
            try {
                WebElement loadMoreButtonWE = driver.findElement(loadMoreButton);
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
        for (WebElement name : bookNameArray){
            String title = name.getText();
            if(!title.isEmpty()){
                titlesList.add(title);
            }
        }
        return titlesList;
    }

    By topBooksBlockTitle = By.xpath("//div[@data-test='top-books']/h2");
    By topAuthorsBlockTitle = By.xpath("//div[@data-test='top-authors']/h2");

    @Step("Отримати назву блоку з топовими книгами")
    public String getTopBooksBlockTitle(){
        WebElement booksBlockTitle = driver.findElement(topBooksBlockTitle);
        return booksBlockTitle.getText();
    }

    @Step("Отримати назву блоку з топовими авторами")
    public String getTopAuthorsBlockTitle(){
        WebElement authorsBlockTitle = driver.findElement(topAuthorsBlockTitle);
        return authorsBlockTitle.getText();
    }

    @Step("Перевірити назву блоку")
    public void checkBlockTitle(String titleOnWebsite, String expectedTitle){
        Assert.assertEquals(titleOnWebsite, expectedTitle, "Тайтл на сайті не співпадає з очікуваним тайтлом");
    }

}
