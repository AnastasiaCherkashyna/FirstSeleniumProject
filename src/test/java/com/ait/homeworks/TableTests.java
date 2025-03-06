package com.ait.homeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TableTests {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/css/css_table.asp");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    // Работаем с таблицами. Ищем данные
    // tr in Table - строка
    // th - header
    // td - ячейки

    @Test
    public void findTableElementWithCss(){
        // print numbers od rows
        List<WebElement> rows = driver.findElements(By.cssSelector("tr"));
        System.out.println(rows.size());
        // попробуем вывести текст. Работает через цикл FOR (2 варианта)
        for(WebElement element: rows){
            System.out.println(element.getText());
        }
        System.out.println("**************");
        for (int i = 0; i < rows.size() ; i++) {
            System.out.println(rows.get(i).getText());
        }

        //get row 4 - получить текст с ряда 4
        WebElement row4 = driver.findElement(By.cssSelector("tr:nth-child(4)")); //tr[4]
        System.out.println(row4.getText());

        // найти именно ячейку из таблицы, а не строку! row4, second element
        WebElement row4td2 = driver.findElement(By.cssSelector("tr:nth-child(4) td:nth-child(2)")); //tr[4]//td[2]
        System.out.println(row4td2.getText());
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
