package com.geekbrains.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EveningDresses extends Basic{
    public EveningDresses(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "")
    private List<WebElement> sizeBox;
    
}
