package com.ait.demowebshop.test;

import com.github.javafaker.Faker;
import com.webshop.framework.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Browser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.util.Arrays;

public class TestBase {

    Logger logger = LoggerFactory.getLogger(TestBase.class);
    @BeforeMethod
    public void startTest(Method method, Object[] p){
        logger.info("Start Test" + method.getName() + "with data: " + Arrays.asList(p));
    }

    @AfterMethod
    public void stopTest(ITestResult result){
        if (result.isSuccess()) {
            logger.info("PASSED:" + result.getMethod().getMethodName());
        } else {
            logger.error("FAILED:" + result.getMethod().getMethodName() + "screenshot" + app.getUser().takeScreenshot());
        }
        logger.info("Stop Test");
    }


    protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser", Browser.CHROME.browserName()));
    WebDriver driver;
    @BeforeSuite
    public void setUp(){
        app.init();
    }

    @AfterSuite
    public void tearDown(){
        app.stop();
    }



}
