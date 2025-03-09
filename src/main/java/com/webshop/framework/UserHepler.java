package com.webshop.framework;

import com.github.javafaker.Faker;
import com.webshop.framework.BaseHelper;
import com.webshop.models.NewUser;
import com.webshop.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHepler extends BaseHelper {
    public UserHepler(WebDriver driver) {
        super(driver);
    }



    public void ckickOnRegistrationButton() {
        click(By.cssSelector("[name='register-button']"));
    }

    public void fillRegistrationForm(NewUser newUser) {



        type(By.xpath("//*[@id='FirstName']"), newUser.getFirstName());
        //enter lastname
        type(By.xpath("//*[@id='LastName']"), newUser.getLastName());
        //enter email with @
        type(By.xpath("//*[@id='Email']"), newUser.getEmail());
        //enter password min 6 char
        type(By.xpath("//*[@id='Password']"), newUser.getPassword());
        //enter password one more time
        type(By.xpath("//*[@id='ConfirmPassword']"), newUser.getConfirmPassword());
    }

    public void clickOnRegistrationLink() {
        click(By.cssSelector(".ico-register"));
    }

    public void clickOnLoginButton() {
        click(By.xpath("//*[@value='Log in']"));
    }

    public void fillLoginForm(User user) {
        type(By.cssSelector("#Email"), user.getEmail());
        type(By.cssSelector("#Password"), user.getPassword());
    }

    public void clickOnLoginLink() {
        click(By.cssSelector(".ico-login"));
    }

    public boolean isLogOutLinkPresent() {
        return isElementPresens(By.cssSelector(".ico-logout"));
    }

    public void clickOnLogOutLink() {
        click(By.cssSelector(".ico-logout"));
    }
}
