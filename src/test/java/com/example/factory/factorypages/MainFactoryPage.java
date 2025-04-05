package com.example.factory.factorypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MainFactoryPage extends FactoryPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public MainFactoryPage(WebDriver driver, WebDriverWait wait) {
        super(driver);
        this.driver = driver;
        this.wait = wait;
    }

    public void clickWebHostingLink() {
        driver.findElement(By.id("webHostingDropDown")).click();
    }

    public void clickSupportCenterLink() {
        driver.findElement(By.id("supportDropDown")).click();
    }

    public void verifyPageIsFullyLoaded() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='InMotion Hosting Logo']")));
    }

    public void verifyLinkWithIdAndTitle(String id, String title) {
        WebElement link = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
        assertTrue(link.isDisplayed());
        assertEquals(title, link.getAttribute("title"));
    }

    public void verifyRedirection(String urlFragment) {
        wait.until(ExpectedConditions.urlContains(urlFragment));
        assertTrue(driver.getCurrentUrl().contains(urlFragment));
    }
    public void clickForgotPasswordLink() {
        WebElement forgotLink = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.forgot-password")));
        forgotLink.click();
    }

    public void verifyPageContent(String expectedText) {
        WebElement content = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2")));
        assertEquals(expectedText, content.getText());
    }

    public void navigateToLoginPage() {
        driver.get("https://secure1.inmotionhosting.com/index/login");
    }
}

