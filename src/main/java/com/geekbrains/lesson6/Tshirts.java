package com.geekbrains.lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class Tshirts extends Basic{
    public Tshirts(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "layered_id_attribute_group_1")
    private WebElement checkBoxS;
    @Step("Клик на чекбокс S")
    public Tshirts clickCheckBox_S() {
        checkBoxS.click();
        return this;
    }

    @FindBy(id = "layered_id_attribute_group_2")
    private WebElement checkBoxM;
    @Step("Клик на чекбокс M")
    public Tshirts clickCheckBox_M() {
        checkBoxM.click();
        return this;
    }

    @FindBy(id = "layered_id_attribute_group_3")
    private WebElement checkBoxL;
    @Step("Клик на чекбокс L")
    public Tshirts clickCheckBox_L() {
        checkBoxL.click();
        return this;
    }

    @FindBy(id = "layered_id_attribute_group_13")
    public WebElement checkBoxOrange;
    @Step("Клик на чекбокс Orange")
    public Tshirts clickCheckBoxOrange() {
        checkBoxOrange.click();
        return this;
    }

    @FindBy(id = "layered_id_attribute_group_14")
    private WebElement checkBoxBlue;
    @Step("Клик на чекбокс Blue")
    public Tshirts clickCheckBoxBlue() {
        checkBoxBlue.click();
        return this;
    }

    @FindBy(xpath = "//ul[@class='product_list grid row']/li")
    private List<WebElement> productList;

    @FindBy(xpath = "//a[@title='Add to cart']")
    private WebElement addToCartAfterHover;
    @Step("Поиск товара по заданному имени, наведение на карточку товара, нажатие на появившуюся кнопку 'Add to cart'")
    public Tshirts hoverAndClickProductByName(String name) {
        actions.moveToElement(productList.stream().filter(p -> p.getText().contains(name)).findFirst().get()).build().perform();
        wait.until(ExpectedConditions.visibilityOf(addToCartAfterHover));
        addToCartAfterHover.click();
        return this;
    }

    @FindBy(xpath = "//div[@class='shopping_cart']/a")
    private WebElement shoppingCart;
    @Step("Наведение на корзину")
    public Tshirts hoverShoppingCart(){
        actions.moveToElement(shoppingCart).build().perform();
        return this;
    }

    @FindBy(xpath = "//div[@class='cart-info']")
    public static List<WebElement> goodsInCart;
    @Step("Подсчет кол-ва товара в корзине")
    public static int countGoodsInCart(){

        int q = goodsInCart.size();
        return q;
    }

    @FindBy(xpath = "//span[@title='Continue shopping']")
    private WebElement buttonContinueShopping;
    @Step("Нажатие на кнопку 'Continue shopping'")
    public Tshirts clickContinueShopping(){
        wait.until(ExpectedConditions.visibilityOf(buttonContinueShopping));
        buttonContinueShopping.click();
        return this;
    }

}

