package com.geekbrains.lesson6;


import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SuggestBlock extends Basic {
    public SuggestBlock(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li/a")
    private List<WebElement> suggestBlockTitles;
    @Step("Наведение на раздел в меню навигации по заданному названию")
    public SuggestBlock hoverSuggestBlockByName(String nameOfBlock) {
        actions.moveToElement(suggestBlockTitles.stream().filter(s -> s.getAttribute("title")//Вопрос 2
                .contains(nameOfBlock)).findFirst().get()).build().perform();
        return this;
    }

    @FindBy(xpath = "//li[@class='sfHover']/ul/li/a[contains(., 'Evening Dresses')]")
    private WebElement eveningDresses;
    @Step("Клик на Evening Dresses (Кнопка появляется после нвведения на меню Dresses в меню навигации)")
    public EveningDresses clickEveningDressesInsideMenu() {
        wait.until(ExpectedConditions.visibilityOf(eveningDresses));
        eveningDresses.click();
        return new EveningDresses(driver);
    }

    @Step("Выбираем блок по имени и кликаем")
    public void clickSuggestBlockByName(String nameOfBlock) {
        suggestBlockTitles.stream().filter(s -> s.getAttribute("title").contains(nameOfBlock))
                .findFirst().get().click();
    }


}
