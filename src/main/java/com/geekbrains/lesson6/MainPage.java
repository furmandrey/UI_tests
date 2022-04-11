package com.geekbrains.lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MainPage extends Basic {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@title='View my customer account']/span")
    public static WebElement logoNameField;

    @Step("Считываем поле log name")
    public static String logName() {
        return logoNameField.getText();
    }


}
