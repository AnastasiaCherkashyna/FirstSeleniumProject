package com.ait.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.time.Duration;
import java.util.List;
public class Homework0802 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
        @Test
        public void findElementByTagName() {

            List<WebElement> elementsByTagName = driver.findElements(By.tagName("a"));
            System.out.println(elementsByTagName.size());

            WebElement nameThree = driver.findElement(By.tagName("strong"));
            System.out.println(nameThree.getText());

        }

        @Test
        public void findElementByClassName(){
            WebElement classNameOne = driver.findElement(By.className("footer-disclaimer"));
            System.out.println(classNameOne.getText());

            WebElement classNameTwo = driver.findElement(By.className("footer-poweredby"));
            System.out.println(classNameTwo.getText());

            WebElement classNameThree = driver.findElement(By.className("count"));
            System.out.println(classNameThree.getText());
            // почему не отображает в консоли текст этого класса? он стоит выше остальных "count" в коде и имеет текст:
            //You have no items in your shopping cart.

            WebElement classNameFour = driver.findElement(By.className("please-wait"));
            System.out.println(classNameFour.getText()); // аналогично - не отобрадает текст в консоли
        }

        @Test
        public void findElementById(){
            WebElement idElementOne = driver.findElement(By.id("subscribe-loading-progress"));
            System.out.println(idElementOne.getText());

            WebElement idElementTwo = driver.findElement(By.id("newsletter-subscribe-block"));
            System.out.println(idElementTwo.getText());

            WebElement idElementThree = driver.findElement(By.id("poll-block-1"));
            System.out.println(idElementThree.getText());
        }

        @Test
        public void findByCssSelector(){

        driver.findElement(By.cssSelector("[href*='/apparel']"));
        driver.findElement(By.cssSelector(".header-links-wrapper>div"));
        driver.findElement(By.cssSelector(".footer-menu-wrapper>div:nth-child(2)"));

        driver.findElement(By.cssSelector("#bar-notification>span"));
        driver.findElement(By.cssSelector(".column>h3"));
        driver.findElement(By.cssSelector(".footer-poweredby>a"));

        driver.findElement(By.cssSelector(".top-menu>li:nth-child(4)"));
        driver.findElement(By.cssSelector("#mob-menu-button>a"));
        driver.findElement(By.cssSelector(".mob-top-menu>li:nth-child(4)"));

        }

        @AfterMethod
        public void tearDown(){
        driver.quit();
        }
}
