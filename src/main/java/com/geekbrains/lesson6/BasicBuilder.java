package com.geekbrains.lesson6;

import org.openqa.selenium.WebDriver;

public class BasicBuilder {
    private WebDriver driver;

    public BasicBuilder setDriver(WebDriver driver) {
        this.driver = driver;
        return this;
    }

    public Basic createBasic() {
        return new Basic(driver);
    }
}