package com.ait.homeworks;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExistedUserLogin extends TestBase {

    @Test
    public void existedUserLogin(){
        click(By.cssSelector(".ico-login"));
        type(By.cssSelector("#Email"), "Mil@gm.com");
        type(By.cssSelector("#Password"), "1234567");
        click(By.xpath("//*[@value='Log in']"));
        Assert.assertTrue(isElementPresens(By.xpath("//*[.='Mil@gm.com']")));
    }
}
