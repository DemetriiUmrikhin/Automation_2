package com.example.factory.factorypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginPage extends FactoryPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver);
        this.driver = driver;
        this.wait = wait;
    }

    public void enterUsername(String username) {
        driver.findElement(By.id("username")).sendKeys(username); //!
    }

    public void enterPassword(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(By.id("login-submit")).click();
    }

    public void clickForgotPasswordLink() {
        WebElement forgotLink = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.forgot-password")));
        forgotLink.click();
    }

    public void verifyPageContent(String expectedText) {
        WebElement content = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2")));
        assertEquals(expectedText, content.getText());
    }

    public void verifyErrorMessage(String expectedErrorMessage) {
        WebElement errorMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".errors li")));
        assertEquals(expectedErrorMessage, errorMessageElement.getText());
    }

    public void navigateToLoginPage() {
        driver.get("https://secure1.inmotionhosting.com/index/login");
    }
}
