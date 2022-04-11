package com.geekbrains.lesson6;

import com.geekbrains.lesson6.order.OrderSummary;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class EveningDresses extends Basic {
    public EveningDresses(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "layered_id_attribute_group_1")
    private WebElement checkBoxS;
    @Step("Клик на чекбокс S")
    public EveningDresses clickCheckBox_S() {
        checkBoxS.click();
        return this;
    }

    @FindBy(id = "layered_id_attribute_group_2")
    private WebElement checkBoxM;
    @Step("Клик на чекбокс M")
    public EveningDresses clickCheckBox_M() {
        checkBoxM.click();
        return this;
    }

    @FindBy(id = "layered_id_attribute_group_3")
    private WebElement checkBoxL;
    @Step("Клик на чекбокс L")
    public EveningDresses clickCheckBox_L() {
        checkBoxL.click();
        return this;
    }

    @FindBy(id = "layered_id_attribute_group_7")
    public WebElement checkBoxBeige;
    @Step("Клик на чекбокс Beige")
    public EveningDresses clickCheckBoxBeige() {
        checkBoxBeige.click();
        return this;
    }

    @FindBy(id = "layered_id_attribute_group_24")
    private WebElement checkBoxPink;
    @Step("Клик на чекбокс Pink")
    public EveningDresses clickCheckBoxPink() {
        checkBoxPink.click();
        return this;
    }

    @FindBy(xpath = "//ul[@class='product_list grid row']/li")
    private List<WebElement> productList;

    @FindBy(xpath = "//a[@title='Add to cart']")
    private WebElement addToCartAfterHover;
    @Step("Поиск товара по заданному имени, наведение на карточку товара, нажатие на появившуюся кнопку 'Add to cart'")
    public EveningDresses hoverAndClickProductByName(String name) {
        actions.moveToElement(productList.stream().filter(p -> p.getText().contains(name)).findFirst().get()).build().perform();
        addToCartAfterHover.click();
        return this;
    }

    @FindBy(xpath = "//span[contains(., 'Proceed to checkout')]")
    private WebElement buttonProceedToCheckout;
    @Step("Нажатие на кнопку 'Proceed to checkout'")
    public OrderSummary clickProceedToCheckout() {
        wait.until(ExpectedConditions.visibilityOf(buttonProceedToCheckout));
        buttonProceedToCheckout.click();
        return new OrderSummary(driver);
    }

    @FindBy(xpath = "//i[@class='icon-ok']/ancestor::h2")
    public static WebElement confirmationText;

    @FindBy(xpath = "//span[@title='Continue shopping']")
    private WebElement buttonContinueShopping;
    @Step("Нажатие на кнопку 'Continue shopping'")
    public EveningDresses clickButtonContinueShopping() {
        wait.until(ExpectedConditions.visibilityOf(buttonContinueShopping));
        buttonContinueShopping.click();
        return this;
    }


}
