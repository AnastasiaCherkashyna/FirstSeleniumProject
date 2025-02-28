package com.ait.homeworks;

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

public class FirstSeleniumTest {

    //before = setUp (init) это предусловие, что происз ДО
    // между ДО и ПОСЛЕ находятся тесты
    //test

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        // стандарт набор методов в Before (4 шт):
        driver = new ChromeDriver();
        driver.get("https://ilcarro.web.app"); // метод открывает конкрет страницу. Без истории. Это нам важно! будто впервые используем
        // методы, кот развораивают браузеры на весь экран
        driver.manage().window().maximize();
        // явное и неявное ожидание - ждем пока все элементы стр загрузятся, прежде чем наченм тестировать
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        // driver.navigate().to("https://ilcarro.web.app"); // откр сайта с историей
        // driver.navigate().back();
    }

    @Test
    public void openChromeTest(){
        System.out.println("Browser opens!");
    }

    @Test
    public void findElementByTagName(){
        WebElement element = driver.findElement(By.tagName("h1"));
        System.out.println(element.getText());

        WebElement element2 = driver.findElement(By.tagName("h2"));
        System.out.println(element2.getText());

        //driver.findElement(By.tagName("a")); option+Enter = получаем готовую переменную
        WebElement element3 = driver.findElement(By.tagName("a"));
        System.out.println(element3.getText());

        List<WebElement> elements = driver.findElements(By.tagName("a"));
        System.out.println(elements.size());
    }


    @Test
    public void findElemetById(){
        WebElement elementId = driver.findElement(By.id("city"));
        System.out.println(elementId);

        WebElement dates = driver.findElement(By.id("dates"));
        System.out.println(dates);

    }

    @Test
    public void findElementByClassName(){
       // driver.findElement(By.className("header")); opt + Enter
        WebElement header = driver.findElement(By.className("header"));
        System.out.println(header.getText());

        List<WebElement> classElements = driver.findElements(By.className("logo"));
        System.out.println(classElements.size());
    }
    @Test
    public void findElementByCssSelector(){
        // tagName -> css
        //driver.findElement(By.tagName("h1"));
        driver.findElement(By.cssSelector("h1"));

        //id -> css - #
       // driver.findElement(By.id("city"));
        driver.findElement(By.cssSelector("#city"));

        // className-> css - .
        //driver.findElement(By.className("header"));
        driver.findElement(By.cssSelector(".header"));

        //если надо найти сразу пару значений (Ключ, значение). Они в коде рядом стоят
        // ВНИМАНИЕ НА СИНТАКСИС!
        // "[key='value']"
        driver.findElement(By.cssSelector("[type='submit']"));
        driver.findElement(By.cssSelector("[href='/search']"));

        driver.findElement(By.cssSelector("[for='dates']"));
        // contains *  = ищи везде
        driver.findElement(By.cssSelector("[href*='results?']"));
        driver.findElement(By.cssSelector("[href^='/let']"));
        driver.findElement(By.cssSelector("[href$='Paris']"));

        // объединяем классы, тэги и тп вместе
        driver.findElement(By.cssSelector(".logo>img")); // это если на шаг ниже идем
        driver.findElement(By.cssSelector(".logo img")); // значит - ищи во всем классе Лого

        //увидеть все кнопки Нави панели. Они как дети сидят в одном классе
        //вызываем класс и через :nth-child пишем номер реберка, который хо проверить (5)
        driver.findElement(By.cssSelector(".navigation-link:nth-child(5)"));

        driver.findElement(By.cssSelector(".title:nth-child(2)"));
        driver.findElement(By.cssSelector(".top-cities>a:nth-child(1)"));

    }

    @Test
    public void findElementByXpath(){

        // XPATH может искать текст в любом элементе, в кот содержится текс!
        // cssSelector так НЕ МОЖЕТ
        // начинаем Xpath with "//tag" OR "//*[@key='value']" OR "//tagname[@key='value']"
        driver.findElement(By.xpath("//h1"));

        driver.findElement(By.xpath("//*[@id='city']"));
        driver.findElement(By.xpath("//input[@id='city']"));

        driver.findElement(By.xpath("//*[@class='header']"));

        driver.findElement(By.xpath("//*[@type='submit']"));
        driver.findElement(By.xpath("//*[@href='/search']"));
        //*[@for='dates']

        // contains text!!! //*[contains(сюда вписывается метод ТЕКСТ, но мы заменяем точкой и ,)
        driver.findElement(By.xpath("//*[contains(.,'Find your')]")); //не работ, если сайт multilanguage!
        driver.findElement(By.xpath("//*[text()='Find your car now!']")); // А этот вар рабоатет как EQUALS!!
        // вводим точно соответствие!!

        // OR вместо text() - ставим точку!!
        driver.findElement(By.xpath("//*[.='Find your car now!']"));

        // contains text
        driver.findElement(By.xpath("//*[contains(@href,'results?')]"));

        //start with - поиск результата по методу stars-with()
        driver.findElement(By.xpath("//*[start-with(@href,'/let')]"));


        /* Переходы к дочерним элементам:
        //div/a   - переход на 1 шаг ниже
        //div//a  - переход на любой уровень ниже по дереву

        Ход наверх
        //input[@id='idName']/..  - две точки это ход наверх!! Как в Linux

        <movie stream>
            <movie>
                <title lang="2n@>Tenet</title>
                <direcrot>Nolan</director>
                <year>2020</year>
            </movie>
        </movie stream>

        descendant - наследник, узлы с одим и тем де родителем
        ancestor - предок - movie, movie stream

        title:first-child  - поиск первого ребенка! -> //movie/title[1]

        tag1#id>tag2 li:last-child --> //tag1[@id='idName']/tag2//li[last()]
         */

        driver.findElement(By.xpath("//h1/.."));
        driver.findElement(By.xpath("//h1/parent::*")); // альтернатива!!
        driver.findElement(By.xpath("//h1/parent::div"));
        driver.findElement(By.xpath("//h1/ancestor::div")); // идем на 2 шага выше, нашли первого предка
        driver.findElement(By.xpath("//h1/ancestor::div[2]")); // идем на 1 шаг выше


    }

    //after = tearDown ПОСЛЕ
    @AfterMethod
            // @AfterMethod(enabled = false) - тогда этот метод перестанет работать, т.е. сайт не закроется и мы можем
            // отследить что произошло в методе. Иначе все быстро происходит и сайт закрывается!
    public void tearDown(){
        driver.quit(); // закрываются все вкладки
       // driver.close(); - закроется только 1 текущая вкладка, браузер останется открытым
    }
}
