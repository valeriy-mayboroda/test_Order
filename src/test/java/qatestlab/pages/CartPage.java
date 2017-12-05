package qatestlab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartPage extends ProductPage {
    private By cartQuantity = By.name("product-quantity-spin");
    private By orderButton = By.cssSelector(".cart-detailed-actions .text-xs-center a");

    @Test(dependsOnMethods = "doProductPage")
    public void checkQuantityAndClickOrder() {
        checkCartDetails();
        clickOrderButton();
    }

    public void checkCartDetails() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartQuantity));
        //There is one quantity of products is displayed
        Assert.assertEquals(driver.findElement(cartQuantity).getAttribute("value"), "1");
        //Checking the price before adding to the cart and the price on the cart form
        Assert.assertEquals(driver.findElement(By.className("product-price")).getText().split(" ")[0], product.getPrice());
        //Checking the name before adding to the cart and the name on the cart form
        Assert.assertEquals(driver.findElement(By.cssSelector(".product-image > img")).getAttribute("alt").toLowerCase(), product.getName().toLowerCase());
     }

    public void clickOrderButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(orderButton));
        driver.findElement(orderButton).click();
    }
}
