package journal.reading.automation.pageObjects.components;

import io.qameta.allure.Step;
import journal.reading.automation.core.utilities.WaitService;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BurgerComponent {
    private WaitService wait;

    public BurgerComponent(WebDriver driver, WaitService wait) {
        PageFactory.initElements(driver, this);
        this.wait = wait;
    }

    @FindBy(xpath = "//a[@data-test='read-books-link']")
    private WebElement readBooksList;

    @FindBy(xpath = "//a[@data-test='wishlist-link']")
    private WebElement wishList;

    @Step("Click on readBooksList")
    public void clickReadBooksList() {
        wait.waitForVisibility(readBooksList).click();
    }

    @Step("Click on wishList")
    public void clickWishList() {
        wait.waitForVisibility(wishList).click();
    }
}
