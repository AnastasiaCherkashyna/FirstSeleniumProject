package com.ait.demowebshop.test;

import com.webshop.data.UserData;
import com.webshop.models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddItemToCartTests extends TestBase {

   @BeforeMethod
   public void precondition(){
       app.getUser().clickOnLoginLink();
       app.getUser().fillLoginForm(new User().setEmail(UserData.EMAIL).setPassword(UserData.PASSWORD));
       app.getUser().clickOnLoginButton();
   }

    @Test
    public void addItemToCart(){
        app.getItem().clickOnItemButton();
        app.getItem().clickOnShoppingCartLink();
        Assert.assertTrue(app.getItem().isItemPresentInShoppingCart());
    }

    @AfterMethod
    public void postCondition(){
        app.getItem().deleteItemFromShoppingCart();
        app.getUser().clickOnLogOutLink();
    }
}

