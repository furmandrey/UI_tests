package com.geekbrains.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class ResizeElement {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--headless");
        WebDriver driver = new ChromeDriver();
        Actions actionProvider = new Actions(driver);
        driver.manage().window().maximize();
        //driver.manage().window().setSize(new Dimension(300, 700));

        driver.get("https://demoqa.com/automation-practice-form");

        ((JavascriptExecutor) driver).executeScript("document.getElementById('currentAddress').rows='1'");

    }
}
