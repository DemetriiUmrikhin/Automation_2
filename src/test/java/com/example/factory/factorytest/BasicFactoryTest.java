package com.example.factory.factorytest;

import com.example.factory.factorypages.LoginPage;
import com.example.factory.factorypages.MainFactoryPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasicFactoryTest {
    protected WebDriver driver;
    protected WebDriverWait wait;



    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup(); // Автоматически управляет драйвером
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Инициализация wait
    }

    public void navigateToUrl(String url) {
        driver.get(url);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

