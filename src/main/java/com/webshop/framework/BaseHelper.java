package com.webshop.framework;

import com.google.common.io.Files;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class BaseHelper {


    WebDriver driver;
    public BaseHelper(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isElementPresens(By locator){
        driver.findElement(locator);
        return true;
    }

    public void type(By locator, String text) {
        if(text != null) {
            click(locator);
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }
    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public String takeScreenshot(){
        File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File screenshot = new File("screenshots/screen-" + System.currentTimeMillis() + ".png");

        try {
            Files.copy(tmp,screenshot);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return screenshot.getAbsolutePath();
    }
    }


