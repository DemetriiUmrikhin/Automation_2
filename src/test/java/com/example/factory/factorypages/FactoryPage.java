package com.example.factory.factorypages;

import org.openqa.selenium.WebDriver;

public abstract class FactoryPage {
    protected WebDriver driver;

    public FactoryPage(WebDriver driver) {
        this.driver = driver;
    }

    // Общие методы для всех страниц фабрики
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

}
