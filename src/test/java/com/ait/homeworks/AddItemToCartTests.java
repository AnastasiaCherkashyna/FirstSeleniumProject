package com.ait.homeworks;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddItemToCartTests extends TestBase {

   @BeforeMethod
   public void precondition(){
       click(By.cssSelector(".ico-login"));
       type(By.cssSelector("#Email"), "Mil@gm.com");
       type(By.cssSelector("#Password"), "1234567");
       click(By.xpath("//*[@value='Log in']"));
   }

    @Test
    public void addItemToCart(){
        click(By.xpath("//div[@data-productid='31']//input[@type='button']"));
        click(By.xpath("//span[.='Shopping cart']"));
        Assert.assertTrue(isItemAddedToCartByText("14.1-inch Laptop"));

        // Var 2
        // Assert.assertTrue(isElementPresens(By.xpath("//*[text()='14.1-inch Laptop']")));
    }

@AfterMethod
    public void postCondition(){
        click(By.cssSelector("[name='removefromcart']"));
        click(By.cssSelector("[name='updatecart']"));
    }
}

