package com.phonebook.tests;

import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition(){
        if(!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSignOutButton();
        }
    }

    @Test (enabled = false)
    public void createNewUserPositiveTest(){
        app.getUser().clickOnLoginLink();
        app.getUser().fillRegistrationLoginForm(new User().setEmail("anastasia@gmail.com")
                .setPassword("Qq1!Aa1!"));
        app.getUser().clickOnRegistrationButton();
        Assert.assertTrue(app.getUser().isSignUpButtonPresent());

    }

    @Test
    public void createExistedNegativeTest(){
        app.getUser().clickOnLoginLink();
        app.getUser().fillRegistrationLoginForm(new User().setEmail("anastasia@gmail.com")
                .setPassword("Qq1!Aa1!"));;
        app.getUser().clickOnRegistrationButton();
        Assert.assertTrue(app.getUser().isAlertPresent());
    }


}
