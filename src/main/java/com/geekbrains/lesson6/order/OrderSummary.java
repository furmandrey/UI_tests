package com.geekbrains.lesson6.order;

import com.geekbrains.lesson6.Basic;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OrderSummary extends Basic {
    public OrderSummary(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@class = 'button btn btn-default standard-checkout button-medium']")
    private WebElement buttonProceedToCheckout;
    @Step("Нажатие на кнопку 'Proceed to checkout'")
    public OrderAddress clickProceedToCheckout(){
        actions.moveToElement(buttonProceedToCheckout).build().perform();
        wait.until(ExpectedConditions.visibilityOf(buttonProceedToCheckout));
        buttonProceedToCheckout.click();
        return new OrderAddress(driver);
    }
}
