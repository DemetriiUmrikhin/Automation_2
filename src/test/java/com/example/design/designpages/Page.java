package com.example.design.designpages;

import org.openqa.selenium.WebDriver;

public abstract class Page {
    protected WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
    }

    // Общие методы для всех страниц
    public String getTitle() {
        return driver.getTitle();
    }

}
