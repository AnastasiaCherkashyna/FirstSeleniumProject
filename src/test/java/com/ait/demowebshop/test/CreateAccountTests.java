package com.ait.demowebshop.test;

import com.webshop.models.NewUser;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @Test
    public void newUserRegistration(){


        app.getUser().clickOnRegistrationLink();
        app.getUser().fillRegistrationForm(new NewUser().setFirstName("Milok13")
                .setLastName("Tong")
                .setEmail(app.getUser().getRandomEmail())
                .setPassword("12345678")
                .setConfirmPassword("12345678"));
        app.getUser().ckickOnRegistrationButton();
        app.getUser().pause(1000);
        Assert.assertTrue(app.getUser().isLogOutLinkPresent());
    }

    /*

    @DataProvider
    public Iterator<Object[]> addNewRegistration(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Sara","Koch","sara@gm.com","1234567","1234567"});
        list.add(new Object[]{"Sara1","Kochhhhhhhhhhhhhhhhhhh","sara1@gm.com","1234567","1234567"});
        list.add(new Object[]{"Sara2","Koch","sara2@gm.com","123456789012345","123456789012345"});
        list.add(new Object[]{"Sara3","Koch","sara3@gm.com","1234567890","1234567890"});


        return list.iterator();
    }


    @Test(dataProvider = "addNewRegistration")
    public void newUserRegistrationFromDataProvider(String name, String lastName, String email,
                                                    String password, String repeatPassword){
        app.getUser().clickOnRegistrationLink();
        app.getUser().fillRegistrationForm(new NewUser().setFirstName(name)
                .setLastName(lastName)
                .setEmail(email)
                .setPassword(password)
                .setConfirmPassword(repeatPassword));
        app.getUser().ckickOnRegistrationButton();
        app.getUser().pause(1000);
        Assert.assertTrue(app.getUser().isLogOutLinkPresent());
    }

      */

    @AfterMethod
    public void postCondition(){
        app.getUser().clickOnLogOutLink();
    }

}



