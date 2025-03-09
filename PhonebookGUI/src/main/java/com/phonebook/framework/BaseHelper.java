package com.phonebook.framework;

import com.google.common.io.Files;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BaseHelper {


    WebDriver driver;

    // конструктор нужен для того, чтобы объявить то, что было инициализировано
    public BaseHelper(WebDriver driver) {
        this.driver = driver;
    }

    //    пишем уникальный М c абстрактным локатором!!!
    // теперь не надо на каждый локатор писать методы!!
    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    // в метод type мы объединили три строки (click, clear, sendKeys)
    public void type(By locator, String text) {
        if (text != null) {
            click(locator);
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }
    }

    // тк у нас очень много одинаковых строк (разные лишь локаторы), можно оптимизировать
    // напрмиер создать метод ckick!! 1. выелаем метод, жмем лампочку, рефактор метод - называем его click
    // 2. создавшийся метод меняем на public, выделяем  начинку метода, там, где прописан какой-то конкретный локатор
    // 3. снова лампочка - рефактор - параметр = и прописываем вместо уникаьного локатора слово locator - заменяем везде
    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public boolean isAlertPresent() {
        //берем интерфейс Алерт, Alert alert: Объявляется переменная типа Alert,
        // которая будет содержать ссылку на всплывающее окно
        // new WebDriverWait(driver, Duration.ofSeconds(20)): Создается новый объект WebDriverWait,
        // который позволяет установить явное ожидание. Параметры:
        //
        //driver: экземпляр WebDriver
        //
        //Duration.ofSeconds(20): максимальное время ожидания в секундах
        // .until(ExpectedConditions.alertIsPresent()): Метод until() ожидает выполнения указанного условия. E
        // ExpectedConditions.alertIsPresent() - это условие, которое проверяет наличие всплывающего окна
        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.alertIsPresent());
        if (alert == null) {
            return false;
        } else {
            // надо заствить Селениум перескочить на окошко с алертом. Сам он это не сделает
            // из нижнего слоя скачем на верний - и потом accept
            driver.switchTo().alert();
            alert.accept();
            return true;
        }
    }

    // Оборачиваем в try catch метод, чтобы сразу предупредить ошибку.
    // нам важен RunTimeExeption, чтобы видеть, что время на рабоут метода затратилось, если он упадет
    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String takeScreenshot() {
        File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File screenshot = new File("screenshots/screen-" + System.currentTimeMillis() + ".png");

        // теперь надо tmp передать в screenshot. Для этого нужен Класс из гугла
        try {
            Files.copy(tmp, screenshot);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return screenshot.getAbsolutePath();
    }
}
