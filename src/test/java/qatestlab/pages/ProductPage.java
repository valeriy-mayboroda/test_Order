package qatestlab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import qatestlab.model.Product;

public class ProductPage extends ShopAllProductsPage {
    private By addToCartButton = By.cssSelector("button.btn-primary");
    private By cartLink = By.cssSelector("a.btn-primary");
    private By productName = By.className("h1");
    private By productPrice = By.className("current-price");
    private By productDetails = By.cssSelector("[href=\"#product-details\"]");
    protected Product product;

    @Test(dependsOnMethods = "clickRandomProduct")
    public void saveProductBeforeOrder() {
        product = new Product();
        product.setName(getProductName());
        product.setPrice(getProductPrice());
    }

    @Test(dependsOnMethods = "saveProductBeforeOrder")
    public void clickAddAndGoToCart() {
        clickAddToCartButton();
        clickGoToCartLink();
    }

    public void clickAddToCartButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartButton));
        driver.findElement(addToCartButton).click();
    }

    public void clickGoToCartLink() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartLink));
        driver.findElement(cartLink).click();
    }

    public void clickProductDetails() {driver.findElement(productDetails).click();}

    public String getProductName() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productName));
        return driver.findElement(productName).getText();
    }

    public String getProductPrice() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productPrice));
        return driver.findElement(productPrice).findElement(By.tagName("span")).getText().split(" ")[0];
    }
}
