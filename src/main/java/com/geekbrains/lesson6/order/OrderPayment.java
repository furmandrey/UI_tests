package com.geekbrains.lesson6.order;

import com.geekbrains.lesson6.Basic;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderPayment extends Basic {
    public OrderPayment(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@class='bankwire']")
    private WebElement buttonPayByBankWire;

    public OrderBankWirePaymentSummary clickButtonPayByBankWire (){
        buttonPayByBankWire.click();
        return new OrderBankWirePaymentSummary(driver);
    }
}
