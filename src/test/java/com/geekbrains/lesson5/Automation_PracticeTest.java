package com.geekbrains.lesson5;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Automation_PracticeTest {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actionProvider;
    private final static String AUTOMATIONPRACTICE_BASE_URL = "http://automationpractice.com";
    private final static String LOGON_NAME = "Andrey F";



    Date expiryDate = new GregorianCalendar(2022, 04, 11, 9, 01, 9).getTime();
    Cookie authCooki = new Cookie("PrestaShop-a30a9934ef476d11b6cc3c983616e364",
            "WocTdgeiJPnQnxuDUreaFMMc46YkDQ" + "%2BcJI%2BlL5ORuN5RSpmc5pFF9EiKEaCG%2F70wopHlQjN8lhRPHCjUBBwKxk" +
                    "%2F8beE23f384nH8A5gSrlMT9gl7KXbBviEOx2bAcUNQ4odM9myCHDl6CAT838s%2FyvRYuf5ozb%2BuQqa" +
                    "%2FuQA2fVp7" + "%2F0lGfhm8plWi2%2B1CLfnuavX%2BwkwKJhqIJhMRN2Yb4%2F13nrTa" +
                    "%2BRlsufjYh4OSesi6cZkfDFWONWiaMUqOyufWOfPoYGWmlG4KI0YwgTuJ0LQpi0nAwM6Eol9%2B0Wpf" +
                    "%2BsoBylTnKrj" + "%2FdJVQbrJdOJYEPopLLwOsQe3bFcgPzR4uh5OrwSd2QFNHG3trSGFC" +
                    "%2Ftu5WBdPMomTeDT0j15" +
                    "%2Bz4jDlbRpAOv9JpOA37b1uy1hOyYBnrajDXrnlmWOBCyqlN0%3D000307", ".automationpractice.com", "/",
            expiryDate);

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setDriver() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        actionProvider = new Actions(driver);
        driver.manage().window().maximize();
        driver.get(AUTOMATIONPRACTICE_BASE_URL);
        driver.manage().addCookie(authCooki);
        driver.navigate().refresh();
    }

    @Test
    void logInWithCookie() {
        Assertions.assertEquals(driver.findElement(By.xpath("//a[@title='View my customer account']/span")).getText()
                , LOGON_NAME);
    }

    @Test
    void placeOrder() {
        driver.findElement(By.xpath("//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li/a[" +
                ".='Dresses']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=" + "'block_content" +
                "']/ul/li//a[@title='Browse our different dresses to choose the perfect dress " + "for an " +
                "unforgettable evening!']")));
        driver.findElement(By.xpath("//div[@class='block_content']/ul/li//a[@title='Browse our different dresses " +
                "to choose the perfect dress for an unforgettable evening!']")).click();
        driver.findElement(By.id("layered_id_attribute_group_1")).click();//checkbox S
        driver.findElement(By.id("layered_id_attribute_group_7")).click();//checkbox Beige
        WebElement dressLink = driver.findElement(By.xpath("//ul[@class='product_list grid row']/li"));

        actionProvider.moveToElement(dressLink).build().perform();
        driver.findElement(By.xpath("//span[.='Add to cart']")).click();//add to cart
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class = 'btn btn-default " + "button button-medium']")));
        driver.findElement(By.xpath("//a[@class = 'btn btn-default button button-medium']")).click();
        WebElement buttonLink =
                driver.findElement(By.xpath("//a[@class = 'button btn btn-default standard-checkout " + "button" +
                        "-medium']"));
        actionProvider.moveToElement(buttonLink).click().build().perform();
        WebElement buttonLinkAdress = driver.findElement(By.xpath("//button[@class='button btn btn-default " +
                "button-medium']"));
        actionProvider.moveToElement(buttonLinkAdress).click().build().perform();
        driver.findElement(By.id("cgv")).click();
        WebElement buttonLinkShipping = driver.findElement(By.xpath("//button[@name='processCarrier']"));
        actionProvider.moveToElement(buttonLinkShipping).click().build().perform();

        WebElement btnLnkPayWire = driver.findElement(By.xpath("//a[@title='Pay by bank wire']"));
        actionProvider.moveToElement(btnLnkPayWire).click().build().perform();

        driver.findElement(By.xpath("//span[.='I confirm my order']")).click();
        Assertions.assertEquals(driver.findElement(By.xpath("//p[@class='cheque-indent']/strong")).getText(), "Your " +
                "order on My Store is complete.");

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
