package com.example.design.designpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends Page {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    // Пример метода для поиска элемента по названию ссылки
    public void clickWebHostingLink() {
        driver.findElement(By.id("webHostingDropDown")).click();
    }

}
