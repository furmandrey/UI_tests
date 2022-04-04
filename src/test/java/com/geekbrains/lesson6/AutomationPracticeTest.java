package com.geekbrains.lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Date;
import java.util.GregorianCalendar;


import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AutomationPracticeTest {
    WebDriver driver;
    WebDriverWait wait;
    Actions actionProvider;
    private final static String AUTOMATIONPRACTICE_BASE_URL = "http://automationpractice.com";
    private final static String LOGO_NAME = "Andrey F";


    Date expiryDate = new GregorianCalendar(2022, 04, 11, 9, 01, 9).getTime();
    Cookie authCooki = new Cookie("PrestaShop-a30a9934ef476d11b6cc3c983616e364", "WocTdgeiJPnQnxuDUreaFMMc46YkDQ" +
            "%2BcJI%2BlL5ORuN5RSpmc5pFF9EiKEaCG%2F70wopHlQjN8lhRPHCjUBBwKxk" +
            "%2F8beE23f384nH8A5gSrlMT9gl7KXbBviEOx2bAcUNQ4odM9myCHDl6CAT838s%2FyvRYuf5ozb%2BuQqa" + "%2FuQA2fVp7" +
            "%2F0lGfhm8plWi2%2B1CLfnuavX%2BwkwKJhqIJhMRN2Yb4%2F13nrTa" +
            "%2BRlsufjYh4OSesi6cZkfDFWONWiaMUqOyufWOfPoYGWmlG4KI0YwgTuJ0LQpi0nAwM6Eol9%2B0Wpf" + "%2BsoBylTnKrj" +
            "%2FdJVQbrJdOJYEPopLLwOsQe3bFcgPzR4uh5OrwSd2QFNHG3trSGFC" + "%2Ftu5WBdPMomTeDT0j15" +
            "%2Bz4jDlbRpAOv9JpOA37b1uy1hOyYBnrajDXrnlmWOBCyqlN0%3D000307", ".automationpractice.com", "/", expiryDate);

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setDriver() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        actionProvider = new Actions(driver);
        driver.manage().window().maximize();
        driver.get(AUTOMATIONPRACTICE_BASE_URL);
        driver.manage().addCookie(authCooki);
        driver.navigate().refresh();

    }

    @Test
    void logInWithCookie() {
        new MainPage(driver);
        Assertions.assertEquals(MainPage.logoName(), LOGO_NAME);
        //Assertions.assertEquals(MainPage.logoNameField.getText(), LOGO_NAME);//Вопрос 1
    }

    @Test
    void placeOrder() {
        new SuggestBlock(driver).clickSuggestBlockByName("Dresses");
        new Dresses(driver).clickEveningDressesInDressesBlock()
                .clickCheckBox_S()
                .clickCheckBox_L()
                .clickCheckBox_M()
                .clickCheckBoxBeige()
                .clickCheckBoxPink()
                .hoverAndClickProductByName("Printed Dress")
                .clickProceedToCheckout()
                .clickProceedToCheckout()
                .clickProceedToCheckout()
                .clickcheckBoxTermsOfService()
                .clickProceedToCheckout()
                .clickButtonPayByBankWire()
                .clickButtonIConfirmMyOrder();
        Assertions.assertEquals(driver.findElement(By.xpath("//p[@class='cheque-indent']/strong")).getText(), "Your " +
                "order on My Store is complete.");


    }

    @Test
    void checkAddToCart(){
        new SuggestBlock(driver).clickSuggestBlockByName("Dresses");
        new Dresses(driver).clickEveningDressesInDressesBlock()
                .clickCheckBox_S()
                .clickCheckBoxBeige()
                .hoverAndClickProductByName("Printed Dress");

        wait.until(ExpectedConditions.visibilityOf(EveningDresses.confirmationText));

        Assertions.assertAll(
                () -> assertTrue(EveningDresses.confirmationText
                .getText()
                .contains("Product successfully added to your shopping cart")),
                () -> assertNotEquals(driver.findElement(By.xpath("//i[@class='icon-ok']")), null)
        );
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


