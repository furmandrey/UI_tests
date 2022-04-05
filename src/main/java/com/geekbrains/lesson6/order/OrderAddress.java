package com.geekbrains.lesson6.order;

import com.geekbrains.lesson6.Basic;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OrderAddress extends Basic {

    public OrderAddress(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@class = 'button btn btn-default button-medium']")
    private WebElement buttonProceedToCheckout;

    public OrderShipping clickProceedToCheckout(){
        actions.moveToElement(buttonProceedToCheckout).build().perform();
        wait.until(ExpectedConditions.visibilityOf(buttonProceedToCheckout));
        buttonProceedToCheckout.click();
        return new OrderShipping(driver);
    }
}
