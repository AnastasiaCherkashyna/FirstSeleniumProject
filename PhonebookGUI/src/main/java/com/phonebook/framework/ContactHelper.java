package com.phonebook.framework;

import com.phonebook.models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ContactHelper extends BaseHelper{
    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void clickOnSaveButton() {
        click(By.cssSelector(".add_form__2rsm2 button"));
    }

    // Рефакторим метод в объект Contact
    public void fillContactForm(Contact contact) {
        type(By.xpath("//input[1]"), contact.getName());
        type(By.xpath("//input[2]"), contact.getLastname());
        type(By.xpath("//input[3]"), contact.getPhone());
        type(By.xpath("//input[4]"), contact.getEmail());
        type(By.xpath("//input[5]"), contact.getCity());
        type(By.xpath("//input[6]"), contact.getDescritption());
    }

    public void clickOnAddLink() {
        click(By.cssSelector("[href='/add']"));
    }

    // т.к. новые карточки создаются с одинаковыми тегами и образуют массив
    // мы пишем метод, ктороы проверит, слдалось ли наше имя (карточка), проходясь по МАССИВУ!!
    public boolean isContactAddedByText (String text) {
       // driver.findElements(By.cssSelector("h2"));
        List<WebElement> contacts = driver.findElements(By.cssSelector("h2"));
        //перебираем массив через цикл
        for(WebElement element : contacts){
            if(element.getText().contains(text)) return true;
        }
        return false;
    }

    public void deleteContact() {
        click(By.cssSelector(".contact-item_card__2SOIM"));
        click(By.xpath("//*[.='Remove']"));
    }

    public int sizeOfContacts(){
        if(isElementPresent(By.cssSelector(".contact-item_card__2SOIM"))) {
            return driver.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();
        }
        return  0;
    }
}
