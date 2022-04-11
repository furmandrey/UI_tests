package com.geekbrains.lesson7;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.WebDriverListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.ByteArrayInputStream;
import java.time.Duration;

import static org.openqa.selenium.OutputType.BYTES;

public class CustomLogger implements WebDriverListener {


//    public void beforeFindElement(WebDriver driver, By locator) {
//        Allure.addAttachment("before each web element",
//                new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(BYTES)));
//    }

    public void beforeFindElement(WebDriver driver, By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.visibilityOfElementLocated(locator));

    }


    public void beforeQuit(WebDriver driver) {
        Allure.addAttachment("Скриншот страницы перед выходом",
                new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(BYTES)));
    }

}
