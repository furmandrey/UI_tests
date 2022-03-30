package com.geekbrains.lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AfishaTest {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actionProvider;
    private final static String AFISHA_URL = "https://www.afisha.ru/";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setDriver() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actionProvider = new Actions(driver);
        driver.manage().window().maximize();
        driver.get(AFISHA_URL);
    }

    @Test
    void findExactMovie()  {
        driver.findElement(By.xpath("//button[@class='_3jiFM _3fE7g NYM3K _2oJKT']")).click();
        List<WebElement> movieList =
                driver.findElements(By.xpath("//a[contains(@href, 'movie') and @data-test='LINK ITEM-NAME ITEM-URL']/h2"));

        movieList.stream().filter(f -> f.getText().equals("Брат")).findFirst().get().click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[.='Режиссер']/following-sibling::span/a")));
        Assertions.assertEquals(driver.findElement(By.xpath("//span[.='Режиссер']/following-sibling::span/a"))
                .getText(), "Алексей Балабанов");

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
