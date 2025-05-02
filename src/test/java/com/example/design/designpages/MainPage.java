package com.example.design.designpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends Page {
    @FindBy(css = "a.btn-login[title='AMP Login']")
    private WebElement loginLink;


    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void clickLoginButton() {
        loginLink.click();
    }
}