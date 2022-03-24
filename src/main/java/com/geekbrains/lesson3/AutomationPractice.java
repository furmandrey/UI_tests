package com.geekbrains.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.Date;


public class AutomationPractice {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com");
        driver.manage().window().maximize();
        Date expiryDate = new Date(2020, 04, 11, 9, 01, 9);
        Cookie authCooki = new Cookie("PrestaShop-a30a9934ef476d11b6cc3c983616e364",
                "WocTdgeiJPnQnxuDUreaFMMc46YkDQ" + "%2BcJI%2BlL5ORuN5RSpmc5pFF9EiKEaCG%2F70wopHlQjN8lhRPHCjUBBwKxk" + "%2F8beE23f384nH8A5gSrlMT9gl7KXbBviEOx2bAcUNQ4odM9myCHDl6CAT838s%2FyvRYuf5ozb%2BuQqa" + "%2FuQA2fVp7" + "%2F0lGfhm8plWi2%2B1CLfnuavX%2BwkwKJhqIJhMRN2Yb4%2F13nrTa" + "%2BRlsufjYh4OSesi6cZkfDFWONWiaMUqOyufWOfPoYGWmlG4KI0YwgTuJ0LQpi0nAwM6Eol9%2B0Wpf" + "%2BsoBylTnKrj" + "%2FdJVQbrJdOJYEPopLLwOsQe3bFcgPzR4uh5OrwSd2QFNHG3trSGFC" + "%2Ftu5WBdPMomTeDT0j15" +

                "%2Bz4jDlbRpAOv9JpOA37b1uy1hOyYBnrajDXrnlmWOBCyqlN0%3D000307", ".automationpractice.com", "/",
                expiryDate);
        driver.manage().addCookie(authCooki);
        driver.navigate().refresh();
        driver.findElement(By.xpath("//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li/a[" +
                ".='Dresses']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//div[@class='block_content']/ul/li//a[@title='Browse our different dresses to " +
                "choose the perfect dress for an unforgettable evening!']")).click();
        driver.findElement(By.id("layered_id_attribute_group_1")).click();//checkbox S
        driver.findElement(By.id("layered_id_attribute_group_7")).click();//checkbox Beige
        WebElement dressLink = driver.findElement(By.xpath("//ul[@class='product_list grid row']/li"));
        Actions actionProvider = new Actions(driver);
        actionProvider.moveToElement(dressLink).build().perform();
        driver.findElement(By.xpath("//span[.='Add to cart']")).click();//add to cart
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.findElement(By.xpath("//a[@class = 'btn btn-default button button-medium']")).click();
        WebElement buttonLink =
                driver.findElement(By.xpath("//a[@class = 'button btn btn-default standard-checkout " + "button" +
                        "-medium']"));
        actionProvider.moveToElement(buttonLink).build().perform();
        buttonLink.click();
        WebElement buttonLinkAdress = driver.findElement(By.xpath("//button[@class='button btn btn-default " +
                "button-medium']"));
        actionProvider.moveToElement(buttonLinkAdress).build().perform();
        buttonLinkAdress.click();
        driver.findElement(By.id("cgv")).click();
        WebElement buttonLinkShipping = driver.findElement(By.xpath("//button[@name='processCarrier']"));
        actionProvider.moveToElement(buttonLinkShipping).build().perform();
        buttonLinkShipping.click();
        WebElement btnLnkPayWire = driver.findElement(By.xpath("//a[@title='Pay by bank wire']"));
        actionProvider.moveToElement(btnLnkPayWire).build().perform();
        btnLnkPayWire.click();
        driver.findElement(By.xpath("//span[.='I confirm my order']")).click();


        Thread.sleep(2000);
        driver.quit();


    }
}
