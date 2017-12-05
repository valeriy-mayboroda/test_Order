package qatestlab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartPage extends ProductPage {
    private By cartQuantity = By.name("product-quantity-spin");
    private By orderButton = By.cssSelector(".cart-detailed-actions .text-xs-center a");

    @Test(dependsOnMethods = "clickAddAndGoToCart")
    public void checkQuantityAndClickOrder() {
        checkCartQuantity();
        clickOrderButton();
    }

    public void checkCartQuantity() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartQuantity));
        Assert.assertEquals(driver.findElement(cartQuantity).getAttribute("value"), "1");

        Assert.assertEquals(driver.findElement(By.className("product-price")).getText().split(" ")[0], product.getPrice());
        Assert.assertEquals(driver.findElement(By.cssSelector(".product-image > img")).getAttribute("alt").toLowerCase(), product.getName().toLowerCase());


     }

    public void clickOrderButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(orderButton));
        driver.findElement(orderButton).click();
    }
}
