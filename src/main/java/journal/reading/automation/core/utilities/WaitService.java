package journal.reading.automation.core.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WaitService {

    private final WebDriverWait wait;

    public WaitService(WebDriver driver, Duration timeout) {
        this.wait = new WebDriverWait(driver, timeout);
    }

    public WebElement waitForVisibility(WebElement element) {
        try {
            return wait.until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException e) {
            throw new AssertionError("Element not visible after timeout: " + element, e);
        }
    }

    public List<WebElement> waitForVisibility(List<WebElement> elements) {
        try {
            return wait.until(ExpectedConditions.visibilityOfAllElements(elements));
        } catch (TimeoutException e) {
            throw new AssertionError("Elements not visible after timeout: " + elements, e);
        }
    }

    public WebElement waitForClickable(WebElement element) {
        try {
            return wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (TimeoutException e) {
            throw new AssertionError("Element not clickable after timeout: " + element, e);
        }
    }

    public boolean waitForTextPresent(By locator, String text) {
        try {
            return wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
        } catch (TimeoutException e) {
            throw new AssertionError("Text not visible after timeout: " + text, e);
        }
    }
}
