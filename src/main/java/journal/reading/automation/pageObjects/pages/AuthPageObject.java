package journal.reading.automation.pageObjects.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthPageObject {

    public AuthPageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "username")
    private WebElement inputLogin;

    @FindBy(id = "password")
    private WebElement inputPassword;

    @FindBy(className = "login-btn")
    private WebElement loginBtn;

    @Step("Input login")
    public void inputLoginText(String login) {
        inputLogin.sendKeys(login);
    }

    @Step("Input Password")
    public void inputPasswordText(String password) {
        inputPassword.sendKeys(password);
    }

    @Step("Login btn click")
    public void loginBtnClick() {
        loginBtn.click();
    }

    @Step("Full authorization")
    public void fullAuthorization(String login, String password) {
        inputLoginText(login);
        inputPasswordText(password);
        loginBtnClick();
    }
}
