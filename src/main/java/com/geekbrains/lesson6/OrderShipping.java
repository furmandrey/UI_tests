package com.geekbrains.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderShipping extends Basic {
    public OrderShipping(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "cgv")
    private WebElement checkBoxTermsOfService;

    public OrderShipping clickcheckBoxTermsOfService(){
        checkBoxTermsOfService.click();
        return this;
    }

    @FindBy(xpath = "//button[@class='button btn btn-default standard-checkout button-medium']")
    private WebElement buttonProceedToCheckout;

    public OrderPayment clickProceedToCheckout(){
        buttonProceedToCheckout.click();
        return new OrderPayment(driver);
    }

}
