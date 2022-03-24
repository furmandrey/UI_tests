package com.geekbrains.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class DemoqaTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        Actions actionProvider = new Actions(driver);
        driver.manage().window().maximize();
        //driver.manage().window().setSize(new Dimension(300, 700));
        
        driver.get("https://demoqa.com/automation-practice-form");
        driver.findElement(By.id("firstName")).sendKeys("Jon");
        driver.findElement(By.id("lastName")).sendKeys("Smith");
        driver.findElement(By.id("userEmail")).sendKeys("name@example.com");
        driver.findElement(By.xpath("//label[@for='gender-radio-1']")).click();
        driver.findElement(By.id("userNumber")).sendKeys("9101234567");
        // driver.findElement(By.id("dateOfBirthInput")).click();
        //driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']")).click();

//        for (int i = 0; i < 240; i++) {
//            driver.findElement(By.xpath("//button[@class='react-datepicker__navigation " + "react" +
//                    "-datepicker__navigation--previous']")).click();
//        }
//        driver.findElement(By.xpath("//div[@class='react-datepicker__day react-datepicker__day--008']")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.id("subjectsInput")).sendKeys("123");
        WebElement checkbox = driver.findElement(By.id("uploadPicture"));
        actionProvider.moveToElement(checkbox).build().perform();
        driver.findElement(By.xpath("//label[@for='hobbies-checkbox-3']")).click();
        driver.findElement(By.id("currentAddress")).sendKeys("123456 Sjhgjhgj 26");
        //driver.findElement(By.xpath("//div[@aria-label='Choose Thursday, February 27th, 1986']")).click();
        //driver.findElement(By.id("dateOfBirthInput")).sendKeys("23 Mar 2000");
        //cutting out footer
        ((JavascriptExecutor)driver).executeScript("var badTableEval = document.evaluate (\n" +
                "    \"//footer\",\n" +
                "    document.documentElement,\n" +
                "    null,\n" +
                "    XPathResult.FIRST_ORDERED_NODE_TYPE,\n" +
                "    null\n" +
                ");\n" +
                "\n" +
                "if (badTableEval  &&  badTableEval.singleNodeValue) {\n" +
                "    var badTable  = badTableEval.singleNodeValue;\n" +
                "    badTable.parentNode.removeChild (badTable);\n" +
                "}");
        //
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        Thread.sleep(15000);//здесь руками меняю масштаб или размер формы с адрессом после чего до кнопки доходит
//        Actions builder = new Actions(driver);
//        builder.sendKeys(Keys.chord(Keys.CONTROL, "+")).perform();

        WebElement buttonSubmit = driver.findElement(By.xpath("//button[@id='submit']"));
        actionProvider.moveToElement(buttonSubmit).build().perform();

        driver.findElement(By.id("submit")).click();

        Thread.sleep(3000);
        driver.quit();
    }
}
