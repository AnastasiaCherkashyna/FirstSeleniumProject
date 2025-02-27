package com.ait.demowebshop.test;

import com.webshop.framework.ApplicationManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    protected static ApplicationManager app = new ApplicationManager();
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        app.init();
    }

    @AfterMethod (enabled = true)
    public void tearDown(){
        app.stop();
    }

}
