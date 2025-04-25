package journal.reading.automation.pageObjects.components;

import io.qameta.allure.Step;
import journal.reading.automation.config.utilities.WaitService;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteButtonWithList {
    private final WaitService wait;

    public DeleteButtonWithList(WebDriver driver, WaitService wait) {
        PageFactory.initElements(driver, this);
        this.wait = wait;
    }

    @FindBy(className = "delete-button")
    private WebElement deleteBtn;

    @Step("Delete book with list")
    public void deleteBtnClick() {
        try {
            wait.waitForClickable(deleteBtn).click();
        } catch (Exception ex) {
            throw new RuntimeException("В списку відсутня книга");
        }


    }
}
