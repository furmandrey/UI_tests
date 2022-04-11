package com.geekbrains.lesson6.order;

import com.geekbrains.lesson6.Basic;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderShipping extends Basic {
    public OrderShipping(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "cgv")
    private WebElement checkBoxTermsOfService;
    @Step("Нажатие на кнопку 'Terms of service'")
    public OrderShipping clickCheckBoxTermsOfService(){
        checkBoxTermsOfService.click();
        return this;
    }

    @FindBy(xpath = "//button[@class='button btn btn-default standard-checkout button-medium']")
    private WebElement buttonProceedToCheckout;
    @Step("Нажатие на кнопку 'Proceed to checkout'")
    public OrderPayment clickProceedToCheckout(){
        buttonProceedToCheckout.click();
        return new OrderPayment(driver);
    }

}
