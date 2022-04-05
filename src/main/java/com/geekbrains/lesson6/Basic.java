package com.geekbrains.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Basic {

    public WebDriver driver;
    public WebDriverWait wait;
    public Actions actions;

    public Basic(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }
}
