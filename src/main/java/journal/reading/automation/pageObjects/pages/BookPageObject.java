package journal.reading.automation.pageObjects.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookPageObject {

    public BookPageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@data-test='add-to-wishlist']")
    private WebElement wishListBtn;


    @Step("Click on add to wishlist")
    public void clickWishListBtn() {
        wishListBtn.click();
    }

    @FindBy(xpath = "//button[@data-test='add-to-read']")
    private WebElement readListBtn;

    @Step("Click on add to read list")
    public void clickReadListBtn() {
        readListBtn.click();
    }
}
