package com.geekbrains.lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class WildberriesTest {
    WebDriver driver;
    Actions actionProvider;
    WebDriverWait webDriverWait;
    private final static String BASE_URL = "https://www.wildberries.ru/";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setDriver() {
        driver = new ChromeDriver();
        actionProvider = new Actions(driver);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get(BASE_URL);


    }

    @Test
    void isQtyOnStockShownTrue() {
        driver.findElement(By.xpath("//button[@aria-label='Навигация по сайту']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href=\"https://www" +
                ".wildberries.ru/catalog/elektronika\"]")));
        driver.findElement(By.xpath("//a[@href=\"https://www.wildberries.ru/catalog/elektronika\"]")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href=\"/catalog/elektronika" +
                "/smartfony-i-telefony\"]")));
        driver.findElement(By.xpath("//a[@href=\"/catalog/elektronika/smartfony-i-telefony\"]")).click();
        driver.findElement(By.xpath("//a[@href=\"/catalog/elektronika/smartfony-i-telefony/vse-smartfony\"]")).click();
        new WebDriverWait(driver, Duration.ofSeconds(60)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[.='Модель']//ancestor::div" +
                "[1]/following-sibling::div/div/input")));
        driver.findElement(By.xpath("//span[.='Модель']//ancestor::div[1]/following-sibling::div/div/input")).sendKeys("m52");

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(.,'M52')]")));

        driver.findElement(By.xpath("//label[contains(.,'M52')]")).click();
        webDriverWait.until(d -> driver.findElements(By.xpath("//span[@class='goods-name']")).size() < 100);
        List<WebElement> listOfGoods = driver.findElements(By.xpath("//span[@class='goods-name']"));

        int count = listOfGoods.size();

        Assertions.assertEquals(2, count);


    }

    @Test
    void isBannerOfBrandShownTrue()  {
        String name = "Mango";
        while (driver.findElements(By.xpath("//img[@class='j-lazy-img-brands']")).size() == 0) {
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 1500)");
            try {
                //new WebDriverWait(driver, Duration.ofSeconds(1))
                        webDriverWait.until(d -> d.findElements(By.xpath("//img[@class='j-lazy-img-brands']")).size() > 0);
            } catch (WebDriverException e) {
            }
        }
        List<WebElement> bannersList = driver.findElements(By.xpath("//img[@class='j-lazy-img-brands']"));
        bannersList.stream().filter(f -> f.getAttribute("alt").contains(name)).findFirst().get().click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='name']/h1")));

        Assertions.assertEquals(driver.findElement(By.xpath("//div[@id='name']/h1")).getText(), "Каталог " + name);
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
