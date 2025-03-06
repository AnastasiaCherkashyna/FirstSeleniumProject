package com.phonebook.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class ApplicationManager {

    String browser;
    WebDriver driver;

    // BaseHelper здесь не нужен!! Он создан только для того, чтобы объед универс методы
    // объявляем только адрессные М, привязанные к сущностям типа UserHelper, ContactHelper
    UserHelper user;
    ContactHelper contact;
    HomePageHelper homePage;

    public ApplicationManager(String browser) {
        this.browser=browser;
    }
    //  сделали геттеры
    public UserHelper getUser() {
        return user;
    }

    public ContactHelper getContact() {
        return contact;
    }

    public HomePageHelper getHomePage() {
        return homePage;
    }

    // SOFT ASSERT
    public static SoftAssert softAssert = new SoftAssert();
    public void init() {
        if(browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if(browser.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        } else if(browser.equalsIgnoreCase("safari")){
            driver = new SafariDriver();
        }

        driver.get("https://telranedu.web.app");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        user = new UserHelper(driver);
        contact = new ContactHelper(driver);
        homePage = new HomePageHelper(driver);
    }

    public void stop() {
        driver.quit();
    }

}
