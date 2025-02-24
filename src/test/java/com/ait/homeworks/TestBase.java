package com.ait.homeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TestBase {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterMethod (enabled = false)
    public void tearDown(){
        driver.quit();
    }

    public boolean isElementPresens(By locator){
        driver.findElement(locator);
        return true;
    }

    public boolean isTextPresens(By locator){
        driver.findElement(locator);
        return true;
    }

    public void type(By locator, String text) {
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public boolean isItemAddedToCartByText(String text){
        List<WebElement> items = driver.findElements(By.cssSelector(".product-name"));

        for (WebElement element : items){
            if(element.getText().contains(text))
                return true;
            }
        return false;
    }
}
