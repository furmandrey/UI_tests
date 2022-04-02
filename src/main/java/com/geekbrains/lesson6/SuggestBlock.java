package com.geekbrains.lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SuggestBlock extends Basic {
    public SuggestBlock(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li/a")
    private List<WebElement> suggestBlockTitles;

    public void hoverSuggestBlockByName(String nameOfBlock) {
        actions.moveToElement(suggestBlockTitles.stream().filter(s -> s.getText().contains(nameOfBlock))
                .findFirst().get()).build().perform();
    }

    public void hoverAndClickSuggestBlockByName(String nameOfBlock) {
        actions.moveToElement(suggestBlockTitles.stream().filter(s -> s.getAttribute("title").contains(nameOfBlock))
                .findFirst().get()).click().build().perform();
    }

    public void clickSuggestBlockByName(String nameOfBlock) {
        suggestBlockTitles.stream().filter(s -> s.getAttribute("title").contains(nameOfBlock))
                .findFirst().get().click();
    }


}
