package com.example.factory.factorypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginPage extends FactoryPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Элементы страницы
    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-submit")
    private WebElement loginButton;

    @FindBy(css = "a.forgot-password")
    private WebElement forgotPasswordLink;

    @FindBy(css = "h2")
    private WebElement pageHeader;

    @FindBy(css = ".errors li")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver);
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    // Основные действия
    public LoginPage enterUsername(String username) {
        usernameField.sendKeys(username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public LoginPage clickLoginButton() {
        loginButton.click();
        return new LoginPage(driver, wait);
    }

    public LoginPage clickForgotPasswordLink() {
        wait.until(ExpectedConditions.elementToBeClickable(forgotPasswordLink)).click();
        return new LoginPage(driver, wait);
    }

    // Валидации
    public LoginPage verifyPageContent(String expectedText) {
        wait.until(ExpectedConditions.visibilityOf(pageHeader));
        assertEquals(expectedText, pageHeader.getText());
        return this;
    }

    public LoginPage verifyErrorMessage(String expectedErrorMessage) {
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        assertEquals(expectedErrorMessage, errorMessage.getText());
        return this;
    }

}
