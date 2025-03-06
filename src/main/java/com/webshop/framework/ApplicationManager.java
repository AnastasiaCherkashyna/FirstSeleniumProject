package com.webshop.framework;

import com.webshop.utils.MyListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class ApplicationManager {

    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
    String browser;
    WebDriver driver;

    UserHepler user;
    ItemHelper item;

    public ApplicationManager(String browser) {
        this.browser=browser;
    }

    public void init() {
        if(browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
            logger.info("Start Test in Chrome");
        } else if(browser.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
            logger.info("Start Test in FireFox");
        } else if(browser.equalsIgnoreCase("safari")){
            driver = new SafariDriver();
            logger.info("Start Test in Safari");
        }

        WebDriverListener listener = new MyListener();
        driver = new EventFiringDecorator<>(listener).decorate(driver);

        driver.get("https://demowebshop.tricentis.com/");
        logger.info("Current URL: " + driver.getCurrentUrl());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        user = new UserHepler(driver);
        item = new ItemHelper(driver);
    }

    public UserHepler getUser() {
        return user;
    }

    public ItemHelper getItem() {
        return item;
    }

    public void stop() {
        driver.quit();
    }

}
