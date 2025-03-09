package com.ait.demowebshop.test;

import com.webshop.data.UserData;
import com.webshop.models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExistedUserLoginTest extends TestBase {

    @Test
    public void existedUserLogin(){
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginForm(new User().setEmail(UserData.EMAIL).setPassword(UserData.PASSWORD));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isLogOutLinkPresent());
    }

   /* @Test
    public void loginNegativeWithoutLoginTest(){
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginForm(new User().setPassword("1234567"));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isElementPresens(By.cssSelector(".validation-summary-errors")));
    } */
}
