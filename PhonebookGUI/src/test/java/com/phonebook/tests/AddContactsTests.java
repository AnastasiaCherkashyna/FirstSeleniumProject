package com.phonebook.tests;

import com.phonebook.models.Contact;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AddContactsTests extends TestBase{

    @BeforeMethod
    public void precondition(){
        if(!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSignOutButton();
        }
        app.getUser().clickOnLoginLink();
        app.getUser().fillRegistrationLoginForm(new User().setEmail("anastasia@gmail.com")
                .setPassword("Qq1!Aa1!"));
        app.getUser().clickOnLoginButton();

    }

    @Test
    public void addContactPositiveTest(){
        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(new Contact()
                .setName("John")
                .setLastname("Shopp")
                .setPhone("1234567890")
                .setEmail("js@js.com")
                .setCity("Hamburg")
                .setDescritption("Kollegen"));
        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().isContactAddedByText("John"));
    }

    // ПРИМЕР!!! Итератор - перебирает коллекции, листы
    //создадим списко Об, кторые будем добавлять
    @DataProvider
    public Iterator<Object[]> addNewContact() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Oliver1","Kann","1234567890","ree@gr.com","Munich","Friend"});
        list.add(new Object[]{"Oliver2","Kann","123456789012345","ree@gr.com","Munich","Friend"});
        list.add(new Object[]{"Oliver3","Kann","123456789012","ree@gr.com","Munich","Friend"});

        return list.iterator();
    }

    @Test(dataProvider = "addNewContact")
    public void addContactPositiveFromDataProviderTest(String name, String lastName, String phone,
                                                       String email, String address, String desc) {
        app.getContact().clickOnAddLink();

        app.getContact().fillContactForm(new Contact()
                .setName(name)
                .setLastname(lastName)
                .setPhone(phone)
                .setEmail(email)
                .setCity(address)
                .setDescritption(desc));

        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().isContactAddedByText(name));
    }

    @DataProvider
    public Iterator<Object[]>addContactFromCsv() throws IOException {
        List<Object[]>list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contact.csv")));

        String line = reader.readLine();
        while(line !=null){
        String[] split = line.split(",");
        list.add(new Object[]{new Contact().setName(split[0]).setLastname(split[1]).setPhone(split[2]).setEmail(split[3]).setCity(split[4]).setDescritption(split[5])});
        line = reader.readLine();
        }

        return list.iterator();
    }

    @Test(dataProvider = "addContactFromCsv")
    public void addContactPositiveFromDataProviderWithCsvTest(Contact contact) {
        app.getContact().clickOnAddLink();

        app.getContact().fillContactForm(contact);


        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().isContactAddedByText(contact.getName()));
    }

    @AfterMethod
    public void postCondition(){
        app.getUser().pause(1000);
        app.getContact().deleteContact();
    }


}
