package journal.reading.automation.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.NoSuchElementException;

public class HomePagePageObject {
    private WebDriver driver;
    public HomePagePageObject(WebDriver driver) {
        this.driver = driver;
    }
    By booksName = By.xpath("//h3[@name]");
    By loadMoreButton = By.xpath("//div[@data-test='top-books']//button[@data-test='load-more-button']");

    public ArrayList<String> getAllTitles(){
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
        for (String title : titlesList) {
            System.out.println(title);
        }
        return titlesList;
    }

    public void compareBookTitlesWithStream(ArrayList<String> dbTitles, ArrayList<String> webTitles) {
        // Перевірка на повну відповідність
        boolean areEqual = dbTitles.stream().sorted().collect(Collectors.toList())
                .equals(webTitles.stream().sorted().collect(Collectors.toList()));

        if (areEqual) {
            System.out.println("Lists are identical. All book titles from the database match those on the website.");
        } else {
            System.out.println("Lists are not identical.");

            // Виведення книг, яких не вистачає на сайті
            List<String> missingOnWebsite = dbTitles.stream()
                    .filter(title -> !webTitles.contains(title))
                    .collect(Collectors.toList());
            System.out.println("Books in the database but missing on the website: " + missingOnWebsite);

            // Виведення книг, яких не вистачає в базі даних
           List<String> missingInDatabase = webTitles.stream()
                    .filter(title -> !dbTitles.contains(title))
                    .collect(Collectors.toList());
            System.out.println("Books on the website but missing in the database: " + missingInDatabase);
        }
    }
}
