package com.ait.demowebshop.test;

import com.webshop.models.NewUser;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @Test
    public void newUserRegistration(){
        app.getUser().clickOnRegistrationLink();
        app.getUser().fillRegistrationForm(new NewUser().setFirstName("Milok")
                .setLastName("Tong")
                .setEmail("Milok@gm.com")
                .setPassword("1234567")
                .setConfirmPassword("1234567"));
        app.getUser().ckickOnRegistrationButton();
        Assert.assertTrue(app.getUser().isLogOutLinkPresent());
    }

}



