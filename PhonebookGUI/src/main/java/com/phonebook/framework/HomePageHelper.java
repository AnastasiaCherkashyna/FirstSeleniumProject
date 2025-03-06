package com.phonebook.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageHelper extends BaseHelper {

    public HomePageHelper(WebDriver driver) {
        super(driver);
    }

    public boolean isHomeComponentPresent(){
        //return driver.findElements(By.xpath("//div[2]//h1")).size()>0;
        return isElementPresent(By.xpath("//div[2]//h1"));
        //любой тест ДОЛЖЕН заверашться ассертом!!  те сравнение ER & AR
        // тот М уникален лишь для этого локатора!!!
    }

    public void clickOnHomeLink() {
        click(By.cssSelector("[href='/home']"));
    }
}
