package com.example.factory.factorytest;

import com.example.factory.factorypages.LoginPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import com.example.factory.factorypages.MainFactoryPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class MainFactoryTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win32\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize(); // Открыть браузер на весь экран
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void testWebHostingLink() {
        driver.get("https://www.inmotionhosting.com"); //скрыть!!!
        MainFactoryPage mainPage = new MainFactoryPage(driver, wait); //вынести в переменную
        mainPage.clickWebHostingLink();

        // Проверка, что URL страницы изменился на ожидаемый
        mainPage.verifyRedirection("/web-hosting");
    }

    @Test
    public void testSupportCenterLink() {
        driver.get("https://www.inmotionhosting.com");
        MainFactoryPage mainPage = new MainFactoryPage(driver, wait);
        mainPage.clickSupportCenterLink();

        // Проверка, что URL страницы изменился на ожидаемый
        mainPage.verifyRedirection("/support/");
    }

    @Test
    public void testLogin() {
        driver.get("https://secure1.inmotionhosting.com/index/login"); //с главной страницы (с одной точки)
        LoginPage loginPage = new LoginPage(driver, wait);
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

