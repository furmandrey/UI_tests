package com.geekbrains.lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class WildberriesTest {
    WebDriver driver;
    Actions actionProvider;
    WebDriverWait webDriverWait;
    private final static String BASE_URL = "https://www.wildberries.ru/catalog/elektronika/smartfony-i-telefony/vse-smartfony";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setDriver() {
        driver = new ChromeDriver();
        actionProvider = new Actions(driver);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get(BASE_URL);


    }

    @Test
    void submitTheForm(){
        driver.findElement(By.xpath("//button[@aria-label='Навигация по сайту']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href=\"https://www.wildberries.ru/catalog/elektronika\"]")));
        driver.findElement(By.xpath("//a[@href=\"https://www.wildberries.ru/catalog/elektronika\"]")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href=\"/catalog/elektronika/smartfony-i-telefony\"]")));
        driver.findElement(By.xpath("//a[@href=\"/catalog/elektronika/smartfony-i-telefony\"]")).click();
        driver.findElement(By.xpath("//a[@href=\"/catalog/elektronika/smartfony-i-telefony/vse-smartfony\"]")).click();
        driver.findElement(By.xpath("//span[.='Модель']//ancestor::div[1]/following-sibling::div/div/input")).sendKeys("m52");

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(.,'M52')]")));

        driver.findElement(By.xpath("//label[contains(.,'M52')]")).click();
        List<WebElement> listOfGoods = driver.findElements(By.xpath("//span[@class='goods-name']"));
        int count = listOfGoods.size();
        System.out.println(count);


    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @AfterAll
    static void end() {
        System.out.println("I'l be back!");
    }

}
