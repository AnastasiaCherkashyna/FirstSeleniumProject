package com.webshop.framework;

import com.webshop.framework.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ItemHelper extends BaseHelper {
    public ItemHelper(WebDriver driver) {
        super(driver);
    }

    public boolean isTextPresens(By locator){
        return isElementPresens(locator);
    }

    public boolean isItemAddedToCartByText(String text){
        List<WebElement> items = driver.findElements(By.cssSelector(".product-name"));

        for (WebElement element : items){
            if(element.getText().contains(text))
                return true;
            }
        return false;
    }

    public boolean isItemPresentInShoppingCart() {
        return isItemAddedToCartByText("14.1-inch Laptop");
    }

    public void clickOnShoppingCartLink() {
        click(By.xpath("//span[.='Shopping cart']"));
    }

    public void clickOnItemButton() {
        click(By.xpath("//div[@data-productid='31']//input[@type='button']"));
    }

    public void deleteItemFromShoppingCart() {
        click(By.cssSelector("[name='removefromcart']"));
        click(By.cssSelector("[name='updatecart']"));
    }
}
