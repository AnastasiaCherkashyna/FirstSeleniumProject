package com.ait.demowebshop.test;

import com.webshop.models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddItemToCartTests extends TestBase {

   @BeforeMethod
   public void precondition(){
       app.getUser().clickOnLoginLink();
       app.getUser().fillLoginForm(new User().setEmail("Mil@gm.com").setPassword("1234567"));
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
    }
}

