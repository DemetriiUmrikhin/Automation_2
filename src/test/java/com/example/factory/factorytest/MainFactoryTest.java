package com.example.factory.factorytest;

import com.example.factory.factorypages.LoginPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.example.factory.factorypages.MainFactoryPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

import static com.example.framework.core.lib.InmotionPageURLs.START_URL;

public class MainFactoryTest extends BasicFactoryTest {
    private MainFactoryPage mainPage;
    private LoginPage loginPage;

    @Before
    public void initPages() {
        mainPage = new MainFactoryPage(driver); // Инициализация MainFactoryPage
        loginPage = new LoginPage(driver, wait);      // Инициализация LoginPage
    }

    @Test
    public void testWebHostingLink() {
        driver.get(START_URL);
        mainPage.clickWebHostingLink();

        // Проверка, что URL страницы изменился на ожидаемый
        mainPage.verifyRedirection("/web-hosting");
    }

    @Test
    public void testSupportCenterLink() {
        driver.get(START_URL);
        mainPage.clickSupportCenterLink();
        // Проверка, что URL страницы изменился на ожидаемый
        mainPage.verifyRedirection("/support/");
    }

    @Test
    public void testLogin() {
        driver.get(START_URL);
        mainPage.clickOnLoginButton();
        loginPage.enterUsername("username");
        loginPage.enterPassword("password");
        loginPage.clickLoginButton();
        //проверки, если необходимо
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

