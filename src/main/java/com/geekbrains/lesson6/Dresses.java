package com.geekbrains.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Dresses extends Basic{
    public Dresses(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='block_content']/ul/li/a[contains(., 'Casual Dresses')]")
    private WebElement casualDressesInDressesBlock;

    @FindBy(xpath = "//div[@class='block_content']/ul/li/a[contains(., 'Evening Dresses')]")
    private  WebElement eveningDressesInDressesBlock;


    public EveningDresses clickEveningDressesInDressesBlock(){
        eveningDressesInDressesBlock.click();
        return new EveningDresses(driver);
    }


    @FindBy(id = "layered_category_9")
    private WebElement checkBoxCasualDresses;

    @FindBy(id = "layered_category_10")
    private WebElement checkBoxEveningDresses;

    @FindBy(id = "layered_category_11")
    private WebElement checkBoxSummerDresses;



}
