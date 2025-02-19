package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{

    @Test
    public void newUserRegistration(){
        //click on Register link
        click(By.cssSelector(".ico-register"));
        //enter firstname
        type(By.xpath("//*[@id='FirstName']"), "Mila");
        //enter lastname
        type(By.xpath("//*[@id='LastName']"), "Tong");
        //enter email with @
        type(By.xpath("//*[@id='Email']"), "Mila@gm.com");
        //enter password min 6 char
        type(By.xpath("//*[@id='Password']"), "1234567");
        //enter password one more time
        type(By.xpath("//*[@id='ConfirmPassword']"), "1234567");
        //click Register button
        click(By.cssSelector("[name='register-button']"));

        //assert: Link with Email appears on NaviBAr
        Assert.assertTrue(isElementPresens());
    }
}



