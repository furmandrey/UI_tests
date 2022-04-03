package com.geekbrains.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EveningDresses extends Basic {
    public EveningDresses(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "layered_id_attribute_group_1")
    private WebElement checkBoxS;

    public EveningDresses clickCheckBox_S() {
        checkBoxS.click();
        return this;
    }

    @FindBy(id = "layered_id_attribute_group_2")
    private WebElement checkBoxM;

    public EveningDresses clickCheckBox_M() {
        checkBoxM.click();
        return this;
    }

    @FindBy(id = "layered_id_attribute_group_3")
    private WebElement checkBoxL;

    public EveningDresses clickCheckBox_L() {
        checkBoxL.click();
        return this;
    }

    @FindBy(id = "layered_id_attribute_group_7")
    public WebElement checkBoxBeige;

    public EveningDresses clickCheckBoxBeige() {
        checkBoxBeige.click();
        return this;
    }

    @FindBy(id = "layered_id_attribute_group_24")
    private WebElement checkBoxPink;

    public EveningDresses clickCheckBoxPink() {
        checkBoxPink.click();
        return this;
    }

    @FindBy(xpath = "//ul[@class='product_list grid row']/li")
    private List<WebElement> productList;

    @FindBy(xpath = "//a[@title='Add to cart']")
    private WebElement addToCartAfterHover;

    public EveningDresses hoverAndClickProductByName(String name) {
        actions.moveToElement(productList.stream().filter(p -> p.getText().contains(name)).findFirst().get()).build().perform();
        addToCartAfterHover.click();
        return this;
    }


}
