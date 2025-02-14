package com.example;





import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.*;

import java.time.Duration;

import static org.junit.Assert.*;

public class LoginSteps {
    private WebDriver driver;
    private WebDriverWait wait;

    // Локаторы
    private static final By USERNAME_FIELD = By.id("username");
    private static final By PASSWORD_FIELD = By.id("password");
    private static final By LOGIN_BUTTON = By.id("login-submit");
    private static final By ERROR_MESSAGE = By.cssSelector(".errors li");


    @Given("the user is on the login page")
    public void user_is_on_login_page() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win32\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, 10);// ожидание чтобы всё загрузилось (на всякий)
        driver.get("https://secure1.inmotionhosting.com/index/login");
    }

    @When("the user clicks on the 'I don't remember my password' link")
    public void click_forgot_password() {
        WebElement forgotLink = wait.until(ExpectedConditions
                .elementToBeClickable(By.cssSelector("a.forgot-password")));
        forgotLink.click();
    }

    @Then("the user should be redirected to the password recovery page")
    public void verify_password_recovery_redirect() {
        wait.until(ExpectedConditions.urlContains("/index/forgot"));
        assertTrue(driver.getCurrentUrl().contains("/index/forgot"));
    }

    @Then("the user should see the text {string}")
    public void verify_page_content(String expectedText) {
        WebElement content = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("h4")));
        assertEquals(expectedText, content.getText());
    }

    @When("the user enters {string} in the {string} field")
    public void enter_text_in_field(String text, String fieldId) {
        WebElement field = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.id(fieldId)));
        field.clear();
        field.sendKeys(text);
    }

    @When("the user clicks the {string} button")
    public void click_button(String buttonText) {
        WebElement button = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//button[contains(text(),'" + buttonText + "')]")));
        button.click();
    }

    @Then("the user should see error message {string}")
    public void verify_error_message(String expectedError) {
        WebElement error = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector(".errors li")));
        assertEquals(expectedError, error.getText());
    }


    //тесты для успешного входа
 /*
    @Given("the user is on the login page")
    public void user_is_on_login_page2() {
        System.setProperty("webdriver.chrome.driver", "C:\chromedriver-win32\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, 10);
        driver.get("https://secure1.inmotionhosting.com/index/login");
    }

    @When("the user enters {string} in the {string} field")
    public void enter_text_in_field2(String text, String field) {
        By locator = field.equals("username") ? USERNAME_FIELD : PASSWORD_FIELD;
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(text);
    }

    @When("the user clicks the {string} button")
    public void click_login_button(String buttonText) {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(LOGIN_BUTTON));
        button.click();
    }

    @Then("the user should see error message {string}")
    public void verify_error_message2(String expectedMessage) {
        WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(ERROR_MESSAGE));
        assertEquals("Ожидаемое сообщение об ошибке не совпадает",
                expectedMessage,
                error.getText());
    }*/

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

