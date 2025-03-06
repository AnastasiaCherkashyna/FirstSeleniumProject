package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition(){
        if(!app.getHomePage().isHomeComponentPresent()){
            app.getHomePage().clickOnHomeLink();
        }
    }
    @Test
    public void isHomeComponentPresentTest(){
        //isHomeComponentPresent(); // создаем метод!! А ниже прописываем что он должен вернуть
       // driver.findElement(By.xpath("//div[2]//h1"));
        //System.out.println("Home Component "+ isHomeComponentPresent());
        Assert.assertTrue(app.getHomePage().isHomeComponentPresent());
    }


}
