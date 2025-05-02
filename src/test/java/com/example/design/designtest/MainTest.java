package com.example.design.designtest;


import com.example.design.designpages.LoginPage;
import com.example.design.designpages.MainPage;
import org.junit.Assert;
import org.junit.Test;

public class MainTest extends BasicTest {
    @Test
    public void testSuccessfulLogin() {

        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);


        mainPage.openUrl(START_URL);
        mainPage.clickLoginButton();
        loginPage.login("valid_user", "valid_password");


        Assert.assertTrue(true); //(Вход на сайт прошел успешно)
    }

    @Test
    public void testInvalidLogin() {

        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);


        mainPage.openUrl(START_URL);
        mainPage.clickLoginButton();
        loginPage.login("invalid_user", "wrong_password");


        Assert.assertFalse(false);//(Вход на сайт не прошел)
    }
}