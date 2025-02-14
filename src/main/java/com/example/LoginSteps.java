package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import io.cucumber.java.en.*;

public class LoginSteps {
    WebDriver driver;

    @Given("the user is on the login page")
    public void user_is_on_login_page() {
        driver = new ChromeDriver();
        driver.get("http://наша страница с формой для входа.com");
    }

    @When("the user enters a valid username in the {string} field")
    public void user_enters_valid_username(String field) {
        driver.findElement(By.id(field)).sendKeys("valid_username");
    }

    @When("the user enters a valid password in the {string} field")
    public void user_enters_valid_password(String field) {
        driver.findElement(By.id(field)).sendKeys("valid_password");
    }

    @When("the user checks the 'Verify you are human' checkbox")
    public void user_checks_verify_human_checkbox() {
        driver.findElement(By.id("verify_human_checkbox")).click();
    }

    @When("the user clicks the {string} button")
    public void user_clicks_login_button(String button) {
        driver.findElement(By.id(button)).click();
    }

    @Then("the user should be successfully redirected to the main page")
    public void user_redirected_to_main_page() {
        assert driver.getCurrentUrl().equals("http://наша страница с формой для входа.com"); //только какую брать??
    }

    @Then("the user should see a message confirming the login")
    public void user_sees_confirmation_message() {
        String message = driver.findElement(By.id("confirmation_message")).getText();
        assert message.equals("Login successful");
    }

    @When("the user enters {string} in the {string} field")
    public void user_enters_invalid_email(String invalidEmail, String field) {
        driver.findElement(By.id(field)).sendKeys(invalidEmail);
    }

    @Then("the user should see an error message indicating an invalid email format")
    public void user_sees_error_message_invalid_email() {
        String errorMessage = driver.findElement(By.id("error_message")).getText();
        assert errorMessage.equals("Invalid email format");
    }
}
