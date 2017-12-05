package qatestlab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by val on 05.12.2017.
 */
public class OrderFinishPage extends OrderPage {
    private By orderDetails = By.className("order-line");
    private By checkSuccessText = By.cssSelector("#content-hook_order_confirmation .card-title");
    private String successMessage = "ваш заказ подтверждён";
    private By checkProductName = By.cssSelector(".col-sm-4 > span:nth-child(1)");
    private By checkProductPrice = By.xpath("//*[@id=\"order-items\"]//table[2]//tr[3]/td[2]");

    @Test(dependsOnMethods = "doOrderPage")
    public void checkOrderDetails() {
        checkOrderSuccessText();
        checkProductDetails();
    }

    public void checkOrderSuccessText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkSuccessText));
        Assert.assertTrue(driver.findElement(checkSuccessText).getText().toLowerCase().contains(successMessage));
    }

    public void checkProductDetails() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(orderDetails));
        Assert.assertEquals(driver.findElements(orderDetails).size(), 1);
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkProductName));
        Assert.assertEquals(driver.findElement(checkProductName).getText().toLowerCase().split(" - size ")[0], product.getName().toLowerCase());
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkProductPrice));
        Assert.assertEquals(driver.findElement(checkProductPrice).getText().split(" ")[0], product.getPrice());
    }
}
