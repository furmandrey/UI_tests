package com.geekbrains.lesson6;

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

    public Tshirts clickCheckBox_S() {
        checkBoxS.click();
        return this;
    }

    @FindBy(id = "layered_id_attribute_group_2")
    private WebElement checkBoxM;

    public Tshirts clickCheckBox_M() {
        checkBoxM.click();
        return this;
    }

    @FindBy(id = "layered_id_attribute_group_3")
    private WebElement checkBoxL;

    public Tshirts clickCheckBox_L() {
        checkBoxL.click();
        return this;
    }

    @FindBy(id = "layered_id_attribute_group_13")
    public WebElement checkBoxOrange;

    public Tshirts clickCheckBoxOrange() {
        checkBoxOrange.click();
        return this;
    }

    @FindBy(id = "layered_id_attribute_group_14")
    private WebElement checkBoxBlue;

    public Tshirts clickCheckBoxBlue() {
        checkBoxBlue.click();
        return this;
    }

    @FindBy(xpath = "//ul[@class='product_list grid row']/li")
    private List<WebElement> productList;

    @FindBy(xpath = "//a[@title='Add to cart']")
    private WebElement addToCartAfterHover;

    public Tshirts hoverAndClickProductByName(String name) {
        actions.moveToElement(productList.stream().filter(p -> p.getText().contains(name)).findFirst().get()).build().perform();
        wait.until(ExpectedConditions.visibilityOf(addToCartAfterHover));
        addToCartAfterHover.click();
        return this;
    }

    @FindBy(xpath = "//div[@class='shopping_cart']/a")
    private WebElement shoppingCart;

    public Tshirts hoverShoppingCart(){
        actions.moveToElement(shoppingCart).build().perform();
        return this;
    }

    @FindBy(xpath = "//div[@class='cart-info']")
    public static List<WebElement> goodsInCart;

    public static int countGoodsInCart(){

        int q = goodsInCart.size();
        return q;
    }

    @FindBy(xpath = "//span[@title='Continue shopping']")
    private WebElement buttonContinueShopping;

    public Tshirts clickContinueShopping(){
        wait.until(ExpectedConditions.visibilityOf(buttonContinueShopping));
        buttonContinueShopping.click();
        return this;
    }

}

