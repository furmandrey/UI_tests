package com.geekbrains.lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


import java.time.Duration;

public class Demoqa2Test {
    WebDriver driver;
    Actions actionProvider;
    private final static String DEMOQA_BASE_URL = "https://demoqa.com/automation-practice-form";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setDriver() {
        driver = new ChromeDriver();
        actionProvider = new Actions(driver);
        driver.manage().window().maximize();
        driver.get(DEMOQA_BASE_URL);
    }

    @Test
    void submitTheForm(){
        String firstName = "Jon";
        String lastName = "Smith";
        String userEmail = "name@example.com";
        driver.findElement(By.id("firstName")).sendKeys(firstName);
        driver.findElement(By.id("lastName")).sendKeys(lastName);
        driver.findElement(By.id("userEmail")).sendKeys(userEmail);
        driver.findElement(By.xpath("//label[@for='gender-radio-1']")).click();
        driver.findElement(By.id("userNumber")).sendKeys("9101234567");
        driver.findElement(By.id("dateOfBirthInput")).click();
        driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']")).click();

        Select yearSelect = new Select(driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']")));
        yearSelect.selectByValue("2002");

        driver.findElement(By.xpath("//div[@class='react-datepicker__day react-datepicker__day--008']")).click();

        driver.findElement(By.id("subjectsInput")).sendKeys("123");
        WebElement checkbox = driver.findElement(By.id("uploadPicture"));
        actionProvider.moveToElement(checkbox).build().perform();
        driver.findElement(By.xpath("//label[@for='hobbies-checkbox-3']")).click();
        driver.findElement(By.id("currentAddress")).sendKeys("123456 Sjhgjhgj 26");
        ((JavascriptExecutor) driver).executeScript("document.getElementById('currentAddress').rows='1'");


        WebElement buttonSubmit = driver.findElement(By.xpath("//button[@id='submit']"));
        actionProvider.moveToElement(buttonSubmit).build().perform();

        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");

        driver.findElement(By.id("submit")).click();
        Assertions.assertEquals(driver.findElement(By.xpath("//tbody//td[contains(., \"Student Name\")" +
                "]/following-sibling::td")).getText(), firstName + " " + lastName);
        Assertions.assertEquals(driver.findElement(By.xpath("//tbody//td[contains(., \"Student Email\")" +
                "]/following-sibling::td")).getText(), userEmail);

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
