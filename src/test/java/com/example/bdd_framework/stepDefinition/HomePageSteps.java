package com.example.bdd_framework.stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.example.factory.factorypages.MainFactoryPage;
import com.example.factory.factorytest.BasicFactoryTest;

public class HomePageSteps extends BasicFactoryTest {
    private MainFactoryPage mainPage;

    @Given("I navigate to the InMotion Hosting homepage")
    public void iNavigateToTheInMotionHostingHomepage() {
        setUp(); // Инициализация WebDriver из BasicFactoryTest
        navigateToUrl("https://www.inmotionhosting.com");//!!
        mainPage = new MainFactoryPage(driver, wait);
    }

    @When("the page is fully loaded")
    public void thePageIsFullyLoaded() {
        mainPage.verifyPageIsFullyLoaded();
    }

    @Then("I should see the link with id {string} and title {string}")
    public void iShouldSeeTheLinkWithIdAndTitle(String id, String title) {
        mainPage.verifyLinkWithIdAndTitle(id, title);
    }

    @Then("I click the Web Hosting link")
    public void iClickTheWebHostingLink() {
        mainPage.clickWebHostingLink();
    }

    @Then("I should be redirected to {string}")
    public void iShouldBeRedirectedTo(String urlFragment) {
        mainPage.verifyRedirection(urlFragment);
        tearDown(); // Закрытие WebDriver из BasicFactoryTest
    }

    @Then("I click the Support Center link")
    public void iClickTheSupportCenterLink() {
        mainPage.clickSupportCenterLink();
    }
}
