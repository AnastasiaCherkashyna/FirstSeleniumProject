package com.phonebook.tests;

import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.phonebook.framework.ApplicationManager.softAssert;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition(){
        if(!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSignOutButton();
        }
    }
    @Test
    public void loginPositiveTest(){

        app.getUser().clickOnLoginLink();
        app.getUser().fillRegistrationLoginForm(new User()
                .setEmail("anastasia@gmail.com")
                .setPassword("Qq1!Aa1!"));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isSignUpButtonPresent());

    }

    // чтобы создать тест с пустым имейлом, надо создать Объект User
    // тк мы не можем в методе fillRegistrationLoginForm просто НЕ ВВОдИТЬ имейл. ТАк не сработает.
    //идем в TestBase, кликаем метод fillRegistrationLoginForm -> Refactor ->Introduce Object
    // name User --> OK
    // вызываем и идем в Класс User (там продолжение комментов)

    // после класса Юзер идем снова сюда
    // теперь мы можем потянуть ТОЛЬКО 1 поле!! Пароль. Это в негативном тесте! А логин вообщ не писать
    // дальше возникнет конфликт в методе type! Идем в него и меняем. Тк без имейла он видит поле email как null
    // а это exception
    @Test
    public void loginNegativeWithoutEmailTest(){

        app.getUser().clickOnLoginLink();
        app.getUser().fillRegistrationLoginForm(new User().setPassword("Qq1!Aa1!"));
        app.getUser().clickOnLoginButton();

        // в данном случае лучше не писать более 1 ассерта, а разделить тесты в зависимости от ER
        // если оставим хард Асерты - если первый упадет, остальные тоже!
        softAssert.assertTrue(app.getUser().isAlertPresent());
        softAssert.assertTrue(app.getUser().isErrorMessagePresens());
        softAssert.assertAll(); // ОБЯЗАТЕЛЬНО эта строка, если делаем софты
    }

}
