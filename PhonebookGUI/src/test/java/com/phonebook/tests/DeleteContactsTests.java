package com.phonebook.tests;

import com.phonebook.models.Contact;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContactsTests extends TestBase{



    @BeforeMethod
    public void precondition(){
        if(!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSignOutButton();
        }
        app.getUser().clickOnLoginLink();
        app.getUser().fillRegistrationLoginForm(new User().setEmail("anastasia@gmail.com")
                .setPassword("Qq1!Aa1!"));;
        app.getUser().clickOnLoginButton();

        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(new Contact()
                .setName("John")
                .setLastname("Shopp")
                .setPhone("1234567890")
                .setEmail("js@js.com")
                .setCity("Hamburg")
                .setDescritption("Kollegen"));
        app.getContact().clickOnSaveButton();

    }

    @Test
    public void deleteContactPositiveTest(){
        //нам надо сравнить колво карточек ДО и ПОСЛЕ
        // пишем клики + создаем 2 переменных ДО и ПОСЛЕ
        // создаем метод sizeOfContacts
        int sizeBefore = app.getContact().sizeOfContacts();

        app.getContact().deleteContact();
        app.getContact().pause(1000);
        //
        int sizeAfter = app.getContact().sizeOfContacts();

        //Ассерт работает быстрее, чем Селениум и не ждет, пока он посчитает карточки. ПОтому падает тест
        // ПАУЗА метод. Нечасто, но можно использовать

        Assert.assertEquals(sizeAfter,sizeBefore-1);

    }

}


/*
    public boolean isElementPresent2(By locator) {
        try {
            driver.findElement(locator);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return true;
    }
*/