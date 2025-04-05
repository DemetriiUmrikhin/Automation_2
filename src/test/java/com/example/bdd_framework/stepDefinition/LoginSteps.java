package com.example.bdd_framework.stepDefinition;

import com.example.factory.factorypages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.example.factory.factorypages.MainFactoryPage;
import com.example.factory.factorytest.BasicFactoryTest;

public class LoginSteps extends BasicFactoryTest {
    private MainFactoryPage mainPage;
    private LoginPage loginPage;

    @Given("the user is on the login page")
    public void userIsOnLoginPage() {
        setUp(); // Инициализация WebDriver из BasicFactoryTest
        mainPage = new MainFactoryPage(driver, wait);
        loginPage = new LoginPage(driver, wait);
        mainPage.navigateToLoginPage();
    }

    @When("the user clicks on the 'I don't remember my password' link")
    public void clickForgotPassword() {
        loginPage.clickForgotPasswordLink();
    }

    @Then("the user should be redirected to the password recovery page")
    public void verifyPasswordRecoveryRedirect() {
        mainPage.verifyRedirection("/index/forgot");
    }

    @Then("the user should see the text {string}")
    public void verifyPageContent(String expectedText) {
        loginPage.verifyPageContent(expectedText);
        tearDown(); // Закрытие WebDriver из BasicFactoryTest
    }

    @When("the user enters {string} in the {string} field")
    public void enterDataInField(String data, String fieldName) {
        fieldName.equalsIgnoreCase("username");
            loginPage.enterUsername(data);
//        } else if (fieldName.equalsIgnoreCase("password")) {
//            loginPage.enterPassword(data);

    }

    @When("the user clicks the {string} button")
    public void clickButton(String buttonName) {
        if (buttonName.equalsIgnoreCase("Log In")) {
            loginPage.clickLoginButton();
        }
    }

    @Then("the user should see error message {string}")
    public void verifyErrorMessage(String expectedErrorMessage) {
        loginPage.verifyErrorMessage(expectedErrorMessage);
        tearDown(); // Закрытие WebDriver из BasicFactoryTest
    }
}

