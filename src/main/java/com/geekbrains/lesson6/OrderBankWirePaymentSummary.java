package com.geekbrains.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderBankWirePaymentSummary extends Basic{
    public OrderBankWirePaymentSummary(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@class='button btn btn-default button-medium']")
    private WebElement buttonIConfirmMyOrder;
    public OrderConfirmation clickButtonIConfirmMyOrder(){
        buttonIConfirmMyOrder.click();
        return new OrderConfirmation(driver);
    }
}
